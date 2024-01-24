package uk.ac.leedsbeckett.c7293754.se4.variables;

import uk.ac.leedsbeckett.c7293754.se4.commands.Command;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.GPLException;

public class Variable {

    private String name;
    protected Object value;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void set(Object value) throws GPLException {

    }

    public Object get() {
        return this.value;
    }

    public String getStr() {
        return isNull() ? "null" : get().toString();
    }

    public boolean isNull() {
        return this.value == null;
    }

}
