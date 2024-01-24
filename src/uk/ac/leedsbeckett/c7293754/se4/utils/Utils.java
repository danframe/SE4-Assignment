package uk.ac.leedsbeckett.c7293754.se4.utils;

public class Utils {

    public static Float getNumber(String str) {

        try {
            return Float.valueOf(str);
        } catch (NumberFormatException exception) {
            return null;
        }

    }

}
