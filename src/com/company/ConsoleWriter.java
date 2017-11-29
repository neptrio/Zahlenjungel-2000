package com.company;

/**
 * Class ConsoleWriter wraps the System.out.println
 */
public class ConsoleWriter {

    private ConsoleWriter(){}

    /**
     * Prints a message in the console.
     * @param message you want to print in the console
     */
    public static void writeToConsole(String message) {
        System.out.println(message);
    }
}
