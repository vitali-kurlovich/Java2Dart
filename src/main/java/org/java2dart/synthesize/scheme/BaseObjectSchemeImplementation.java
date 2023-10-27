package org.java2dart.synthesize.scheme;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;

public abstract class BaseObjectSchemeImplementation implements ObjectSchemeImplementation {

    protected TypeSpecifier typeSpecifier;

    public BaseObjectSchemeImplementation(TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }

}
