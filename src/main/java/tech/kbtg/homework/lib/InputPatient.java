package tech.kbtg.homework.lib;

import tech.kbtg.homework.entity.Hospital;
import tech.kbtg.homework.entity.Patient;

public class InputPatient {
    public static boolean isValid(Patient patient) {
        boolean nameValid = patient.getName() != null;
        boolean relativeValid = patient.getRelatives() != null;
        boolean addressValid = patient.getAddress() != null;
        boolean ageValid = patient.getAge() != null;
        boolean hospitalValid = patient.getHospital().getName() != null;
        boolean isContact = InputStrings.isContact(patient.getContact());
        return nameValid && relativeValid && addressValid && ageValid && hospitalValid && isContact;
    }
}
