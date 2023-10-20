package org.java2dart.ast.processing;


import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtType;

@Deprecated
public final class ASTTypeProcessing {

  public  void process(CtType<?> type) {
        if (type.isClass()) {
            CtClass c = (CtClass) type;
            processClass(c);
        }
    }

    private void processClass(CtClass c) {


       //final var processor = new  ASTClassProcessing();
       // processor.process(c);
    }

}
