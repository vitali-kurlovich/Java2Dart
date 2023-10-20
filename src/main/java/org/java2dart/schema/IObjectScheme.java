package org.java2dart.schema;

import org.java2dart.schema.modifier.Modifible;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public interface IObjectScheme extends Modifible {
    NamedTypeDescription getSpecification();

    boolean isExtends();

    @Nullable NamedTypeDescription getSuperClass();

    boolean isImplements();

    @Nullable Set<NamedTypeDescription> getInterfaces();

    boolean isParameterized();


    @Nullable List<IObjectScheme> getFormalParameters();

}
