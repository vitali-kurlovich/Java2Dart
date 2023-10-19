package org.java2dart.factory.synthesize;

import org.java2dart.synthesize.param.BaseTypeParameterSpecifier;
import org.java2dart.synthesize.param.dart.DartTypeParameterSpecifier;
import org.java2dart.synthesize.scheme.BaseSchemeSpecifier;
import org.java2dart.synthesize.scheme.dart.DartSchemeSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.synthesize.type.dart.DartTypeSpecifier;

public class SpecifierFactory {
    private final BaseTypeSpecifier typeSpecifier ;
    private final BaseTypeParameterSpecifier typeParameterSpecifier;

    private final BaseSchemeSpecifier schemeSpecifier;

    public SpecifierFactory() {
        typeSpecifier = new DartTypeSpecifier();

        typeParameterSpecifier = new DartTypeParameterSpecifier(typeSpecifier);

        schemeSpecifier =  new DartSchemeSpecifier(typeSpecifier, typeParameterSpecifier);
    }

    public BaseTypeSpecifier typeSpecifier() {
        return typeSpecifier;
    }

  //  public BaseSchemeSpecifier BaseSchemeSpecifier
    public BaseTypeParameterSpecifier typeParameterSpecifier() {
        return typeParameterSpecifier;
    }

    public BaseSchemeSpecifier schemeSpecifier() {
        return new DartSchemeSpecifier(typeSpecifier(), typeParameterSpecifier());
    }


}
