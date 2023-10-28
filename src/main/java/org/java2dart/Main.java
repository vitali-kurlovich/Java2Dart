package org.java2dart;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    public static void main(String[] args) {

        final var cli = new CLI(args);

        try {
            cli.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}