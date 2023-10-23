package org.java2dart.synthesize.definition.dart;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.synthesize.scheme.BaseObjectSchemeSpecifier;
import org.java2dart.synthesize.definition.BaseSchemeDefinitionSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DartSchemeDefinitionSpecifier extends BaseSchemeDefinitionSpecifier {
    public DartSchemeDefinitionSpecifier(BaseObjectSchemeSpecifier typeParameterSpecifier) {
        super( typeParameterSpecifier);
    }

    @Override
    public @NonNull String specify(IObjectScheme scheme) {

        String builder = specify(scheme.getModifiers()) + " " +
                specify(scheme.getTypeKing()) + " " +
                schemeSpecifier.specify(scheme);

        return builder;
    }

    private  @NonNull String specify(TypeDescription.TypeKind kind) {
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
              throw  new IllegalStateException("Incorrect TypeKind: " + kind);
            }
        }

    }

    private @NonNull String specify(Set<ModifierKind> modifires) {

        var tokens = new ArrayList<String>();

         if (modifires.contains(ModifierKind.STATIC)) {
             tokens.add("static");
         }

        if (modifires.contains(ModifierKind.FINAL)) {
            tokens.add("final");
        }

        if (modifires.contains(ModifierKind.ABSTRACT)) {
            tokens.add("abstract");
        }


        final var builder = new  StringBuilder();
        var needsWhitespace = false;
        for (final var token: tokens) {

            if (needsWhitespace) {
                builder.append(" ");
            }

            builder.append(token);

            needsWhitespace = true;
        }



        return builder.toString();
    }

}


