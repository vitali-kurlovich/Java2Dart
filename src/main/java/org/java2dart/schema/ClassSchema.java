package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class ClassSchema {
    private final @Nullable NamedTypeDescription superClass;
    private final @Nullable Set<NamedTypeDescription> interfaces;
    private final NamedTypeDescription specification;

    private final @Nullable List<TypeParameter> formalParameters;

    public ClassSchema(NamedTypeDescription specification,
                       @Nullable List<TypeParameter> formalParameters,
                       @Nullable NamedTypeDescription superClass,
                       @Nullable Set<NamedTypeDescription> interfaces) {
        this.superClass = superClass;
        this.interfaces = interfaces;
        this.specification = specification;
        this.formalParameters = formalParameters;
    }

    public ClassSchema(NamedTypeDescription specification,
                       @Nullable NamedTypeDescription superClass,
                       @Nullable Set<NamedTypeDescription> interfaces) {
        this(specification, null, superClass, interfaces);
    }

    public boolean isParameterized() {
        return getFormalParameters() != null && !getFormalParameters().isEmpty();
    }

    public boolean isExtends() {
        return getSuperClass() != null;
    }

    public boolean isImplements() {
        return getInterfaces() != null && !getInterfaces().isEmpty();
    }

    public @Nullable List<TypeParameter> getFormalParameters() {
        return formalParameters;
    }

    public @Nullable NamedTypeDescription getSuperClass() {
        return superClass;
    }

    public @Nullable Set<NamedTypeDescription> getInterfaces() {
        return interfaces;
    }

    public NamedTypeDescription getSpecification() {
        return specification;
    }
}
