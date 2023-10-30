package org.java2dart.expression.dart.op;

import org.jspecify.annotations.NonNull;
import spoon.reflect.code.BinaryOperatorKind;

public final class DartBinaryOperator {

    public @NonNull String source(BinaryOperatorKind kind) {
        switch (kind) {

            case OR -> {
                return "||";
            }
            case AND -> {
                return "&&";
            }
            case BITOR -> {
                return "|";
            }
            case BITXOR -> {
                return "^";
            }
            case BITAND -> {
                return "&";
            }
            case EQ -> {
                return "==";
            }
            case NE -> {
                return "!=";

            }
            case LT -> {
                return "<";
            }
            case GT -> {
                return ">";
            }
            case LE -> {
                return "<=";
            }
            case GE -> {
                return ">=";
            }
            case SL -> {
                return "<<";
            }
            case SR -> {
                return ">>";
            }
            case USR -> {
                return ">>>";
            }
            case PLUS -> {
                return "+";
            }
            case MINUS -> {
                return "-";
            }
            case MUL -> {
                return "*";
            }
            case DIV -> {
                return "/";
            }
            case MOD -> {
                return "%";
            }
            case INSTANCEOF -> {
                throw new RuntimeException("INSTANCEOF not supported jet");
            }
        }

        throw new RuntimeException("None");
    }

}

