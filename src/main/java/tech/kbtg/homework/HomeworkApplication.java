package tech.kbtg.homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;
import tech.kbtg.homework.service.HwService;

@SpringBootApplication
public class HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(HwService hwService) {
        return runner -> {
            initData(hwService);
        };
    }

    private void initData(HwService hwService) {
        Hospital hospital1 = new Hospital("h1", "a1", 1, "e1.a@hos.com", "0000000011","small","");
        Hospital hospital2 = new Hospital("h2", "a2", 2, "e2.a@hos.com", "0000000012","medium","");
        Hospital hospital3 = new Hospital("h3", "a3", 3, "e3.a@hos.com", "0000000013","large","");

        Patient patient1 = new Patient("n1", "m1", "add1", "rat", "0123", "12345");
        Patient patient2 = new Patient("n2", "m2", "add2", "rat", "0123", "12345");
        Patient patient3 = new Patient("n3", "m3", "add3", "rat", "0123", "12345");

        patient1.setHospital(hospital1);
        patient2.setHospital(hospital2);
        patient3.setHospital(hospital3);

        hwService.PtSave(patient1);
        hwService.PtSave(patient2);
        hwService.PtSave(patient3);
    }

}
