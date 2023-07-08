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
        Hospital hospital4 = new Hospital("h4", "a4", 4, "e4.a@hos.com", "0000000014","large","");
        Hospital hospital5 = new Hospital("h5", "a5", 5, "e5.a@hos.com", "0000000015","large","");
        Hospital hospital6 = new Hospital("h6", "a6", 6, "e6.a@hos.com", "0000000016","large","");
        Hospital hospital7 = new Hospital("h7", "a7", 7, "e7.a@hos.com", "0000000017","large","");
        Hospital hospital8 = new Hospital("h8", "a8", 8, "e8.a@hos.com", "0000000018","large","");
        Hospital hospital9 = new Hospital("h9", "a9", 9, "e9.a@hos.com", "0000000019","large","");
        Hospital hospital0 = new Hospital("h0", "a0", 0, "e0.a@hos.com", "0000000010","large","");

        Patient patient1 = new Patient("n1",1, "m1", "add1", "rat", "0000000021", "12345","");
        Patient patient2 = new Patient("n2",2, "m2", "add2", "rat", "0000000022", "12345","");
        Patient patient3 = new Patient("n3",3, "m3", "add3", "rat", "0000000023", "12345","");
        Patient patient4 = new Patient("n4",4, "m4", "add4", "rat", "0000000023", "12345","");
        Patient patient5 = new Patient("n5",5, "m5", "add5", "rat", "0000000023", "12345","");
        Patient patient6 = new Patient("n6",6, "m6", "add6", "rat", "0000000023", "12345","");
        Patient patient7 = new Patient("n7",7, "m7", "add7", "rat", "0000000023", "12345","");
        Patient patient8 = new Patient("n8",8, "m8", "add8", "rat", "0000000023", "12345","");
        Patient patient9 = new Patient("n9",9, "m9", "add9", "rat", "0000000023", "12345","");
        Patient patient0 = new Patient("n0",0, "m0", "add0", "rat", "0000000023", "12345","");

        patient1.setHospital(hospital1);
        patient2.setHospital(hospital2);
        patient3.setHospital(hospital3);
        patient4.setHospital(hospital1);
        patient5.setHospital(hospital2);
        patient6.setHospital(hospital3);
        patient7.setHospital(hospital7);
        patient8.setHospital(hospital8);
        patient9.setHospital(hospital9);
        patient0.setHospital(hospital0);

        hwService.HptSave(hospital0);
        hwService.HptSave(hospital1);
        hwService.HptSave(hospital2);
        hwService.HptSave(hospital3);
        hwService.HptSave(hospital4);
        hwService.HptSave(hospital5);
        hwService.HptSave(hospital6);
        hwService.HptSave(hospital7);
        hwService.HptSave(hospital8);
        hwService.HptSave(hospital9);

//        hwService.PtSave(patient1);
//        hwService.PtSave(patient2);
//        hwService.PtSave(patient3);
    }

}
