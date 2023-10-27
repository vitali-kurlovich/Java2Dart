package org.java2dart.factory.variable;

import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.schema.varible.Variable;
import spoon.reflect.declaration.CtVariable;


public class ASTVariableFactory {

    protected final ASTTypeDescriptionFactory typeDescriptionFactory;

    public ASTVariableFactory(ASTTypeDescriptionFactory typeDescriptionFactory) {
        this.typeDescriptionFactory = typeDescriptionFactory;
    }


   public Variable variable(CtVariable<?> variable) {

      final var type =  variable.getType();
      final  var name =  variable.getSimpleName();

      final var typeDesc =  typeDescriptionFactory.description(type);

        return new Variable(name,  typeDesc);
    }

}
