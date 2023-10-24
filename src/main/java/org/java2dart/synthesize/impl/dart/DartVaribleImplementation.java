package org.java2dart.synthesize.impl.dart;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.synthesize.impl.BaseVaribleImplementation;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;


public final class  DartVaribleImplementation extends BaseVaribleImplementation {

    public DartVaribleImplementation(ModifiersSpecifier modifiersSpecifier,  BaseTypeSpecifier typeSpecifier) {
        super(modifiersSpecifier, typeSpecifier);
    }

    @Override
    public @NonNull String varible(@Nullable Set<ModifierKind> modifires, @NonNull String name, @NonNull TypeDescription type) {

        final var modifiersSchema = new  ModifiersSchema(modifires);
        final var typeDsc =  typeSpecifier.specify(type);
        
        return modifiersSpecifier.specify(modifires)  + typeDsc + " " + name;
    }
}
