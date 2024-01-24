package uk.ac.leedsbeckett.c7293754.se4.commands;

import uk.ac.leedsbeckett.c7293754.se4.commands.commands.AddCommand;
import uk.ac.leedsbeckett.c7293754.se4.commands.commands.DebugCommand;
import uk.ac.leedsbeckett.c7293754.se4.commands.commands.MoveToCommand;
import uk.ac.leedsbeckett.c7293754.se4.commands.commands.NumberCommand;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.CommandNotFoundException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.GPLException;

import java.util.HashMap;

public class CommandManager {

    private HashMap<String, Command> commands;

    public CommandManager() {

        commands = new HashMap<String, Command>();

        commands.put("debug", new DebugCommand());
        commands.put("moveto", new MoveToCommand());
        commands.put("number", new NumberCommand());
        commands.put("add", new AddCommand());

    }

    public void parse(String line) throws GPLException {

        String[] args = line.trim().split(" ");

        if (args.length == 0) throw new CommandNotFoundException("");

        Command command = get(args[0]);

        if (command == null) throw new CommandNotFoundException(args[0]);

        args = CommandUtils.removeFirstArg(args);

        try {
            command.run(args);
            return;
        } catch (Exception exception) {
            exception.printStackTrace();
            return;
        }

    }

    public Command get(String cmdName) {

        cmdName = cmdName.toLowerCase();
        if (commands.containsKey(cmdName)) {
            return commands.get(cmdName);
        }

        return null;

    }

}
