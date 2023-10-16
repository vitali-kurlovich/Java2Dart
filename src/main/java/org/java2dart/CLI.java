package org.java2dart;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class CLI {

    private String[] args;

    public CLI(String[] args) {
        this.args = args;
    }

    public void run() throws ParseException {
        parse(args);
    }

    private Options options() {
        final Options options = new Options();
        options.addOption(new Option("i", "input", true, "Input directory or file path"));

        options.addOption(new Option("o", "option", true, "Output directory or file path"));

        return options;
    }

    private void parse(String[] args) throws ParseException {
        final var options = options();
        final var parser = new DefaultParser();
        final var cmd = parser.parse(options, args);
        if (cmd.hasOption("input")) {
            final var path = cmd.getOptionValue("input");
            System.out.println("input argument: " + path);
            try {
                final var inputPath = new java.io.File(path).getCanonicalPath();
                System.out.println("Input path:" + inputPath);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
