package tech.kbtg.homework.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.kbtg.homework.dao.HospitalDAO;

import tech.kbtg.homework.entity.Hospital;

import tech.kbtg.homework.service.HwService;

import java.util.List;

@Service
public class HwServiceImpl implements HwService {
    private HospitalDAO hospitalDAO;


    public HwServiceImpl(HospitalDAO hospitalDAO) {
        this.hospitalDAO = hospitalDAO;
    }

    @Override
    @Transactional
    public Hospital HptSave(Hospital hospital) {
        return hospitalDAO.HptSave(hospital);
    }

    @Override
    public List<Hospital> HptFindAll() {
        return hospitalDAO.HptFindAll();
    }

    @Override
    public Hospital HptFindById(Integer id) {
        return hospitalDAO.HptFindById(id);
    }

    @Override
    @Transactional
    public Hospital HptDeleteById(Integer id) {
        return hospitalDAO.HptDeleteById(id);
    }

//    @Override
//    @Transactional
//    public Patient PtSave(Patient patient) {
//        return patientDAO.PtSave(patient);
//    }
//
//    @Override
//    public List<Patient> PtFindAll() {
//        return patientDAO.PtFindAll();
//    }
//
//    @Override
//    public Patient PtFindById(Integer id) {
//        return patientDAO.PtFindById(id);
//    }
//
//    @Override
//    @Transactional
//    public Patient PtDeleteById(Integer id) {
//        return patientDAO.PtDeleteById(id);
//    }

}
