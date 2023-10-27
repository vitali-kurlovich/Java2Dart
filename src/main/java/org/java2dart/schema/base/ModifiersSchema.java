package org.java2dart.schema.base;

import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.modifier.Accesable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Collections;
import java.util.Set;

public record ModifiersSchema(Set<ModifierKind> modifiers) implements Accesable {
    public ModifiersSchema(Set<ModifierKind> modifiers) {
        this.modifiers = Collections.unmodifiableSet(modifiers);
    }

    @Override
    public AccesLevel getAccessLevel() {
        for (final var kind : modifiers()) {
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

    public boolean isFinal() {
        return modifiers().contains(ModifierKind.FINAL);
    }

    public boolean isAbstract() {
        return modifiers().contains(ModifierKind.ABSTRACT);
    }

    public boolean isStatic() {
        return modifiers().contains(ModifierKind.STATIC);
    }

    public boolean isPublic() {
        return getAccessLevel().isPublic();
    }

    public boolean isProtected() {
        return getAccessLevel().isProtected();
    }

    public boolean isPrivate() {
        return getAccessLevel().isPrivate();
    }


}
