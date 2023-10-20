package org.java2dart.synthesize.scheme;


import org.java2dart.synthesize.type.BaseTypeSpecifier;

public abstract class BaseObjectSchemeSpecifier implements ObjectSchemeSpecifier {
    protected BaseTypeSpecifier typeSpecifier;

    public BaseObjectSchemeSpecifier(BaseTypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }
}
