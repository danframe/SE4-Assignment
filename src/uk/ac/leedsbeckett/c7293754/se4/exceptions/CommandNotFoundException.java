package uk.ac.leedsbeckett.c7293754.se4.exceptions;

public class CommandNotFoundException extends GPLException {

    public CommandNotFoundException(String cmd) {
        super(String.format("Command \"%s\" not found", cmd));
    }

}
