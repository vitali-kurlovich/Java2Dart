package org.java2dart.schema.modifier;

import java.util.Set;

public interface Modifible {
    enum ModifierKind {
        ABSTRACT,
        FINAL,
        STATIC
    }

    Set<ModifierKind> getModifiers();
}
