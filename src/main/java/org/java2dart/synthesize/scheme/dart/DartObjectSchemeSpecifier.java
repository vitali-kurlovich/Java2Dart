package org.java2dart.synthesize.scheme.dart;

import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.scheme.ObjectSchemeSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;


// CtVariable<?> variable

public final class DartObjectSchemeSpecifier implements ObjectSchemeSpecifier {
    private final TypeSpecifier typeSpecifier;
    private final ModifiersSpecifier modifiersSpecifier;

    public DartObjectSchemeSpecifier(TypeSpecifier typeSpecifier, ModifiersSpecifier modifiersSpecifier) {

        this.typeSpecifier = typeSpecifier;
        this.modifiersSpecifier = modifiersSpecifier;
    }

    @Override
    public @NonNull String specify(CtType<?> type) {
        final var builder = new StringBuilder();

        builder.append(modifiersSpecifier.specify(type.getModifiers()))
                .append(" ")
                .append(prototype(type))
                .append(" ")
                .append(typeSpecifier.specify(type.getReference()));

        if (type.isParameterized()) {
            final var parameters = type.getFormalCtTypeParameters();

            builder.append("<");

            var needsSeparator = false;
            for (final var param : parameters) {
                if (needsSeparator) {
                    builder.append(", ");
                }
                builder.append(specify(param));
                needsSeparator = true;
            }

            builder.append(">");
        }

        final var superSpec = type.getSuperclass();
        if (superSpec != null) {

            builder.append(" extended ");
            builder.append(typeSpecifier.specify(superSpec));
        }

        final var superInterfaces = type.getSuperInterfaces();

        if (superInterfaces != null && !superInterfaces.isEmpty()) {
            builder.append(" implement ");

            var needsSeparator = false;

            for (final var ref : superInterfaces) {
                if (needsSeparator) {
                    builder.append(", ");
                }
                final var spec = typeSpecifier.specify(ref);
                builder.append(spec);

                needsSeparator = true;
            }
        }

        return builder.toString().trim();
    }


    public @NonNull String prototype(CtType<?> type) {
        if (type.isEnum()) {
            return "enum";
        }

        if (type.isInterface()) {
            return "interface";
        }

        if (type.isClass()) {
            return "class";
        }

        return "";
    }


}
