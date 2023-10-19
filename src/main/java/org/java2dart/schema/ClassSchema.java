package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class ClassSchema extends ObjectScheme {
    
    public ClassSchema(NamedTypeDescription specification,
                       @Nullable NamedTypeDescription superClass,
                       @Nullable List<IObjectScheme> formalParameters,
                       @Nullable Set<NamedTypeDescription> interfaces) {
        super(specification, superClass, formalParameters, interfaces);
    }

    public ClassSchema(@NonNull NamedTypeDescription specification,
                       @Nullable NamedTypeDescription superClass,
                       @Nullable List<IObjectScheme> formalParameters) {
        super(specification, superClass, formalParameters);
    }

    public ClassSchema(@NonNull NamedTypeDescription specification,
                       @Nullable List<IObjectScheme> formalParameters,
                       @Nullable Set<NamedTypeDescription> interfaces) {
        super(specification, formalParameters, interfaces);
    }

    public ClassSchema(@NonNull NamedTypeDescription specification,
                       @Nullable List<IObjectScheme> formalParameters) {
        super(specification, formalParameters);
    }

    public ClassSchema(@NonNull NamedTypeDescription specification) {
        super(specification);
    }
}
