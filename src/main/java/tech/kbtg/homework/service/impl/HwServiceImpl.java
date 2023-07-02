package tech.kbtg.homework.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import tech.kbtg.homework.entity.Hospital;

import tech.kbtg.homework.exception.NotFoundException;
import tech.kbtg.homework.repo.HospitalRepository;
import tech.kbtg.homework.service.HwService;

import java.util.List;

@Service
public class HwServiceImpl implements HwService {

    private HospitalRepository hospitalRepository;


    public HwServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
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


}
