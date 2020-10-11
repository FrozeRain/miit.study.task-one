package com.miit.study.frozerain;

import com.miit.study.frozerain.service.StringArrayService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * Static value of console stream input.
     */
    private static Scanner consoleScanner = new Scanner(System.in);

    /**
     * The main method of program, which executing following steps:
     * 1. Reading size value of strings array from console.
     * 2. Randomly generates strings with different value of size.
     * 3. Output early generated strings to console.
     * 4. Performing algorithm that searching minimum value of size by each string of array.
     * 5. Output the resulting string to console.
     * @param args - nothing here.
     */
    public static void main(String[] args) {
        try {
            final int arraySize = consoleRead();
            //This condition prohibits using negative value of size.
            if (arraySize > 0) {
                String[] stringsArray = new String[arraySize];

                //Filling strings array with randomly generated strings...
                consoleWrite("\n> GENERATED STRINGS:\n> " +
                        StringArrayService.toFormattedString(
                                StringArrayService.generateTestData(stringsArray)
                        ));

                //Performing searching algorithm...
                consoleWrite("\n> SEARCHING STRING WITH MIN LENGTH:\n> " +
                        StringArrayService.getMinStringLength(stringsArray) + "\n");
            } else {
                throw new IllegalArgumentException("Array's size must be more that zero!");
            }

        } catch (InputMismatchException e) {
            consoleWrite("Array's size must be numeric value!");
        } catch (IllegalArgumentException | NullPointerException e) {
            consoleWrite(e.getMessage());
        }
        //TODO quick hack to keep console window in focus.
        consoleScanner.nextLine();
        consoleScanner.nextLine();
    }

    /**
     * Simple console reading method using OOB class {@link Scanner}.
     * @return integer value from console input.
     */
    private static int consoleRead() {
        consoleWrite("Please specify SIZE of strings array: ");
        return consoleScanner.nextInt();
    }

    /**
     * Simple console writing method using OOB system output stream.
     * @param msg - message that need to write to console.
     */
    private static void consoleWrite(String msg) {
        System.out.print("> " + msg);
    }
}
