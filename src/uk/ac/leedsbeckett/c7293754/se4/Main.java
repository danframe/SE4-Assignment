package uk.ac.leedsbeckett.c7293754.se4;

public class Main {

    private static GPL gpl;

    public static void main(String[] args) {

        gpl = new GPL();
        gpl.start();

    }

    public static GPL getInst() {
        return gpl;
    }

}
