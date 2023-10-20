package org.java2dart.logging;

public class DefaultLogger implements Logger {

    private final static String RESET = "\u001B[0m";
    private final static String RED = "\u001B[31m";
    private final static String GREEN = "\u001B[32m";
    private final static String YELLOW = "\u001B[33m";

    @Override
    public void log(Level level, String msg) {

        switch (level) {

            case DEBUG -> {
                println("DEBUG:   ");
            }
            case INFO -> {

                println(GREEN + "INFO:    ");
            }
            case WARNING -> {

                println(YELLOW + "WARNING: ");
            }
            case ERROR -> {

                println(RED + "ERROR:   ");
            }
        }

        println(msg + RESET);
    }

    private void println(String msg) {
        System.out.println(msg);
    }
}
