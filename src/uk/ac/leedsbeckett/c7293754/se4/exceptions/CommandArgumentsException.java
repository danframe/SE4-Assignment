package uk.ac.leedsbeckett.c7293754.se4.exceptions;

import uk.ac.leedsbeckett.c7293754.se4.commands.Command;

public class CommandArgumentsException extends GPLException {

    public CommandArgumentsException(Command cmd) {

        super(String.format("Usage: %s", cmd.getUsage()));

    }

    public CommandArgumentsException(Command cmd, String invalidVal) {

        super(String.format("Invalid value \"%s\" | Usage: %s", invalidVal, cmd.getUsage()));

    }

}
