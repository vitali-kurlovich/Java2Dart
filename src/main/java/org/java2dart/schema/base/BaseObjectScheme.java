package org.java2dart.schema.base;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.schema.TypeParameter;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public abstract class BaseObjectScheme implements IObjectScheme {
    private final Set<ModifierKind> modifiers;
    private final NamedTypeDescription specification;
    private final @Nullable NamedTypeDescription superClass;
    private final @Nullable Set<NamedTypeDescription> interfaces;
    private final @Nullable List<TypeParameter> formalParameters;

    public BaseObjectScheme(Set<ModifierKind> modifiers,
                            @NonNull NamedTypeDescription specification,
                            @Nullable List<TypeParameter> formalParameters,
                            @Nullable NamedTypeDescription superClass,
                            @Nullable Set<NamedTypeDescription> interfaces
    ) {

        assert (specification != null);

        this.modifiers = modifiers;
        this.specification = specification;
        this.superClass = superClass;
        this.interfaces = interfaces;
        this.formalParameters = formalParameters;
    }



    public NamedTypeDescription getSpecification() {
        return specification;
    }

    public Set<ModifierKind> getModifiers() {
        return modifiers;
    }

    public @Nullable NamedTypeDescription getSuperClass() {
        return superClass;
    }

    public @Nullable Set<NamedTypeDescription> getInterfaces() {
        return interfaces;
    }

    public boolean isParameterized() {
        return getFormalParameters() != null && !getFormalParameters().isEmpty();
    }

    public @Nullable List<TypeParameter> getFormalParameters() {
        return formalParameters;
    }

    @Override
    public @NonNull String getTypeName() {
        return getSpecification().getTypeName();
    }

    @Override
    public boolean isVoid() {
        return getSpecification().isVoid();
    }

    @Override
    public boolean isPrimitive() {
        return getSpecification().isPrimitive();
    }

    @Override
    public boolean isNullable() {
        return getSpecification().isNullable();
    }

    @Override
    public boolean isArray() {
        return getSpecification().isArray();
    }

    @Override
    public boolean isGeneric() {
        return getSpecification().isGeneric();
    }

    @Override
    public TypeKind getTypeKing() {
        return getSpecification().getTypeKing();
    }


}
