package org.java2dart.expression.dart.op;

import org.jspecify.annotations.NonNull;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.UnaryOperatorKind;

public final class DartOperator {

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

    public @NonNull String source(UnaryOperatorKind kind) {
        switch (kind) {

            case POS -> {
                return "+";
            }
            case NEG -> {
                return "-";
            }
            case NOT -> {
                return "!";
            }
            case COMPL -> {
                return "~";
            }
            case PREINC, POSTINC -> {
                return "++";
            }
            case PREDEC, POSTDEC -> {
                return "--";
            }
        }
        throw new RuntimeException("None");
    }

}

