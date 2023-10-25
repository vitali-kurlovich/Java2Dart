package org.java2dart.synthesize.definition.dart;

import org.java2dart.schema.varible.IVariable;
import org.java2dart.synthesize.definition.varible.BaseVariableDefinitionSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;

public class DartVariableDefinitionSpecifier extends BaseVariableDefinitionSpecifier {

    public DartVariableDefinitionSpecifier(BaseTypeSpecifier typeSpecifier) {
        super(typeSpecifier);
    }

    @Override
    public @NonNull String specify(IVariable variable) {
        final var typeDsc = typeSpecifier.specify(variable.getType());
        return  typeDsc + " " + variable.getName();
    }
}
