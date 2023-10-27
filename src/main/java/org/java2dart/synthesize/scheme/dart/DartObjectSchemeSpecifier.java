package org.java2dart.synthesize.scheme.dart;

import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.scheme.ObjectSchemeSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;


// CtVariable<?> variable

public class DartObjectSchemeSpecifier implements ObjectSchemeSpecifier {
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
                .append(prototype(type)).append(" ")
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


        return builder.toString();
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

    /*
    public @NonNull String specify(IObjectScheme scheme) {
        final var typeDescription = scheme.getSpecification();
        final var builder = new StringBuilder();

        builder.append(modifiersSpecifier.specify(scheme.getModifiers()));

       // builder.append(typeSpecifier.specify(typeDescription));

        if (scheme.isParameterized()) {
            final var formalParameters = scheme.getFormalParameters();

            var needsSeparator = false;
            builder.append("<");
            for (final var param : formalParameters) {

                if (needsSeparator) {
                    builder.append(", ");
                }

                final var paramSpec = specify(param);
                builder.append(paramSpec);

                needsSeparator = true;
            }
            builder.append(">");
        }

        final var superSpec = scheme.getSuperClass();
        if (superSpec != null) {

            builder.append(" extended ");
            builder.append(typeSpecifier.specify(superSpec));
        }

        final var interfaces = scheme.getInterfaces();

        if (interfaces != null && !interfaces.isEmpty()) {
            switch (scheme.getTypeKing()) {

                case ENUM, NONE, PRIMITIVE, GENERIC -> {
                    throw new RuntimeException("Not implemented");
                }
                case CLASS -> {
                    builder.append(" implement ");
                }
                case INTERFACE -> {
                    builder.append(" extends ");
                }
            }

            var needsSeparator = false;
            for (final var ref : interfaces) {
                if (needsSeparator) {
                    builder.append(", ");
                }
                final var spec = typeSpecifier.specify(ref);
                builder.append(spec);

                needsSeparator = true;
            }
        }


        return builder.toString();
    }
*/

}
