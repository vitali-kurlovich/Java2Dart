package org.java2dart.synthesize.scheme.dart;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.synthesize.scheme.BaseObjectSchemeSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;

public class DartObjectSchemeSpecifier extends BaseObjectSchemeSpecifier {

    public DartObjectSchemeSpecifier(BaseTypeSpecifier typeSpecifier) {
        super(typeSpecifier);
    }

    @Override
    public @NonNull String specify(IObjectScheme scheme) {
        final var typeDescription = scheme.getSpecification();
        final var builder = new StringBuilder();
        builder.append(typeSpecifier.specify(typeDescription));

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
}
