package org.java2dart.synthesize.scheme;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;

public abstract class BaseObjectSchemeImplementation implements ObjectSchemeImplementation {

    protected BaseTypeSpecifier typeSpecifier;

    public BaseObjectSchemeImplementation(BaseTypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }

}
