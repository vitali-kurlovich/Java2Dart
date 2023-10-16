package org.java2dart;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import spoon.Launcher;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        final var options = new Options();

// add t option
        options.addOption("t", false, "display current time");

        final var parser = new DefaultParser();
        try {
            final var cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        //  final var launcher = new Launcher();

        //  launcher.addInputResource();
        for (var arg : args) {
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


    }
}