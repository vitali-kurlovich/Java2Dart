package org.java2dart.synthesize.param;


import org.java2dart.schema.TypeParameter;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;

public abstract class BaseTypeParameterSpecifier implements TypeParameterSpecifier {

    protected BaseTypeSpecifier typeSpecifier;

    public BaseTypeParameterSpecifier(BaseTypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }
}
