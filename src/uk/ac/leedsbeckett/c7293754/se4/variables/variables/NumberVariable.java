package uk.ac.leedsbeckett.c7293754.se4.variables.variables;

import uk.ac.leedsbeckett.c7293754.se4.exceptions.GPLException;
import uk.ac.leedsbeckett.c7293754.se4.utils.Utils;
import uk.ac.leedsbeckett.c7293754.se4.variables.Variable;

public class NumberVariable extends Variable {

    public NumberVariable(String name) {
        super(name);
    }

    @Override
    public void set(Object val) throws GPLException {

        if (val == null) {
            this.value = null;
            return;
        }

        Float numVal = Utils.getNumber(val.toString());

        if (numVal == null) {
            throw new GPLException(String.format("Invalid number for \"%s\"", getName()));
        }

        this.value = numVal;
    }

}
