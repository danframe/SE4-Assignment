package uk.ac.leedsbeckett.c7293754.se4.commands;

import java.util.HashMap;

public class CommandManager {

    private CommandParser parser;
    private HashMap<String, Command> commands;

    public CommandManager() {

        parser = new CommandParser();
        commands = new HashMap<String, Command>();

    }

    public CommandParser getParser() {
        return parser;
    }

}
