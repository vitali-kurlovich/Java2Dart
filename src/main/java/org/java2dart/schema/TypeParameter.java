package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class TypeParameter implements IObjectScheme {

    private final IObjectScheme schema;

    public TypeParameter( @NonNull IObjectScheme schema) {
        assert (schema != null);
        this.schema = schema;
    }

    @Override
    public NamedTypeDescription getSpecification() {
        return schema.getSpecification();
    }


    @Override
    public @Nullable NamedTypeDescription getSuperClass() {
        return schema.getSuperClass();
    }


    @Override
    public @Nullable Set<NamedTypeDescription> getInterfaces() {
        return schema.getInterfaces();
    }

    @Override
    public boolean isParameterized() {
        return schema.isParameterized();
    }

    @Override
    public @Nullable List<TypeParameter> getFormalParameters() {
        return schema.getFormalParameters();
    }

    @Override
    public Set<ModifierKind> getModifiers() {
        return schema.getModifiers();
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
