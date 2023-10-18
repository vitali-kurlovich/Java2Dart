package org.java2dart.ast.processing;

import org.java2dart.ast.generate.builder.CodeVisitor;
import org.java2dart.ast.generate.builder.base.BaseCodeBuilder;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtType;

public final class ASTTypeProcessing {

  public  void process(CtType<?> type) {
        if (type.isClass()) {
            CtClass c = (CtClass) type;
            processClass(c);
        }
    }

    private void processClass(CtClass c) {

        final var builder = new BaseCodeBuilder();
        final var visitor = new CodeVisitor(builder);



      c.accept(visitor);

       //final var processor = new  ASTClassProcessing();
       // processor.process(c);
    }

}
