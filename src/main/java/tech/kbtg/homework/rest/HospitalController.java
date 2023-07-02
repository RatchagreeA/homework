package tech.kbtg.homework.rest;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;
import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;
import tech.kbtg.homework.lib.InputHospital;
import tech.kbtg.homework.service.HwService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private HwService hwService;

    public HospitalController(HwService hwService) {
        this.hwService = hwService;
    }

    @GetMapping("")
    public List<List<Hospital>> getHospitals(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Integer numStaff,
            @RequestParam(required = false) String operator,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String contact,
            @RequestParam(required = false) String hospitalSize,
            @RequestParam(required = false) String status,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize
    ) {

        List<Hospital> hospitals = hwService.HptFindAll();
        if (name != null && !name.equals("")) {
            hospitals = hospitals.stream().filter(h -> h.getName().equals(name)).collect(Collectors.toList());
        }
        if (address != null && !address.equals("")) {
            hospitals = hospitals.stream().filter(h -> h.getAddress().contains(address)).collect(Collectors.toList());
        }
        if (numStaff != null) {
            switch (operator) {
                case "greater_than":
                    hospitals = hospitals.stream().filter(h -> h.getNumStaff() > numStaff).collect(Collectors.toList());
                    break;
                case "less_than":
                    hospitals = hospitals.stream().filter(h -> h.getNumStaff() < numStaff).collect(Collectors.toList());
                    break;
                case "greater_equal":
                    hospitals = hospitals.stream().filter(h -> h.getNumStaff() >= numStaff).collect(Collectors.toList());
                    break;
                case "less_equal":
                    hospitals = hospitals.stream().filter(h -> h.getNumStaff() <= numStaff).collect(Collectors.toList());
                    break;
                default:
                    hospitals = hospitals.stream().filter(h -> h.getNumStaff() == numStaff).collect(Collectors.toList());
            }
        }
        if (email != null && !email.equals("")) {
            hospitals = hospitals.stream().filter(h -> h.getEmail().equals(email)).collect(Collectors.toList());
        }
        if (contact != null && !contact.equals("")) {
            hospitals = hospitals.stream().filter(h -> h.getContact().equals(contact)).collect(Collectors.toList());
        }
        if (hospitalSize != null) {
            hospitals = hospitals.stream().filter(h -> h.getHospitalSize().equals(hospitalSize)).collect(Collectors.toList());
        }
        if (status != null) {
            hospitals = hospitals.stream().filter(h -> h.getStatus().equals(status)).collect(Collectors.toList());
        }

        List<List<Hospital>> pageHospital = Lists.partition(hospitals, pageSize);
        if (page > pageHospital.size()) {
            return pageHospital;
        }
        return pageHospital.subList(0, page);
    }

    @GetMapping("/{id}")
    public Hospital getHospitalById(@PathVariable Integer id) {
        return hwService.HptFindById(id);
    }

    @PostMapping("")
    public Hospital addHospital(@RequestBody Hospital hospital) {

        if (!InputHospital.isValid(hospital)) {
            throw new RuntimeException("Bad request");
        }
        return hwService.HptSave(hospital);
    }

    @PutMapping("")
    public Hospital updateHospitalById(@RequestBody Hospital hospital) {
        if (!InputHospital.isValid(hospital) || hospital.getId() == null) {
            throw new RuntimeException("Bad request");
        }
        Hospital hpt = hwService.HptFindById(hospital.getId());
        hpt.setName(hospital.getName());
        hpt.setAddress(hospital.getAddress());
        hpt.setNumStaff(hospital.getNumStaff());
        hpt.setEmail(hospital.getEmail());
        hpt.setContact(hospital.getContact());
        return hwService.HptSave(hospital);
    }

    @DeleteMapping("/{id}")
    public Hospital deleteHospitalById(@PathVariable Integer id) {
        Hospital hpt = hwService.HptFindById(id);
        hpt.setStatus("deleted");
        return hwService.HptSave(hpt);
    }
    @GetMapping("/pt")
    public List<Patient> getPt(){
        return hwService.PtFindAll();
    }
}
