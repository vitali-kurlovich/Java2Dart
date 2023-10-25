package org.java2dart.schema;

import org.java2dart.schema.base.BaseObjectScheme;
import org.java2dart.schema.method.Method;
import org.java2dart.schema.field.Field;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.List;
import java.util.Set;

public class GenericSchema extends BaseObjectScheme {

    public GenericSchema(Set<ModifierKind> modifiers,
                         @NonNull NamedTypeDescription specification,
                         @Nullable List<TypeParameter> formalParameters,
                         @Nullable NamedTypeDescription superClass,
                         @Nullable Set<NamedTypeDescription> interfaces,
                         @Nullable List<Field> fields,
                         @Nullable  Set<Method> methods) {
        super(modifiers, specification, formalParameters, superClass, interfaces, fields, methods);
    }
}
