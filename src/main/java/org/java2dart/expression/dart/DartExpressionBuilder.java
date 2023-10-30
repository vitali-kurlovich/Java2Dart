package org.java2dart.expression.dart;


import org.java2dart.expression.builder.IExpressionBuilder;
import org.java2dart.logging.Logging;
import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.jspecify.annotations.NonNull;
import spoon.reflect.code.*;

public final class DartExpressionBuilder implements IExpressionBuilder {
    private final StringBuilder builder = new StringBuilder();
    private final DartExpressionVisitor visitor = new DartExpressionVisitor(this);
    private final @NonNull DartOp op;

    public DartExpressionBuilder(@NonNull DartDefinitionFactory factory) {
        op = new DartOp(factory);
    }

    public void thisAccess() {
        builder.append("this.");
    }

    public void superAccess() {
        builder.append("super.");
    }

    @Override
    public void invocation(CtInvocation<?> invocation) {
        Logging.warning("Do not implemented - visitCtInvocation");

    //    invocation.

    }

    @Override
    public void returnStatement(CtReturn<?> returnStatement) {
        builder.append("return");
        final var expr = returnStatement.getReturnedExpression();
        if (expr != null) {
            builder.append(" ");
            expr.accept(visitor);
        }
    }

    @Override
    public void assignment(CtAssignment<?, ?> assignment) {
        assignment.getAssigned().accept(visitor);
        builder.append(" = ");
        assignment.getAssignment().accept(visitor);
    }

    public void binaryOperator(CtBinaryOperator<?> operator) {

        // builder.append("(");
        operator.getLeftHandOperand().accept(visitor);

        final var kind = operator.getKind();
        builder.append(" ")
                .append(op.binOp.source(kind))
                .append(" ");

        operator.getRightHandOperand().accept(visitor);
        //builder.append(")");

    }

    @Override
    public void literal(CtLiteral<?> literal) {
        builder.append(op.literal.source(literal));
    }

    public void fieldRead(CtFieldRead<?> fieldRead) {
        thisAccess();
        final var name = fieldRead.getVariable().getSimpleName();
        builder.append(name);
    }

    public void fieldWrite(CtFieldWrite<?> fieldWrite) {
        thisAccess();
        final var name = fieldWrite.getVariable().getSimpleName();
        builder.append(name);
    }

    @Override
    public void localVariable(CtLocalVariable<?> localVariable) {
        final var source = op.localVariable.source(localVariable);
        builder.append(source);

        final var expr = localVariable.getDefaultExpression();
        if (expr != null) {
            builder.append(" = ");
            expr.accept(visitor);
        }
    }

    @Override
    public void variableRead(CtVariableRead<?> variableRead) {
        final var name = variableRead.getVariable().getSimpleName();

        builder.append(name);

    }

    @Override
    public void variableWrite(CtVariableWrite<?> variableWrite) {
        //final var name = variableWrite.getVariable().getSimpleName();
        Logging.warning("Do not implemented - variableWrite");
    }

    @Override
    public void newArray(CtNewArray<?> newArray) {
        builder.append("[");
        final var elements = newArray.getElements();

        var needsComma = false;
        for (final var el : elements) {
            if (needsComma) {
                builder.append(",");
            }
            el.accept(visitor);
            needsComma = true;
        }
        builder.append("]");
    }


    public void append(IExpressionBuilder builder) {
        this.builder.append(builder.toString());
    }


    public String toString() {
        return builder.toString();
    }


}
