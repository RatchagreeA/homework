package tech.kbtg.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kbtg.homework.entity.Hospital;

import java.awt.print.Pageable;
import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
//    List<Hospital> findAll(Pageable pageable);
}
