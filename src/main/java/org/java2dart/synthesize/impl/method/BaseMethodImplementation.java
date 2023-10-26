package org.java2dart.synthesize.impl.method;

import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;

public abstract class BaseMethodImplementation implements MethodImplementation {
    protected final MethodDefinitionSpecifier methodDefinitionSpecifier;

    public BaseMethodImplementation(MethodDefinitionSpecifier methodDefinitionSpecifier) {
        this.methodDefinitionSpecifier = methodDefinitionSpecifier;
    }
}
