package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public interface IObjectScheme {
    public NamedTypeDescription getSpecification();

    public boolean isExtends();

    public @Nullable NamedTypeDescription getSuperClass();

    public boolean isImplements();

    public @Nullable Set<NamedTypeDescription> getInterfaces();

    public boolean isParameterized();


    public @Nullable List<IObjectScheme> getFormalParameters();

}
