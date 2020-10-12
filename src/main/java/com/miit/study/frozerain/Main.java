package com.miit.study.frozerain;

import com.miit.study.frozerain.service.StringArrayService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

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
     *
     * @param args - nothing here.
     */
    public static void main(String[] args) {
        final Integer arraySize = getValidInputOrNull(consoleRead());
        //This condition prohibits using negative or incorrect value of size.
        if (arraySize != null) {

            //Filling strings array with randomly generated strings...
            final String[] strings = StringArrayService.getGeneratedStringsArrayBySize(arraySize);

            consoleWrite("\n> GENERATED STRINGS:\n> " +
                    StringArrayService.getFormattedString(strings));

            //Performing searching algorithm...
            consoleWrite("\n> SEARCHING STRING WITH MIN LENGTH:\n> " +
                    StringArrayService.getMinStringLength(strings) + "\n");
        } else {
            consoleWrite("Invalid input! Please verify that you input is correct.");
        }
        //TODO quick hack to keep console window in focus.
        consoleScanner.nextLine();
        consoleScanner.nextLine();
    }

    private static Integer getValidInputOrNull(String str) {
        return getValidInputOrNull(
                str,
                integer -> (integer != null && Integer.valueOf(0).compareTo(integer) < 0));
    }

    private static Integer getValidInputOrNull(String str, Predicate<Integer> predicate) {
        final Integer number = tryIntParse(str);
        if (number != null && predicate != null) {
            return predicate.test(number)
                    ? number
                    : null;
        } else {
            return number;
        }
    }

    private static Integer tryIntParse(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    /**
     * Simple console reading method using OOB class {@link Scanner}.
     *
     * @return integer value from console input.
     */
    private static String consoleRead() {
        consoleWrite("Please specify SIZE of strings array: ");
        return consoleScanner.next();
    }

    /**
     * Simple console writing method using OOB system output stream.
     *
     * @param msg - message that need to write to console.
     */
    private static void consoleWrite(String msg) {
        System.out.print("> " + msg);
    }
}
