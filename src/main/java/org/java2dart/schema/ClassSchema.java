package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class ClassSchema extends ObjectScheme {
    private final @Nullable List<TypeParameter> formalParameters;


    public ClassSchema(NamedTypeDescription specification,
                       @Nullable NamedTypeDescription superClass,
                       @Nullable Set<NamedTypeDescription> interfaces,
                       @Nullable List<TypeParameter> formalParameters) {
        super(specification, superClass, interfaces);
        this.formalParameters = formalParameters;
    }

    public ClassSchema(@NonNull NamedTypeDescription specification,
                       @Nullable NamedTypeDescription superClass,
                       @Nullable List<TypeParameter> formalParameters) {
        super(specification, superClass);
        this.formalParameters = formalParameters;
    }

    public ClassSchema(@NonNull NamedTypeDescription specification,
                       @Nullable Set<NamedTypeDescription> interfaces,
                       @Nullable List<TypeParameter> formalParameters) {
        super(specification, interfaces);
        this.formalParameters = formalParameters;
    }

    public ClassSchema(@NonNull NamedTypeDescription specification,
                       @Nullable List<TypeParameter> formalParameters) {
        super(specification);
        this.formalParameters = formalParameters;
    }


    public ClassSchema(NamedTypeDescription specification,
                       @Nullable NamedTypeDescription superClass,
                       @Nullable Set<NamedTypeDescription> interfaces) {
        this(specification, superClass, interfaces, null);
    }

    public boolean isParameterized() {
        return getFormalParameters() != null && !getFormalParameters().isEmpty();
    }


    public @Nullable List<TypeParameter> getFormalParameters() {
        return formalParameters;
    }


}
