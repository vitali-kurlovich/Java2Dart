package org.java2dart.syntaxis.dart;

import org.java2dart.syntaxis.BaseTypeSpecifier;
import org.java2dart.types.array.ArrayTypeDescription;
import org.java2dart.types.generic.GenericTypeDescription;
import org.java2dart.types.none.VoidTypeDescription;
import org.java2dart.types.object.ObjectTypeDescription;
import org.java2dart.types.object.parameterized.ParameterizedTypeDescription;
import org.java2dart.types.primitive.PrimitiveTypeDescription;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;

public class DartTypeSpecifier extends BaseTypeSpecifier {

    @Override
    public @NonNull String specify(VoidTypeDescription description) {
        return "void";
    }

    @Override
    public @NonNull String specify(PrimitiveTypeDescription description) {

        switch (description.type) {
            case BYTE, INT, SHORT, LONG -> {
                return "int";
            }
            case FLOAT, CHAR -> {
                return "float";
            }
            case DOUBLE -> {
                return "double";
            }
            case BOOLEAN -> {
                return "bool";
            }
        }

        return "int";
    }

    @Override
    public @NonNull String specify(ObjectTypeDescription description) {
        return description.getTypeName();
    }

    @Override
    public @NonNull String specify(ParameterizedTypeDescription description) {

        final var args = description.getTypeArguments();
        final var builder = new StringBuilder();
        var needsSeparator = false;
        for (final var arg : args) {
            final var spec = specify(arg);
            if (needsSeparator) {
                builder.append(", ");
            }
            builder.append(spec);
            needsSeparator = true;
        }

        return description.getTypeName() + "<" + builder + ">";
    }

    @Override
    public @NonNull String specify(ArrayTypeDescription description) {

        return "List<" + specify(description.baseType) + ">";
    }

    @Override
    public @NonNull String specify(GenericTypeDescription description) {
        return description.getTypeName();
    }
}
