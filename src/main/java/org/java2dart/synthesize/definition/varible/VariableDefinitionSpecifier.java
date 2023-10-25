package org.java2dart.synthesize.definition.varible;

import org.java2dart.schema.varible.IVariable;
import org.jspecify.annotations.NonNull;


public interface VariableDefinitionSpecifier {
    @NonNull String specify(IVariable variable);
}
