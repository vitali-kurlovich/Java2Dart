package org.java2dart.factory;

import org.java2dart.synthesize.scheme.ObjectSchemeImplementation;
import org.java2dart.synthesize.scheme.dart.DartObjectSchemeImplementation;
import org.java2dart.synthesize.type.dart.DartTypeSpecifier;

public final class Factory {

    private static final ObjectSchemeImplementation _schemeImplementation = new DartObjectSchemeImplementation(new DartTypeSpecifier());

    public static ObjectSchemeImplementation SchemeImplementation() {
        return _schemeImplementation;
    }

}
