package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Set;

public class TypeParameter {
    private final @NonNull NamedTypeDescription specification;

    private final @Nullable NamedTypeDescription superClass;
    private final @Nullable Set<NamedTypeDescription> interfaces;

    public TypeParameter(@NonNull NamedTypeDescription specification,
                         @Nullable NamedTypeDescription superClass,
                         @Nullable Set<NamedTypeDescription> interfaces) {
        this.specification = specification;
        this.superClass = superClass;
        this.interfaces = interfaces;
    }

    public TypeParameter(@NonNull NamedTypeDescription specification,
                         @Nullable NamedTypeDescription superClass) {

        this(specification, superClass, null);
    }


    public NamedTypeDescription getSpecification() {
        return specification;
    }

    public boolean isExtends() {
        return getSuperClass() != null;
    }

    public @Nullable NamedTypeDescription getSuperClass() {
        return superClass;
    }

    public boolean isImplements() {
        return getInterfaces() != null && !getInterfaces().isEmpty();
    }

    public @Nullable Set<NamedTypeDescription> getInterfaces() {
        return interfaces;
    }
}
