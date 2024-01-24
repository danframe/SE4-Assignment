package uk.ac.leedsbeckett.c7293754.se4.exceptions;

public class VariableNotFoundException extends GPLException {

    public VariableNotFoundException(String varName) {
        super(String.format("The variable \"%s\" is not defined.", varName));
    }

}
