package org.java2dart.ast;

import org.java2dart.ast.processing.ASTTypeProcessing;
import spoon.Launcher;
import spoon.reflect.declaration.CtType;

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

        for (CtType<?> s : model.getAllTypes()) {
            final var processor = new ASTTypeProcessing();
            processor.process(s);
        }

    }


}
