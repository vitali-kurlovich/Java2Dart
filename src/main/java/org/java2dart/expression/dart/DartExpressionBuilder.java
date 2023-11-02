package org.java2dart.expression.dart;


import org.java2dart.expression.builder.IExpressionBuilder;
import org.java2dart.logging.Logging;
import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.jspecify.annotations.NonNull;
import spoon.reflect.code.*;

import java.util.List;

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

    @Override
    public void operatorAssignment(CtOperatorAssignment<?, ?> assignment) {
        assignment.getAssigned().accept(visitor);

        final var operator = op.operator.source(assignment.getKind());
        builder.append(" ")
                .append(operator)
                .append("= ");

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
        //builder.append(".");

        final var name = fieldRead.getVariable().getSimpleName();
        builder.append(name);
    }

    public void fieldWrite(CtFieldWrite<?> fieldWrite) {
        fieldWrite.getTarget().accept(visitor);
        //builder.append(".");
        //  thisAccess();
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
        final var name = variableWrite.getVariable().getSimpleName();
        builder.append(name);
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

        builder.append(op.typeAccess.source(typeAccess));
        builder.append(".");
    }


    @Override
    public void block(CtBlock<?> block) {
        builder.append(" {\n");
        statements(block.getStatements());
        builder.append("} ");
    }

    @Override
    public void ifBlock(CtIf ifElement) {
        builder.append("if (");
        ifElement.getCondition().accept(visitor);
        builder.append(")");
        ifElement.getThenStatement().accept(visitor);

        final var elseStatement = ifElement.getElseStatement();
        if (elseStatement != null) {
            builder.append("else");
            elseStatement.accept(visitor);
        }
    }

    @Override
    public void switchBlock(CtSwitch<?> switchStatement) {
        builder.append("switch (");
        switchStatement.getSelector().accept(visitor);
        builder.append(") ");
        builder.append("{\n");

        for (final var caseItem : switchStatement.getCases()) {
            caseItem.accept(visitor);
        }

        builder.append("}");
    }

    @Override
    public void caseBlock(CtCase<?> caseStatement) {

        final var caseExpressions = caseStatement.getCaseExpressions();

        if (caseExpressions != null && !caseExpressions.isEmpty()) {
            builder.append("case ");

            var needsComma = false;
            for (final var expr : caseExpressions) {
                if (needsComma) {
                    builder.append(", ");
                }
                expr.accept(visitor);
                needsComma = true;
            }
        } else {
            builder.append("default");
        }

        builder.append(": ");
        statements(caseStatement.getStatements());
    }

    @Override
    public void breakBlock(CtBreak breakStatement) {

        builder.append("break");
    }

    @Override
    public void forLoop(CtFor forLoop) {
        builder.append("for ( ");
        statements(forLoop.getForInit());
        forLoop.getExpression().accept(visitor);
        builder.append("; ");
        statements(forLoop.getForUpdate());
        builder.append(" ) ");
        forLoop.getBody().accept(visitor);
    }


    public void append(IExpressionBuilder builder) {
        this.builder.append(builder.toString());
    }

    public String toString() {
        return builder.toString();
    }

    private void statements(List<CtStatement> statements) {
        for (final var statement : statements) {
            statement.accept(visitor);

            final var source = builder.toString().trim();

            if (!source.endsWith("}") && !source.endsWith(";")) {
                builder.append(";");
            }

            builder.append("\n");
        }
    }
}
