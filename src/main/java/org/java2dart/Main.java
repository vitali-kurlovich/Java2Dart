package org.java2dart;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import spoon.Launcher;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

       final var cli = new CLI(args);

       try {
           cli.run();
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

    }
}