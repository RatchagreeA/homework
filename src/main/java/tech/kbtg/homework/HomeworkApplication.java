package tech.kbtg.homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.kbtg.homework.entity.Hospital;
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
        hwService.HptSave(hospital1);
        hwService.HptSave(hospital2);
        hwService.HptSave(hospital3);
    }

}
