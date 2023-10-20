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
    public boolean isExtends() {
        return schema.isExtends();
    }

    @Override
    public @Nullable NamedTypeDescription getSuperClass() {
        return schema.getSuperClass();
    }

    @Override
    public boolean isImplements() {
        return schema.isImplements();
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
}
