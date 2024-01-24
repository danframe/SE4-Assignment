package uk.ac.leedsbeckett.c7293754.se4.commands.commands;

import uk.ac.leedsbeckett.c7293754.se4.Main;
import uk.ac.leedsbeckett.c7293754.se4.commands.Command;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.CommandArgumentsException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.CommandNameException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.GPLException;
import uk.ac.leedsbeckett.c7293754.se4.variables.variables.NumberVariable;

public class NumberCommand implements Command {

    @Override
    public String getUsage() {
        return "number <varName> [value]";
    }

    @Override
    public void run(String[] args) throws GPLException {

        if (args.length < 1) {
            throw new CommandArgumentsException(this);
        }

        String varName = args[0];
        NumberVariable variable = new NumberVariable(varName);

        try {
            Main.getInst().getVariableManager().set(variable);
        } catch (CommandNameException exception) {
            throw exception;
        }

        if (args.length == 1) return;

        try {
            variable.set(args[1]);
        } catch (GPLException exception) {
            throw exception;
        }

    }
}
