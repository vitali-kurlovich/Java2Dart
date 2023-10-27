package org.java2dart.factory.synthesize;

import org.java2dart.synthesize.definition.scheme.SchemeDefinitionSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.scheme.ObjectSchemeSpecifier;
import org.java2dart.synthesize.scheme.dart.DartModifiersSpecifier;
import org.java2dart.synthesize.definition.dart.DartSchemeDefinitionSpecifier;
import org.java2dart.synthesize.scheme.dart.DartObjectSchemeSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.java2dart.synthesize.type.dart.DartTypeSpecifier;

public class SpecifierFactory {
    private final TypeSpecifier typeSpecifier;
    private final SchemeDefinitionSpecifier schemeSpecifier;
    private final ModifiersSpecifier modifiersSpecifier;
    private final ObjectSchemeSpecifier objectSchemeSpecifier;

    public SpecifierFactory() {
        typeSpecifier = new DartTypeSpecifier();
        modifiersSpecifier = new DartModifiersSpecifier();
        objectSchemeSpecifier = new DartObjectSchemeSpecifier(typeSpecifier, modifiersSpecifier);

        schemeSpecifier = new DartSchemeDefinitionSpecifier(  objectSchemeSpecifier, modifiersSpecifier );
    }

    public TypeSpecifier typeSpecifier() {
        return typeSpecifier;
    }

    public SchemeDefinitionSpecifier schemeSpecifier() {
        return schemeSpecifier;
    }

    public ModifiersSpecifier modifiersSpecifier() {
        return modifiersSpecifier;
    }

}
