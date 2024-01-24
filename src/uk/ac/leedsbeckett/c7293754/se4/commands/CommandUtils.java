package uk.ac.leedsbeckett.c7293754.se4.commands;

public class CommandUtils {

    public static String[] removeFirstArg(String[] args) {

        if (args.length == 0) return args;

        String[] newArgs = new String[args.length - 1];

        for (int index = 1; index < args.length; index++) {
            newArgs[index - 1] = args[index];
        }

        return newArgs;

    }

}
