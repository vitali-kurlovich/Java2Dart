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

        //scheme.getSpecification().is
        final var specification = scheme.getSpecification();

        builder.append(typeSpecifier.specify(specification));

        if (scheme.isParameterized()) {
            final var formalParameters = scheme.getFormalParameters();

            var needsSeparator = false;
            builder.append("<");
            for (final var param : formalParameters) {

                if (needsSeparator) {
                    builder.append(", ");
                }

                final var paramSpec = typeParameterSpecifier.specify(param);
                builder.append(paramSpec);

                needsSeparator = true;
            }
            builder.append(">");
        }

        if (scheme.isExtends()) {
            final var superClass = scheme.getSuperClass();
            builder.append(" extends ");
            final var typeSpec =  typeSpecifier.specify(superClass);

            builder.append(typeSpec);

           // final var typeName = typeSpecifier.specify();
        }

        if (scheme.isImplements()) {
           final var interfaces = scheme.getInterfaces();
            builder.append(" implements ");

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
