package org.java2dart.synthesize.definition.method;

import org.java2dart.schema.method.IMethod;
import org.java2dart.schema.varible.IVariable;
import org.java2dart.synthesize.definition.scheme.SchemeDefinitionSpecifier;
import org.java2dart.synthesize.scheme.BaseObjectSchemeSpecifier;
import org.jspecify.annotations.NonNull;


public interface MethodDefinitionSpecifier {
    @NonNull String specify(IMethod method);
}
