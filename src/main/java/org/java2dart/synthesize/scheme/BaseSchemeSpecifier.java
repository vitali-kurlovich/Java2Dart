package org.java2dart.synthesize.scheme;

import org.java2dart.synthesize.param.BaseTypeParameterSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;


public abstract class BaseSchemeSpecifier implements SchemeSpecifier {

   protected final BaseTypeParameterSpecifier typeParameterSpecifier;
   protected final BaseTypeSpecifier typeSpecifier;


    public BaseSchemeSpecifier(BaseTypeSpecifier typeSpecifier, BaseTypeParameterSpecifier typeParameterSpecifier) {
        this.typeSpecifier = typeSpecifier;
        this.typeParameterSpecifier = typeParameterSpecifier;
    }
}
