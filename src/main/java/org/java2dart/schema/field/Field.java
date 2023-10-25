package org.java2dart.schema.field;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.modifier.Accesable;
import org.java2dart.schema.modifier.Modifible;
import org.java2dart.schema.varible.BaseVariable;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;


public class Field extends BaseVariable implements Accesable, Modifible {

    private final ModifiersSchema modifiersSchema;

    public Field(@NonNull String name, @NonNull TypeDescription type, Set<ModifierKind> modifiers) {
        super(name, type);
        this.modifiersSchema = new ModifiersSchema(modifiers);
    }


    public AccesLevel getAccessLevel() {
        return modifiersSchema.getAccessLevel();
    }


    public Set<ModifierKind> getModifiers() {
        return modifiersSchema.getModifiers();
    }
}
