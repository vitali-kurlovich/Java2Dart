package org.java2dart.synthesize.definition.dart;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.schema.varible.IVariable;
import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.definition.varible.BaseVariableDefinitionSpecifier;
import org.java2dart.synthesize.scheme.BaseObjectSchemeSpecifier;
import org.java2dart.synthesize.definition.scheme.BaseSchemeDefinitionSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public class DartSchemeDefinitionSpecifier extends BaseSchemeDefinitionSpecifier {
    public DartSchemeDefinitionSpecifier(@NonNull BaseObjectSchemeSpecifier typeParameterSpecifier,
                                         @NonNull ModifiersSpecifier modifiersSpecifier) {
        super(typeParameterSpecifier, modifiersSpecifier);
    }

    @Override
    public @NonNull String specify(IObjectScheme scheme) {
        return specify(scheme.getModifiers()) + " " +
                specify(scheme.getTypeKing()) + " " +
                schemeSpecifier.specify(scheme);
    }

    private @NonNull String specify(TypeDescription.TypeKind kind) {
        switch (kind) {
            case ENUM -> {
                return "enum";
            }
            case CLASS -> {
                return "class";
            }
            case INTERFACE -> {
                return "interface";
            }
            default -> {
                throw new IllegalStateException("Incorrect TypeKind: " + kind);
            }
        }

    }

    private @NonNull String specify(Set<ModifierKind> modifiers) {
        return modifiersSpecifier.specify(modifiers);
    }


}


