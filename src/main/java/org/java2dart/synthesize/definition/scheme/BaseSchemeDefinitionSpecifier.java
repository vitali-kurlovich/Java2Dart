package org.java2dart.synthesize.definition.scheme;

import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.scheme.BaseObjectSchemeSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.jspecify.annotations.NonNull;


public abstract class BaseSchemeDefinitionSpecifier implements SchemeDefinitionSpecifier {
    protected final @NonNull BaseObjectSchemeSpecifier schemeSpecifier;
    protected final @NonNull ModifiersSpecifier modifiersSpecifier;



    public BaseSchemeDefinitionSpecifier(BaseObjectSchemeSpecifier schemeSpecifier,
                                         ModifiersSpecifier modifiersSpecifier) {
        this.schemeSpecifier = schemeSpecifier;
        this.modifiersSpecifier = modifiersSpecifier;
    }
}
