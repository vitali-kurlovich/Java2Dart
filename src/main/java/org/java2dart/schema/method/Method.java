package org.java2dart.schema.method;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.varible.Parameter;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.List;
import java.util.Set;

public class Method implements IMethod {
    @NonNull
    private final String name;
    @NonNull
    private final TypeDescription returnType;
    private final ModifiersSchema modifiersSchema;

    private final List<Parameter> parameters;

    public Method(@NonNull String name, @NonNull TypeDescription returnType, Set<ModifierKind> modifiers, List<Parameter> parameters) {
        this.name = name;
        this.returnType = returnType;
        this.modifiersSchema = new ModifiersSchema(modifiers);
        this.parameters = parameters;
    }

    @Override
    public @NonNull String getName() {
        return name;
    }

    @Override
    public @NonNull TypeDescription getReturnType() {
        return returnType;
    }

    @Override
    public @Nullable List<Parameter> getArguments() {
        return parameters;
    }

    @Override
    public AccesLevel getAccessLevel() {
        return modifiersSchema.getAccessLevel();
    }

    @Override
    public Set<ModifierKind> getModifiers() {
        return modifiersSchema.getModifiers();
    }
}
