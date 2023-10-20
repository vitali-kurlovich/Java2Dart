package org.java2dart.ast;

import spoon.Launcher;

public final class ASTLoader {

    private final String inputPath;

    public ASTLoader(String inputPath) {
        this.inputPath = inputPath;
    }

    public void run() {
        final var launcher = new Launcher();
        launcher.addInputResource(inputPath);
        launcher.getEnvironment().setComplianceLevel(17);
        launcher.buildModel();
        final var model = launcher.getModel();

        final var visitor = new CodeVisitor();

        model.getAllModules().forEach(
                t -> {
                    //System.out.println(t.toString());
                    t.accept(visitor);
                }
        );

    }


}
