package org.java2dart.schema.varible;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;



public class BaseVarible  implements IVariable {
    @NonNull
    private final String name;
    @NonNull
    private final TypeDescription type;
    private final ModifiersSchema modifiersSchema;

    public BaseVarible(@NonNull String name, @NonNull TypeDescription type, Set<ModifierKind> modifiers) {
        this.name = name;
        this.type = type;
        this.modifiersSchema = new  ModifiersSchema(modifiers);
    }

    @Override
    public AccesLevel getAccessLevel() {
        return modifiersSchema.getAccessLevel();
    }

    @Override
    public Set<ModifierKind> getModifiers() {
        return modifiersSchema.getModifiers();
    }

    @Override
    public @NonNull String getName() {
        return name;
    }

    @Override
    public @NonNull TypeDescription getType() {
        return type;
    }
}
