package uk.ac.leedsbeckett.c7293754.se4.commands.commands;

import uk.ac.leedsbeckett.c7293754.se4.Main;
import uk.ac.leedsbeckett.c7293754.se4.commands.Command;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.CommandArgumentsException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.GPLException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.VariableNotFoundException;
import uk.ac.leedsbeckett.c7293754.se4.utils.Utils;
import uk.ac.leedsbeckett.c7293754.se4.variables.Variable;
import uk.ac.leedsbeckett.c7293754.se4.variables.variables.NumberVariable;

public class AddCommand implements Command {
    @Override
    public String getUsage() {
        return "add <variableName> <sum|variableName>*";
    }

    @Override
    public void run(String[] args) throws Exception {

        if (args.length < 2) {
            throw new CommandArgumentsException(this);
        }

        String varName = args[0];
        Variable variable = Main.getInst().getVariableManager().get(varName);

        if (variable == null) {
            throw new VariableNotFoundException(args[0]);
        }

        if (!(variable instanceof NumberVariable)) {
            throw new GPLException(String.format("The variable \"%s\" is not a number", variable.getName()));
        }

        Float currentVal = variable.isNull() ? 0f : (Float) variable.get();

        for (int index = 1; index < args.length; index ++) {

            Float numVal = Utils.getNumber(args[index]);
            Variable addVar = Main.getInst().getVariableManager().get(args[index]);

            if (numVal == null && addVar == null) {
                throw new GPLException(String.format("Invalid number or variable name of \"%s\"", args[index]));
            }

            if (numVal == null) {

                if (!(addVar instanceof NumberVariable)) {
                    throw new GPLException(String.format("The variable \"%s\" is not a number", variable.getName()));
                }

                numVal = addVar.isNull() ? 0f : (Float) addVar.get();

            }

            currentVal += numVal;

        }

        variable.set(currentVal);

    }
}
