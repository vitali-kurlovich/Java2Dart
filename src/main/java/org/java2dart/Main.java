package org.java2dart;

import spoon.Launcher;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

     //  final var launcher = new Launcher();

      //  launcher.addInputResource();
        for (var arg: args ) {
            System.out.printf(arg);
        }

        try {
            String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);

            String currentDir = System.getProperty("user.dir");
            System.out.println("Current dir using System:" + currentDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {

        }



        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }
    }
}