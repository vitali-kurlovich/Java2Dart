package org.java2dart.ast;

import org.java2dart.logging.Logging;
import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.dart.DartTypeImplementation;
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


        final var allTypes = model.getAllTypes();

        final var impl = new DartTypeImplementation();

        for (final var type : allTypes) {

            final var source = impl.source(type);
            Logging.info(source);


//            final var impl = DartObjectSchemeSpecifier();
//
//            final var source =    impl.implementation(type);
//            Logging.info(source);
        }


        //  final var visitor = new CodeVisitor();


//        model.getAllModules().forEach(
//                t -> {
//                    //System.out.println(t.toString());
//                    t.accept(visitor);
//                }
//        );

    }


}
