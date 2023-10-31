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

    @Override
    public void assertBlock(CtAssert<?> asserted) {
        builder.append("assert( ");
        asserted.getAssertExpression().accept(visitor);
        builder.append(" )");
    }

    public void thisAccess() {
        builder.append("this.");
    }

    public void superAccess() {
        builder.append("super.");
    }

    @Override
    public void invocation(CtInvocation<?> invocation) {

        invocation.getTarget().accept(visitor);
        builder.append(".");
        final var executable = invocation.getExecutable();
        final var name = executable.getSimpleName();
        builder.append(name);

        final var arguments = invocation.getArguments();
        var needsComma = false;
        builder.append("(");
        for (final var arg : arguments) {
            if (needsComma) {
                builder.append(", ");
            }
            arg.accept(visitor);
            needsComma = true;
        }
        builder.append(")");
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
        operator.getLeftHandOperand().accept(visitor);

        final var kind = operator.getKind();
        builder.append(" ")
                .append(op.operator.source(kind))
                .append(" ");

        operator.getRightHandOperand().accept(visitor);
    }

    @Override
    public void unaryOperator(CtUnaryOperator<?> operator) {
        final var kind = operator.getKind();
        if (kind == UnaryOperatorKind.POSTDEC || kind == UnaryOperatorKind.POSTINC) {
            operator.getOperand().accept(visitor);
            builder.append(op.operator.source(kind));
        } else {
            builder.append(op.operator.source(kind));
            operator.getOperand().accept(visitor);
        }
    }

    @Override
    public void literal(CtLiteral<?> literal) {
        builder.append(op.literal.source(literal));
    }

    public void fieldRead(CtFieldRead<?> fieldRead) {
        fieldRead.getTarget().accept(visitor);
        builder.append(".");
        // thisAccess();
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

    @Override
    public void arrayRead(CtArrayRead<?> arrayRead) {
        arrayRead.getTarget().accept(visitor);
        builder.append("[");
        arrayRead.getIndexExpression().accept(visitor);
        builder.append("]");
    }

    @Override
    public void arrayWrite(CtArrayWrite<?> arrayWrite) {
        arrayWrite.getTarget().accept(visitor);
        builder.append("[");
        arrayWrite.getIndexExpression().accept(visitor);
        builder.append("]");
    }

    @Override
    public void conditional(CtConditional<?> conditional) {
        conditional.getCondition().accept(visitor);
        builder.append(" ? ");
        conditional.getThenExpression().accept(visitor);
        builder.append(" : ");
        conditional.getElseExpression().accept(visitor);
    }

    @Override
    public void typeAccess(CtTypeAccess<?> typeAccess) {
        // Logging.warning("Do not implemented - visitCtTypeAccess");

        builder.append(op.typeAccess.source(typeAccess));


        // typeAccess.getAccessedType()

    }

    public void append(IExpressionBuilder builder) {
        this.builder.append(builder.toString());
    }


    public String toString() {
        return builder.toString();
    }


}
