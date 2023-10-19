package org.java2dart.synthesize.param.dart;

import org.java2dart.schema.TypeParameter;
import org.java2dart.synthesize.param.BaseTypeParameterSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;

public class DartTypeParameterSpecifier extends BaseTypeParameterSpecifier {

    public DartTypeParameterSpecifier(BaseTypeSpecifier typeSpecifier) {
        super(typeSpecifier);
    }

    @Override
    public @NonNull String specify(TypeParameter parameter) {
        final var typeDescription = parameter.getSpecification();
        final var builder = new StringBuilder();
        builder.append(typeSpecifier.specify(typeDescription));

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
