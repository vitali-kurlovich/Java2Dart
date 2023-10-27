package org.java2dart.synthesize.definition.dart;

import org.java2dart.schema.method.IMethod;
import org.java2dart.schema.method.Parameter;
import org.java2dart.synthesize.definition.method.BaseMethodDefinitionSpecifier;
import org.java2dart.synthesize.definition.varible.VariableDefinitionSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;

import java.util.List;
import java.util.Set;

public class DartMethodDefinitionSpecifier extends BaseMethodDefinitionSpecifier {

    public DartMethodDefinitionSpecifier(@NonNull ModifiersSpecifier modifiersSpecifier,
                                         @NonNull TypeSpecifier typeSpecifier,
                                         @NonNull VariableDefinitionSpecifier variableSpecifier) {
        super(modifiersSpecifier, typeSpecifier, variableSpecifier);
    }

    @Override
    public @NonNull String specify(CtMethod<?> method) {
        final var builder = new StringBuilder();
        builder.append(modifiersSpecifier.specify(method.getModifiers()));
        builder.append(" ")
                .append(method.getSimpleName())
                .append("(")
                .append(")");

        return builder.toString();
    }

    public @NonNull String method(@Nullable Set<ModifierKind> modifiers,
                                  @NonNull String name,
                                  @NonNull TypeDescription returnType,
                                  @Nullable List<Parameter> arguments) {


        final var builder = new StringBuilder();

        builder.append(modifiersSpecifier.specify(modifiers))
              //  .append(typeSpecifier.specify(returnType))
                .append(" ")
                .append(name)
                .append("(");

        var needsSeparator = false;
        for (final var arg : arguments) {
            if (needsSeparator) {
                builder.append(", ");
            }
            final var spec = variableSpecifier.specify(arg);
            builder.append(spec);

            needsSeparator = true;
        }

        builder.append(")");

        return builder.toString();
    }


}
