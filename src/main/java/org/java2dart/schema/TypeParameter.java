package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class TypeParameter extends BaseObjectScheme {


    public TypeParameter(NamedTypeDescription specification,
                         @Nullable NamedTypeDescription superClass,
                         @Nullable List<IObjectScheme> formalParameters,
                         @Nullable Set<NamedTypeDescription> interfaces) {
        super(null, specification, superClass, formalParameters, interfaces);
    }

    public TypeParameter(@NonNull NamedTypeDescription specification,
                         @Nullable NamedTypeDescription superClass,
                         @Nullable List<IObjectScheme> formalParameters) {
        super(null , specification, superClass, formalParameters);
    }






}
