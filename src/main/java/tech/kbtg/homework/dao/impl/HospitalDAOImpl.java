package tech.kbtg.homework.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.kbtg.homework.dao.HospitalDAO;
import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;
import tech.kbtg.homework.exception.NotFoundException;

import java.util.List;

@Repository
public class HospitalDAOImpl implements HospitalDAO {
    private EntityManager entityManager;

    @Autowired
    public HospitalDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Hospital HptSave(Hospital hospital) {
        return entityManager.merge(hospital);
    }

    @Override
    public List<Hospital> HptFindAll() {
        TypedQuery<Hospital> query = entityManager.createQuery("FROM Hospital", Hospital.class);
        List<Hospital> hospitals = query.getResultList();
        return hospitals;
    }

    @Override
    public Hospital HptFindById(Integer id) {
        Hospital hospital = entityManager.find(Hospital.class, id);
        if (hospital == null) {
            throw new NotFoundException("Not found id " + id);
        }
        return hospital;
    }

    @Override
    public Hospital HptDeleteById(Integer id) {
        Hospital hospital = entityManager.find(Hospital.class, id);
        if (hospital == null) {
            throw new NotFoundException("Not found id " + id);
        }
        entityManager.remove(hospital);
        return hospital;
    }

//    @Override
//    public Patient PtSave(Patient patient) {
//        return entityManager.merge(patient);
//    }
//
//    @Override
//    public List<Patient> PtFindAll() {
//        TypedQuery<Patient> query = entityManager.createQuery("FROM Patient", Patient.class);
//        List<Patient> patients = query.getResultList();
//        return patients;
//    }
//
//    @Override
//    public Patient PtFindById(Integer id) {
//        Patient patient = entityManager.find(Patient.class, id);
//        if (patient == null) {
//            throw new NotFoundException("Not found id " + id);
//        }
//        return patient;
//    }
//
//    @Override
//    public Patient PtDeleteById(Integer id) {
//        Patient patient = PtFindById(id);
//        entityManager.remove(patient);
//        return patient;
//    }

}
