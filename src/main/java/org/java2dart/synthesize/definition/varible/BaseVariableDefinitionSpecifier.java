package org.java2dart.synthesize.definition.varible;

import org.java2dart.schema.varible.IVariable;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;

public abstract class BaseVariableDefinitionSpecifier implements VariableDefinitionSpecifier {

    protected final TypeSpecifier typeSpecifier;

    public BaseVariableDefinitionSpecifier(TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }

   
}
