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

       final var typeDescription = parameter.typeDescription;
// TODO: interface spec

        return  typeSpecifier.specify(typeDescription);
    }
}
