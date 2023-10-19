package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.java2dart.types.TypeDescription;
import org.java2dart.types.object.ClassTypeDescription;
import org.java2dart.types.object.InterfaceTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class ClassSchema {
    private final @Nullable NamedTypeDescription superClass;
    private final @Nullable List<NamedTypeDescription> interfaces;
    private final NamedTypeDescription specification;

    private final @Nullable List<TypeParameter> formalParameters;

    public ClassSchema( NamedTypeDescription specification,
                        @Nullable List<TypeParameter> formalParameters,
                        @Nullable NamedTypeDescription superClass,
                        @Nullable  List<NamedTypeDescription> interfaces) {
        this.superClass = superClass;
        this.interfaces = interfaces;
        this.specification = specification;
        this.formalParameters = formalParameters;
    }

    public ClassSchema( NamedTypeDescription specification, @Nullable NamedTypeDescription superClass, @Nullable  List<NamedTypeDescription> interfaces) {
        this(specification, null, superClass, interfaces );
    }

    public @Nullable List<TypeParameter> getFormalParameters() {
        return formalParameters;
    }
    public @Nullable NamedTypeDescription getSuperClass() {
       return superClass;
   }

    public @Nullable List<NamedTypeDescription> getInterfaces() {
        return interfaces;
    }

    public NamedTypeDescription getSpecification() {
        return specification;
    }
}
