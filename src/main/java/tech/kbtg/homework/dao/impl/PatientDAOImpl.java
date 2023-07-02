package tech.kbtg.homework.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.kbtg.homework.dao.HospitalDAO;
import tech.kbtg.homework.dao.PatientDAO;
import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;
import tech.kbtg.homework.exception.NotFoundException;

import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO {
    private EntityManager entityManager;

    @Autowired
    public PatientDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Patient PtSave(Patient patient) {
        return entityManager.merge(patient);
    }
    @Override
    public List<Patient> PtFindAll() {
        TypedQuery<Patient> query = entityManager.createQuery("FROM Patient", Patient.class);
        List<Patient> patients = query.getResultList();
        return patients;
    }


}
