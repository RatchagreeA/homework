package tech.kbtg.homework.rest;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;
import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;
import tech.kbtg.homework.lib.InputHospital;
import tech.kbtg.homework.service.HwService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private HwService hwService;

    public HospitalController(HwService hwService) {
        this.hwService = hwService;
    }

    @GetMapping("")
    public List<Hospital> getHospitals(
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

        List<Hospital> hospitals = hwService.HptFind(page, pageSize);
        return hospitals;
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
        List<Patient> patients = hwService.PtFindAll();
        List<Patient> pt = patients.stream().filter(p -> p.getHospital().getName().equals(hpt.getName()) && p.getStatus().equals("")).collect(Collectors.toList());
        if (pt.size() > 0) {
            throw new RuntimeException("Bad request");
        }
        hpt.setStatus("deleted");
        return hwService.HptSave(hpt);
    }
}
