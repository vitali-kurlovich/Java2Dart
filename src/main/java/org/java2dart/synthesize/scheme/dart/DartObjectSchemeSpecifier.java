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
    public @NonNull String specify(IObjectScheme parameter) {
        final var typeDescription = parameter.getSpecification();
        final var builder = new StringBuilder();
        builder.append(typeSpecifier.specify(typeDescription));

        if (parameter.isParameterized()) {
            final var formalParameters = parameter.getFormalParameters();

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

        if (parameter.isExtends()) {
            builder.append(" extended ");
            final var superSpec = parameter.getSuperClass();
            builder.append(typeSpecifier.specify(superSpec));
        }

// TODO: interface spec

        if (parameter.isImplements()) {
            final var interfaces = parameter.getInterfaces();
            builder.append(" implement ");

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
