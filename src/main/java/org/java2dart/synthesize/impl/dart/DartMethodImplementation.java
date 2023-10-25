package org.java2dart.synthesize.impl.dart;

import org.java2dart.schema.method.Parameter;
import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.impl.method.BaseMethodImplementation;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.List;
import java.util.Set;

public class DartMethodImplementation extends BaseMethodImplementation {

    public DartMethodImplementation(MethodDefinitionSpecifier methodDefinitionSpecifier) {
        super(methodDefinitionSpecifier);
    }


}
