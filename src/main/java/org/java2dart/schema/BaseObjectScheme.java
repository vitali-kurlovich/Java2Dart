package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;


public abstract class BaseObjectScheme implements IObjectScheme {
    private final NamedTypeDescription specification;
    private final @Nullable NamedTypeDescription superClass;
    private final @Nullable Set<NamedTypeDescription> interfaces;

    private final @Nullable List<IObjectScheme> formalParameters;

    public BaseObjectScheme(NamedTypeDescription specification,
                            @Nullable NamedTypeDescription superClass,
                            @Nullable List<IObjectScheme> formalParameters,
                            @Nullable Set<NamedTypeDescription> interfaces
                        ) {
        this.specification = specification;
        this.superClass = superClass;
        this.interfaces = interfaces;
        this.formalParameters = formalParameters;
    }

    public BaseObjectScheme(@NonNull NamedTypeDescription specification,
                            @Nullable NamedTypeDescription superClass,
                            @Nullable List<IObjectScheme> formalParameters) {

        this(specification, superClass, formalParameters , null);
    }

    public BaseObjectScheme(@NonNull NamedTypeDescription specification,
                            @Nullable List<IObjectScheme> formalParameters,
                            @Nullable Set<NamedTypeDescription> interfaces
                        ) {

        this(specification, null, formalParameters, interfaces );
    }

    public BaseObjectScheme(@NonNull NamedTypeDescription specification,
                            @Nullable List<IObjectScheme> formalParameters) {

        this(specification, null, formalParameters,null);
    }

    public BaseObjectScheme(@NonNull NamedTypeDescription specification) {

        this(specification, null, null, null);
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

    public boolean isParameterized() {
        return getFormalParameters() != null && !getFormalParameters().isEmpty();
    }


    public @Nullable List<IObjectScheme> getFormalParameters() {
        return formalParameters;
    }


}
