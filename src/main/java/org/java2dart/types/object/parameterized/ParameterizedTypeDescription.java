package org.java2dart.types.object.parameterized;

import org.java2dart.types.TypeDescription;
import org.java2dart.types.object.ObjectTypeDescription;
import org.jspecify.annotations.NonNull;

import java.util.List;


public abstract class ParameterizedTypeDescription extends ObjectTypeDescription {
    private List<TypeDescription> typeArguments;

    protected ParameterizedTypeDescription(@NonNull String typeName, @NonNull NonPrimitiveType type,
                                           List<TypeDescription> typeArguments,
                                           @NonNull boolean nullable) {
        super(typeName, type, nullable);

        assert (!typeArguments.isEmpty());
        this.typeArguments = typeArguments;
    }

    public List<TypeDescription> getTypeArguments() {
        return typeArguments;
    }


    @Override
    public String toString() {

        final var builder = new StringBuilder();
        for (final var arg : typeArguments) {
            builder.append(arg.toString());
        }

        return super.toString()
                + "typeArguments: [\n" +
                builder.toString()
                + "]\n";
    }
}
