package tech.kbtg.homework.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tech.kbtg.homework.dao.HospitalDAO;
import tech.kbtg.homework.dao.PatientDAO;
import tech.kbtg.homework.entity.Hospital;

import tech.kbtg.homework.entity.Patient;
import tech.kbtg.homework.exception.NotFoundException;
import tech.kbtg.homework.repo.HospitalRepository;
import tech.kbtg.homework.repo.PatientRepository;
import tech.kbtg.homework.service.HwService;

import java.util.List;

@Service
public class HwServiceImpl implements HwService {

private HospitalDAO hospitalDAO;
    private HospitalRepository hospitalRepository;
    private PatientRepository patientRepository;

    public HwServiceImpl(HospitalDAO hospitalDAO, HospitalRepository hospitalRepository, PatientRepository patientRepository) {
        this.hospitalDAO = hospitalDAO;
        this.hospitalRepository = hospitalRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public Hospital HptSave(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> HptFindAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public List<Hospital> HptFind(Integer page, Integer pageSize) {
        page--;
        page = Math.max(page,0);
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Hospital> repositoryAll = hospitalRepository.findAll(pageRequest);
        return repositoryAll.getContent();
//        return hospitalDAO.HptFind(page,pageSize);
    }

    @Override
    public Hospital HptFindById(Integer id) {
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        if (hospital == null) {
            throw new NotFoundException("Not found id " + id);
        }
        return hospital;
    }

    @Override
    @Transactional
    public Hospital HptDeleteById(Integer id) {
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        if (hospital == null) {
            throw new NotFoundException("Not found id " + id);
        }
        hospitalRepository.deleteById(id);
        return hospital;
    }

    @Override
    @Transactional
    public Patient PtSave(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public List<Patient> PtFindAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient PtFindById(Integer id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) {
            throw new NotFoundException("Not found id " + id);
        }
        return patient;
    }

    @Override
    public Patient PtDeleteById(Integer id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) {
            throw new NotFoundException("Not found id " + id);
        }
        patientRepository.deleteById(id);
        return patient;
    }


}
