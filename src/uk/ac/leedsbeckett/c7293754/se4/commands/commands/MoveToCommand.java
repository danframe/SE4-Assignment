package uk.ac.leedsbeckett.c7293754.se4.commands.commands;

import uk.ac.leedsbeckett.c7293754.se4.commands.Command;

public class MoveToCommand implements Command {

    @Override
    public String getUsage() {
        return "moveto <x> <y>";
    }

    @Override
    public void run(String[] args) throws Exception {

        System.out.println(args.length);

    }
}
