package tech.kbtg.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
