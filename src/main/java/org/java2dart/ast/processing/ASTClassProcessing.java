package org.java2dart.ast.processing;

import org.java2dart.ast.generate.builder.ClassCodeBuilder;
import spoon.reflect.declaration.CtClass;

public final class ASTClassProcessing {
    public void process(CtClass c) {



        final var builder =  new ClassCodeBuilder(c);


        final var source = builder.build();
        print(source);

    }

    private void print(String arg) {
        System.out.println(arg);
    }
}
