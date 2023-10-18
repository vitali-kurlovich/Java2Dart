package org.java2dart.ast;

import org.java2dart.ast.generate.CodeVisitor;
import org.java2dart.ast.generate.builder.base.BaseCodeBuilder;
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

      //  model.getAllPackages()

        final var builder = new BaseCodeBuilder();
        final var visitor = new CodeVisitor(builder);

     //   model.getRootPackage().accept(visitor);

      //  model.getRootPackage().accept(visitor);

      //  model.getUnnamedModule().accept(visitor);

        model.getAllModules().forEach(
                t -> {
                    System.out.println(t.toString());
                    t.accept(visitor);
                }
        );

      //  model.getAllTypes().forEach( t -> t.accept(visitor));


       final var source = builder.build();
        System.out.println(source);

/*
        for (CtType<?> s : model.getAllTypes()) {


           // s.accept( visitor );
            final var processor = new ASTTypeProcessing();
            processor.process(s);
        }
        */

    }


}
