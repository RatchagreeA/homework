package tech.kbtg.homework.dao;

import tech.kbtg.homework.entity.Hospital;

import java.util.List;

public interface HospitalDAO {

    Hospital HptSave(Hospital hospital);

    List<Hospital> HptFindAll();
    List<Hospital> HptFind(Integer page, Integer pageSize);

    Hospital HptFindById(Integer id);

    Hospital HptDeleteById(Integer id);

}
