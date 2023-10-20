package org.java2dart.logging;

public class DefaultLogger implements Logger {

private  final static String RESET = "\u001B[0m";
private  final static  String RED = "\u001B[31m";
private  final  static String GREEN = "\u001B[32m";
private  final static  String YELLOW = "\u001B[33m";

    @Override
    public void log(Level level, String msg) {

        switch (level) {

            case DEBUG -> {
                println( "DEBUG:   " + msg );
            }
            case INFO -> {

                println(GREEN + "INFO:    " + msg + RESET);
            }
            case WARNING -> {

                println(YELLOW + "WARNING: " + msg + RESET);
            }
            case ERROR -> {

                println(RED + "ERROR:   " + msg + RESET);
            }
        }


    }

    private void println(String msg) {
System.out.println(msg);
    }
}
