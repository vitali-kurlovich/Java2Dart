package org.java2dart.synthesize.scheme.dart;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public class DartModifiersSpecifier implements ModifiersSpecifier {

    @Override
    public @NonNull String specify(Set<ModifierKind> modifiers) {
        final var builder = new StringBuilder();

       final var modifiresSchema = new ModifiersSchema(modifiers);


       if (modifiresSchema.isPublic()) {
           builder.append("public ");
       }

        if (modifiresSchema.isProtected()) {
            builder.append("protected ");
        }

        if (modifiresSchema.isPrivate()) {
            builder.append("private ");
        }

        if (modifiresSchema.isStatic()) {
            builder.append("static ");
        }

        if (modifiresSchema.isFinal()) {
            builder.append("final ");
        }

        if (modifiresSchema.isAbstract()) {
            builder.append("abstract ");
        }


        return builder.toString();
    }
}
