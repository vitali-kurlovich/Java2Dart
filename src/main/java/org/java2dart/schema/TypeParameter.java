package org.java2dart.schema;

import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.varible.Field;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

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
    public List<Field> getFields() {
        return schema.getFields();
    }

    @Override
    public Set<ModifierKind> getModifiers() {
        return schema.getModifiers();
    }

    @Override
    public AccesLevel getAccessLevel() {
        return schema.getAccessLevel();
    }


    @Override
    public @NonNull String getTypeName() {
        return schema.getTypeName();
    }

    @Override
    public boolean isVoid() {
        return schema.isVoid();
    }

    @Override
    public boolean isPrimitive() {
        return schema.isPrimitive();
    }

    @Override
    public boolean isNullable() {
        return schema.isNullable();
    }

    @Override
    public boolean isArray() {
        return schema.isArray();
    }

    @Override
    public boolean isGeneric() {
        return schema.isGeneric();
    }

    @Override
    public TypeKind getTypeKing() {
        return schema.getTypeKing();
    }


}
