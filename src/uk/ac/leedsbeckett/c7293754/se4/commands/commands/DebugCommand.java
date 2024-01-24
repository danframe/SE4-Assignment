package uk.ac.leedsbeckett.c7293754.se4.commands.commands;

import uk.ac.leedsbeckett.c7293754.se4.Main;
import uk.ac.leedsbeckett.c7293754.se4.commands.Command;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.CommandArgumentsException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.VariableNotFoundException;
import uk.ac.leedsbeckett.c7293754.se4.variables.Variable;

public class DebugCommand implements Command {
    @Override
    public String getUsage() {
        return "debug <variableName>";
    }

    @Override
    public void run(String[] args) throws Exception {

        if (args.length < 1) {
            throw new CommandArgumentsException(this);
        }

        String varName = args[0];
        Variable variable = Main.getInst().getVariableManager().get(varName);

        if (variable == null) {
            throw new VariableNotFoundException(varName);
        }

        System.out.println(String.format("%s: %s", variable.getName(), variable.getStr()));

    }
}
