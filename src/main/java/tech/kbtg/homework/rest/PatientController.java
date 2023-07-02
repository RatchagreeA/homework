package tech.kbtg.homework.rest;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;
import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;
import tech.kbtg.homework.lib.InputHospital;
import tech.kbtg.homework.lib.InputPatient;
import tech.kbtg.homework.service.HwService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private HwService hwService;

    public PatientController(HwService hwService) {
        this.hwService = hwService;
    }

    @GetMapping("")
    public List<Patient> getHospitals(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String relatives,
            @RequestParam(required = false) String contact,
            @RequestParam(required = false) String time,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String hospital
    ) {

        List<Patient> patients = hwService.PtFindAll();
        if (name != null && !name.equals("")) {
            patients = patients.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
        }
        if (age != null) {
            patients = patients.stream().filter(p -> p.getAge()==age).collect(Collectors.toList());
        }
        if (gender != null && !gender.equals("")) {
            patients = patients.stream().filter(p -> p.getName().equals(gender)).collect(Collectors.toList());
        }
        if (address != null && !address.equals("")) {
            patients = patients.stream().filter(p -> p.getAddress().contains(address)).collect(Collectors.toList());
        }
        if (relatives != null && !relatives.equals("")) {
            patients = patients.stream().filter(p -> p.getRelatives().contains(relatives)).collect(Collectors.toList());
        }
        if (contact != null && !contact.equals("")) {
            patients = patients.stream().filter(p -> p.getContact().equals(contact)).collect(Collectors.toList());
        }
        if (time != null && !time.equals("")) {
            patients = patients.stream().filter(p -> p.getTime().equals(time)).collect(Collectors.toList());
        }
        if (status != null && !status.equals("")) {
            patients = patients.stream().filter(p -> p.getStatus().equals(status)).collect(Collectors.toList());
        }
        if (hospital != null && !hospital.equals("")) {
            patients = patients.stream().filter(p -> p.getHospital().equals(hospital)).collect(Collectors.toList());
        }
        return patients;
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return hwService.PtFindById(id);
    }

    @PostMapping("")
    public List<Patient> addPatient(@RequestBody List<Patient> patients) {

        for (Patient patient:patients){
            if (!InputPatient.isValid(patient)) {
                throw new RuntimeException("Bad request");
            }
        }
        patients.forEach(p -> hwService.PtSave(p));
        return patients;
    }

    @PutMapping("")
    public List<Patient> updatePatientById(@RequestBody List<Patient> patients) {
        for (Patient patient:patients){
            if (!InputPatient.isValid(patient)|| patient.getId() == null) {
                throw new RuntimeException("Bad request");
            }
        }
        for (Patient patient:patients){
            Patient pt = hwService.PtFindById(patient.getId());
            pt.setName(patient.getName());
            pt.setGender(patient.getGender());
            pt.setAge(  patient.getAge());
            pt.setAddress(patient.getAddress());
            pt.setRelatives(patient.getRelatives());
            pt.setContact( patient.getContact());
            pt.setTime(patient.getTime());

            Hospital hpt = pt.getHospital();
            Hospital hospital = patient.getHospital();
            hpt.setName(hospital.getName());
            hpt.setAddress(hospital.getAddress());
            hpt.setNumStaff(hospital.getNumStaff());
            hpt.setEmail(hospital.getEmail());
            hpt.setContact(hospital.getContact());

            hwService.PtSave(patient);
        }
        return patients;
    }

    @DeleteMapping("/{id}")
    public Patient deletePatientById(@PathVariable Integer id) {
        Patient hpt = hwService.PtFindById(id);
        hpt.setStatus("deleted");
        return hwService.PtSave(hpt);
    }
}
