package org.java2dart.schema;

import org.java2dart.schema.method.Method;
import org.java2dart.schema.modifier.Accesable;
import org.java2dart.schema.modifier.Modifible;
import org.java2dart.schema.field.Field;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public interface IObjectScheme extends Accesable, Modifible, NamedTypeDescription {
    NamedTypeDescription getSpecification();

    @Nullable NamedTypeDescription getSuperClass();

    @Nullable Set<NamedTypeDescription> getInterfaces();

    boolean isParameterized();

    @Nullable List<TypeParameter> getFormalParameters();

    List<Field> getFields();

    Set<Method> getMethods();

}
