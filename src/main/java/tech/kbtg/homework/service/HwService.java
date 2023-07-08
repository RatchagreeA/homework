package tech.kbtg.homework.service;

import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;


import java.util.List;

public interface HwService {
    Hospital HptSave(Hospital hospital);
    List<Hospital> HptFindAll();
    List<Hospital> HptFind(Integer page, Integer pageSize);
    Hospital HptFindById(Integer id);
    Hospital HptDeleteById(Integer id);

    Patient PtSave(Patient patient);
    List<Patient> PtFindAll();
    Patient PtFindById(Integer id);
    Patient PtDeleteById(Integer id);


}
