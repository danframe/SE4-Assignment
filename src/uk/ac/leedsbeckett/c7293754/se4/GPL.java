package uk.ac.leedsbeckett.c7293754.se4;

import uk.ac.leedsbeckett.c7293754.se4.commands.CommandManager;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.CommandNotFoundException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.GPLException;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.VariableNotFoundException;
import uk.ac.leedsbeckett.c7293754.se4.gui.GuiManager;
import uk.ac.leedsbeckett.c7293754.se4.variables.VariableManager;

import java.util.Scanner;

public class GPL {

    private CommandManager commandManager;
    private VariableManager variableManager;
    private GuiManager guiManager;

    public void start() {

        commandManager = new CommandManager();
        variableManager = new VariableManager();
        guiManager = new GuiManager();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {

                System.out.println("Enter a command");
                String command = scanner.nextLine();
                parseLine(command);

            } catch (GPLException exception) {
                exception.printStackTrace();
            }

        }

        //guiManager.start();

    }

    public void parseLine(String line) throws GPLException {

        if (line.trim().isEmpty()) return;

        try {
            commandManager.parse(line);
            return;
        } catch (CommandNotFoundException ignored) {
        } catch (GPLException exception) {
            throw exception;
        }

        try {
            variableManager.parse(line);
            return;
        } catch (VariableNotFoundException ignored) {
        } catch (GPLException exception) {
            throw exception;
        }

        String[] args = line.split(" ");
        throw new GPLException(String.format("\"%s\" is not a valid command or variable name", args[0]));

    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public VariableManager getVariableManager() {
        return variableManager;
    }

}
