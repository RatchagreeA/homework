package tech.kbtg.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kbtg.homework.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
}
