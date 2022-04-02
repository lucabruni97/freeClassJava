package it.omiconacademy.freeclassjava.validators;

import java.util.regex.Pattern;

public abstract class Validator {

    public static boolean emailValida(String email) {
        if (email == null) {
            return false;
        }
        Pattern emailPattern = Pattern.compile("^[\\w\\d]+@[\\w\\d]+\\.\\w{2,3}$");
        return emailPattern.matcher(email).matches();
    }
}
