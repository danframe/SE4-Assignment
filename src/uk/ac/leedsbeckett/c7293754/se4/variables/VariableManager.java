package uk.ac.leedsbeckett.c7293754.se4.variables;

import uk.ac.leedsbeckett.c7293754.se4.Main;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.CommandNameException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.GPLException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.VariableNotFoundException;

import java.util.HashMap;

public class VariableManager {

    private String nameRegex;
    private HashMap<String, Variable> variables;

    public VariableManager() {

        nameRegex = "[a-zA-Z_]+";
        variables = new HashMap<>();

    }

    public boolean isVariableNameAvailable(String varName) {

        varName = varName.toLowerCase();
        return get(varName) == null && Main.getInst().getCommandManager().get(varName) == null;

    }

    public void set(Variable variable) throws CommandNameException {

        if (!variable.getName().matches(nameRegex)) {
            throw new CommandNameException(String.format("Can not set a variable with the name \"%s\", letters and underscores only.", variable.getName()));
        }

        if (!isVariableNameAvailable(variable.getName())) {
            throw new CommandNameException(String.format("Can not set a variable with the name \"%s\", already defined.", variable.getName()));
        }

        variables.put(variable.getName().toLowerCase(), variable);
    }

    public Variable get(String varName) {

        varName = varName.toLowerCase();
        if (variables.containsKey(varName)) {
            return variables.get(varName);
        }

        return null;

    }

    public void parse(String line) throws GPLException {

        String[] args = line.trim().split(" ");

        if (args.length == 0) throw new VariableNotFoundException("");

        Variable variable = get(args[0]);

        if (variable == null) throw new VariableNotFoundException(args[0]);

        try {
            variable.set(args[1]);
        } catch (GPLException exception) {
            throw exception;
        }

    }
}
