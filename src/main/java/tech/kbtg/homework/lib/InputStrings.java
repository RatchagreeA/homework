package tech.kbtg.homework.lib;

import java.util.regex.Pattern;

public class InputStrings {

    public static boolean isEmail(String emailAddress) {
        String regexPattern1 = "^(.+)@(\\S+)$";
        String regexPattern2 = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern2)
                .matcher(emailAddress)
                .matches();
    }
    public static boolean isContact(String contact) {
        String regexPattern = "^0[0-9]{8,11}$";
        return Pattern.compile(regexPattern)
                .matcher(contact)
                .matches();
    }
}

