package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class ClassSchema extends BaseObjectScheme {

    public ClassSchema(Set<ModifierKind> modifiers,
                      @NonNull  NamedTypeDescription specification,
                       @Nullable List<TypeParameter> formalParameters,
                       @Nullable NamedTypeDescription superClass,
                       @Nullable Set<NamedTypeDescription> interfaces) {
        super(modifiers, specification, formalParameters, superClass, interfaces);
    }
}
