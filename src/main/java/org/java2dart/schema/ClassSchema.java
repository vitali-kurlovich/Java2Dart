package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class ClassSchema extends BaseObjectScheme {

    public ClassSchema(Set<ModifierKind> modifiers, NamedTypeDescription specification, @Nullable NamedTypeDescription superClass, @Nullable List<IObjectScheme> formalParameters, @Nullable Set<NamedTypeDescription> interfaces) {
        super(modifiers, specification, superClass, formalParameters, interfaces);
    }

    public ClassSchema(Set<ModifierKind> modifiers, @NonNull NamedTypeDescription specification, @Nullable NamedTypeDescription superClass, @Nullable List<IObjectScheme> formalParameters) {
        super(modifiers, specification, superClass, formalParameters);
    }

    public ClassSchema(@NonNull NamedTypeDescription specification, @Nullable List<IObjectScheme> formalParameters, @Nullable Set<NamedTypeDescription> interfaces, Set<ModifierKind> modifiers) {
        super(specification, formalParameters, interfaces, modifiers);
    }

    public ClassSchema(@NonNull NamedTypeDescription specification, @Nullable List<IObjectScheme> formalParameters, Set<ModifierKind> modifiers) {
        super(specification, formalParameters, modifiers);
    }

    public ClassSchema(@NonNull NamedTypeDescription specification, Set<ModifierKind> modifiers) {
        super(specification, modifiers);
    }
}
