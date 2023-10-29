package org.java2dart.synthesize.definition.dart;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.synthesize.definition.modifiers.ModifiersDefinitionSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtModifiable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public final class DartModifiersDefinitionSpecifier implements ModifiersDefinitionSpecifier {

    public @NonNull String specify(CtModifiable modifiable) {
        return specify(modifiable.getModifiers());
    }

    private @NonNull String specify(Set<ModifierKind> modifiers) {
        final var builder = new StringBuilder();

        final var modifiersSchema = new ModifiersSchema(modifiers);

        if (modifiersSchema.isPublic()) {
            builder.append("public ");
        }

        if (modifiersSchema.isProtected()) {
            builder.append("protected ");
        }

        if (modifiersSchema.isPrivate()) {
            builder.append("private ");
        }

        if (modifiersSchema.isStatic()) {
            builder.append("static ");
        }

        if (modifiersSchema.isFinal()) {
            builder.append("final ");
        }

        if (modifiersSchema.isAbstract()) {
            builder.append("abstract ");
        }

        return builder.toString().trim();
    }
}
