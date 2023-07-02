package tech.kbtg.homework.dao;

import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;

import java.util.List;

public interface PatientDAO {
    Patient PtSave(Patient patient);
    List<Patient> PtFindAll();

}
