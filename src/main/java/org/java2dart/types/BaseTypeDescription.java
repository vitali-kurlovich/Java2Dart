package org.java2dart.types;

import org.java2dart.types.TypeDescription;

public abstract class BaseTypeDescription implements TypeDescription {

    @Override
    public String toString() {
       final var builder = new StringBuilder();

        String className = this.getClass().getSimpleName();

        builder.append("<");
        builder.append(className);
        builder.append(">\n");

        builder.append("isNullable: ");
        builder.append(isNullable());
        builder.append("\n");

        builder.append("isPrimitive: ");
        builder.append(isPrimitive());
        builder.append("\n");

        builder.append("isArray: ");
        builder.append(isArray());
        builder.append("\n");

        builder.append("isGeneric: ");
        builder.append(isGeneric());
        builder.append("\n");

        return builder.toString();
    }
}
