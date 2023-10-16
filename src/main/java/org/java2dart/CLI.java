package org.java2dart;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.java2dart.ast.ASTLoader;

public class CLI {
    public static final String inputKey = "input";
    public static final String inputShortKey = "i";
    public static final String outputKey = "output";
    public static final String outputShortKey = "o";
    private final String[] args;

    public CLI(String[] args) {
        this.args = args;
    }

    public void run() throws Exception {
        parse(args);
    }

    private Options options() {
        final Options options = new Options();
        options.addOption(new Option(CLI.inputShortKey, CLI.inputKey, true, "Input directory or file path"));
        options.addOption(new Option(CLI.outputShortKey, CLI.outputKey, true, "Output directory or file path"));

        return options;
    }

    private void parse(String[] args) throws Exception {
        final var options = options();
        final var parser = new DefaultParser();
        final var cmd = parser.parse(options, args);

        final String inputPath;
        final String outputPath;

        if (cmd.hasOption(CLI.inputKey)) {
            final var path = cmd.getOptionValue(CLI.inputKey);
            System.out.println("input argument: " + path);
            inputPath = new java.io.File(path).getCanonicalPath();
        } else {
            inputPath = new java.io.File(".").getCanonicalPath();
        }

        if (cmd.hasOption(CLI.outputKey)) {
            final var path = cmd.getOptionValue(CLI.outputKey);
            System.out.println("output argument: " + path);
            outputPath = new java.io.File(path).getCanonicalPath();
        } else {
            outputPath = new java.io.File("./dart").getCanonicalPath();
        }

        System.out.println("Input path:" + inputPath);
        System.out.println("Output path:" + outputPath);

        final var aslparser = new ASTLoader(inputPath);
        aslparser.run();
    }

}
