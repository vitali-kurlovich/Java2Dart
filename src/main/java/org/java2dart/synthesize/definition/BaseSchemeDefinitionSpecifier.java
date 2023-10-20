package org.java2dart.synthesize.definition;

import org.java2dart.synthesize.scheme.BaseObjectSchemeSpecifier;


public abstract class BaseSchemeDefinitionSpecifier implements SchemeDefinitionSpecifier {
    protected final BaseObjectSchemeSpecifier schemeSpecifier;

    public BaseSchemeDefinitionSpecifier(BaseObjectSchemeSpecifier schemeSpecifier) {

        this.schemeSpecifier = schemeSpecifier;
    }
}
