package org.java2dart.synthesize.scheme.dart;

import org.java2dart.schema.ClassSchema;
import org.java2dart.synthesize.param.BaseTypeParameterSpecifier;
import org.java2dart.synthesize.scheme.BaseSchemeSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;

public class DartSchemeSpecifier extends BaseSchemeSpecifier {
    public DartSchemeSpecifier(BaseTypeSpecifier typeSpecifier, BaseTypeParameterSpecifier typeParameterSpecifier) {
        super(typeSpecifier, typeParameterSpecifier);
    }


// TODO: use factory


    @Override
    public @NonNull String specify(ClassSchema scheme) {

        final var builder = new StringBuilder();

        builder.append("class ");
        final var specification = scheme.getSpecification();

        final var typeName = typeSpecifier.specify(specification);

        builder.append(typeName);

        if (scheme.isParameterized()) {
            final var formalParameters = scheme.getFormalParameters();

            var needsSeparator = false;
            builder.append("<");
            for (final var param : formalParameters) {
                final var paramSpec = typeParameterSpecifier.specify(param);
                builder.append(paramSpec);
                if (needsSeparator) {
                    builder.append(", ");
                }
                needsSeparator = true;
            }
            builder.append(">");
        }


        return builder.toString();
    }

}
