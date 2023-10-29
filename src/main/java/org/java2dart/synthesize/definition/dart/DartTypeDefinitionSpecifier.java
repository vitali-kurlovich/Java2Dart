package org.java2dart.synthesize.definition.dart;

import org.java2dart.synthesize.definition.scheme.TypeDefinitionSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;


public final class DartTypeDefinitionSpecifier implements TypeDefinitionSpecifier {

    private final @NonNull DartModifiersDefinitionSpecifier modifiersSpecifier;
    private final @NonNull DartTypeReferenceSpecifier typeReferenceSpecifier;

    public DartTypeDefinitionSpecifier(@NonNull DartModifiersDefinitionSpecifier modifiersSpecifier,
                                       @NonNull DartTypeReferenceSpecifier typeReferenceSpecifier) {
        this.modifiersSpecifier = modifiersSpecifier;
        this.typeReferenceSpecifier = typeReferenceSpecifier;
    }

    @Override
    public @NonNull String specify(CtType<?> type) {
        final var builder = new StringBuilder();

        builder.append(modifiersSpecifier.specify(type))
                .append(" ")
                .append(prototype(type))
                .append(" ")
                .append(typeReferenceSpecifier.specify(type.getReference()));

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
            builder.append(typeReferenceSpecifier.specify(superSpec));
        }

        final var superInterfaces = type.getSuperInterfaces();

        if (superInterfaces != null && !superInterfaces.isEmpty()) {
            builder.append(" implement ");

            var needsSeparator = false;

            for (final var ref : superInterfaces) {
                if (needsSeparator) {
                    builder.append(", ");
                }
                final var spec = typeReferenceSpecifier.specify(ref);
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
