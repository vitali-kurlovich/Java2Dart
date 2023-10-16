package org.java2dart.ast.processing;

import org.java2dart.ast.generate.toplevel.AccesLevel;
import org.java2dart.ast.generate.builder.ClassBuilder;
import spoon.reflect.declaration.CtClass;

public final class ASTClassProcessing {
    public void process(CtClass c) {

       
        final var className = c.getSimpleName();

        final var builder = new ClassBuilder(className);

        builder.setFinal(c.isFinal());
        builder.setStatic(c.isStatic());
        builder.setAbstract(c.isAbstract());

        if (c.isPrivate()) {
            builder.setAccesLevel(AccesLevel.PRIVATE);
        }

        if (c.isProtected()) {
            builder.setAccesLevel(AccesLevel.PROTECTED);
        }

        if (c.isPublic()) {
            builder.setAccesLevel(AccesLevel.PUBLIC);
        }

        final var source = builder.build();
        print(source);

    }

    private void print(String arg) {
        System.out.println(arg);
    }
}
