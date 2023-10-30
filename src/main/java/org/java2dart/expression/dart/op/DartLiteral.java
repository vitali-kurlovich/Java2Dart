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

        if (literal.getValue() == null) {
            return "null";
        }

        if (literal.getValue() instanceof Integer) {
            final Integer value = (Integer) literal.getValue();
            return String.valueOf(value);
        }

        if (literal.getValue() instanceof String) {
            final String value = (String) literal.getValue();
            return "\"" + escape(value) + "\"";
        }

        throw new RuntimeException("Unknown literal");
    }
}
