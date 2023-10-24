package org.java2dart.factory.synthesize;

import org.java2dart.synthesize.scheme.BaseObjectSchemeSpecifier;
import org.java2dart.synthesize.scheme.dart.DartObjectSchemeSpecifier;
import org.java2dart.synthesize.definition.BaseSchemeDefinitionSpecifier;
import org.java2dart.synthesize.definition.dart.DartSchemeDefinitionSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.synthesize.type.dart.DartTypeSpecifier;

public class SpecifierFactory {
    private final BaseTypeSpecifier typeSpecifier;
    private final BaseObjectSchemeSpecifier typeParameterSpecifier;
    private final BaseSchemeDefinitionSpecifier schemeSpecifier;

    public SpecifierFactory() {
        typeSpecifier = new DartTypeSpecifier();
        typeParameterSpecifier = new DartObjectSchemeSpecifier(typeSpecifier);
        schemeSpecifier = new DartSchemeDefinitionSpecifier(typeParameterSpecifier);
    }

    public BaseTypeSpecifier typeSpecifier() {
        return typeSpecifier;
    }

    public BaseObjectSchemeSpecifier typeParameterSpecifier() {
        return typeParameterSpecifier;
    }

    public BaseSchemeDefinitionSpecifier schemeSpecifier() {
        return schemeSpecifier;
    }


}
