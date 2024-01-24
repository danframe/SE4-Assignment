package uk.ac.leedsbeckett.c7293754.se4.utils;

import uk.ac.leedsbeckett.c7293754.se4.Main;
import uk.ac.leedsbeckett.c7293754.se4.exceptions.CommandNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {

    public static void loadCommandFile(String fileName) throws FileNotFoundException, CommandNotFoundException, Exception {

        File file = new File(fileName);

        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException(fileName);
        }

        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {

            String fileLine = fileScanner.nextLine();

            try {
                Main.getInst().getCommandManager().parse(fileLine);
            } catch (CommandNotFoundException exception) {
                throw exception;
            } catch (Exception exception) {
                throw exception;
            }

        }

    }

}
