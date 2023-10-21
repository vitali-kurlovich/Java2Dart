package org.java2dart.schema.modifier;

import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public interface Modifible {
    Set<ModifierKind> getModifiers();
}
