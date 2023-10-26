package org.java2dart.schema.field;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.modifier.Accesable;
import org.java2dart.schema.modifier.Modifible;
import org.java2dart.schema.varible.IVariable;
import org.java2dart.schema.varible.Variable;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public class Field implements IVariable, Accesable, Modifible {
    private final @NonNull ModifiersSchema modifiersSchema;

    private final @NonNull Variable variable;

    public Field(@NonNull String name, @NonNull TypeDescription type, Set<ModifierKind> modifiers) {
        this(new Variable(name, type), modifiers);
    }

    public Field(@NonNull Variable variable, Set<ModifierKind> modifiers) {
        this.modifiersSchema = new ModifiersSchema(modifiers);
        this.variable = variable;
    }


    public AccesLevel getAccessLevel() {
        return modifiersSchema.getAccessLevel();
    }


    public Set<ModifierKind> getModifiers() {
        return modifiersSchema.getModifiers();
    }

    @Override
    public @NonNull String getName() {
        return variable.getName();
    }

    @Override
    public @NonNull TypeDescription getType() {
        return variable.getType();
    }
}
