package org.java2dart.expression.dart.op;

import org.jspecify.annotations.NonNull;
import spoon.reflect.code.CtLiteral;


public class DartLiteral {
    private static String escape(String s) {
        return s.replace("\\", "\\\\")
                .replace("\t", "\\t")
                .replace("\b", "\\b")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\f", "\\f")
                .replace("'", "\\'")
                .replace("\"", "\\\"");
    }

    public @NonNull String source(CtLiteral<?> literal) {

      final var base =  literal.getBase();

        if (literal.getValue() == null) {
            return "null";
        }

        if (literal.getValue() instanceof Integer) {
            final var value = (Integer) literal.getValue();
            return String.valueOf(value);
        }

        if (literal.getValue() instanceof Double) {
            final var value = (Double) literal.getValue();
            return String.valueOf(value);
        }

        if (literal.getValue() instanceof String) {
            final var value = (String) literal.getValue();
            return "\"" + escape(value) + "\"";
        }

        if (literal.getValue() instanceof Boolean) {
            final var value = (Boolean) literal.getValue();
            return value ? "true" : "false";
        }


        throw new RuntimeException("Unknown literal");
    }
}
