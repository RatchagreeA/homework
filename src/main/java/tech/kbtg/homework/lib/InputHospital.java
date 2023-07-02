package tech.kbtg.homework.lib;

import tech.kbtg.homework.entity.Hospital;

public class InputHospital {
    public static boolean isValid(Hospital hospital){
        boolean nameValid = hospital.getName()!=null;
        boolean addressValid = hospital.getAddress()!=null;
        boolean isEmail = InputStrings.isEmail(hospital.getEmail());
        boolean isContact = InputStrings.isContact(hospital.getContact());
        return nameValid && addressValid && isEmail && isContact;
    }
}
