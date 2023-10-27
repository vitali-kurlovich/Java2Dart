package org.java2dart.synthesize.definition.scheme;

import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.scheme.ObjectSchemeSpecifier;
import org.jspecify.annotations.NonNull;


public abstract class BaseSchemeDefinitionSpecifier implements SchemeDefinitionSpecifier {
    protected final @NonNull ObjectSchemeSpecifier schemeSpecifier;
    protected final @NonNull ModifiersSpecifier modifiersSpecifier;


    public BaseSchemeDefinitionSpecifier(ObjectSchemeSpecifier schemeSpecifier,
                                         ModifiersSpecifier modifiersSpecifier) {
        this.schemeSpecifier = schemeSpecifier;
        this.modifiersSpecifier = modifiersSpecifier;
    }
}
