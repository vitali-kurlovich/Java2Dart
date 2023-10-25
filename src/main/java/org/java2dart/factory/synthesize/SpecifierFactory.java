package org.java2dart.factory.synthesize;

import org.java2dart.synthesize.definition.dart.DartMethodDefinitionSpecifier;
import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.scheme.BaseObjectSchemeSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.scheme.dart.DartModifiersSpecifier;
import org.java2dart.synthesize.scheme.dart.DartObjectSchemeSpecifier;
import org.java2dart.synthesize.definition.scheme.BaseSchemeDefinitionSpecifier;
import org.java2dart.synthesize.definition.dart.DartSchemeDefinitionSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.synthesize.type.dart.DartTypeSpecifier;

public class SpecifierFactory {
    private final BaseTypeSpecifier typeSpecifier;
    private final BaseObjectSchemeSpecifier typeParameterSpecifier;
    private final BaseSchemeDefinitionSpecifier schemeSpecifier;
    private final ModifiersSpecifier modifiersSpecifier;


    public SpecifierFactory() {
        typeSpecifier = new DartTypeSpecifier();
        typeParameterSpecifier = new DartObjectSchemeSpecifier(typeSpecifier);
        modifiersSpecifier = new DartModifiersSpecifier();
        schemeSpecifier = new DartSchemeDefinitionSpecifier(typeParameterSpecifier, modifiersSpecifier );
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

    public ModifiersSpecifier modifiersSpecifier() {
        return modifiersSpecifier;
    }

}
