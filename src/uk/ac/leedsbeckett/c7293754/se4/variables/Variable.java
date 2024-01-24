package uk.ac.leedsbeckett.c7293754.se4.variables;

import uk.ac.leedsbeckett.c7293754.se4.variables.VariableType;

public class Variable {

    private String name;
    private VariableType type;

    public Variable(String name, VariableType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public VariableType getType() {
        return type;
    }

}
