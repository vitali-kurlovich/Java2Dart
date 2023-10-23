package org.java2dart.schema.base;

import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.modifier.Accesable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Collections;
import java.util.Set;

public final class ModifiersSchema implements Accesable {
    public final Set<ModifierKind> modifiers;

    public ModifiersSchema(Set<ModifierKind> modifiers) {
        this.modifiers = Collections.unmodifiableSet(modifiers);
    }

    @Override
    public AccesLevel getAccessLevel() {
        for (final var kind: getModifiers()) {
            switch (kind) {
                case PUBLIC -> {
                    return AccesLevel.PUBLIC;
                }
                case PROTECTED -> {
                    return AccesLevel.PROTECTED;
                }
                case PRIVATE -> {
                    return AccesLevel.PRIVATE;
                }
                default -> {

                }
            }
        }

        return AccesLevel.DEFAULT;
    }

    @Override
    public Set<ModifierKind> getModifiers() {
        return modifiers;
    }


}
