package uk.ac.leedsbeckett.c7293754.se4;

import uk.ac.leedsbeckett.c7293754.se4.commands.CommandManager;
import uk.ac.leedsbeckett.c7293754.se4.variables.VariableManager;

public class GPL {

    private CommandManager commandManager;
    private VariableManager variableManager;

    public void start() {

        commandManager = new CommandManager();
        variableManager = new VariableManager();

    }

}
