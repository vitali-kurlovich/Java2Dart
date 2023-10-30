package org.java2dart.expression.dart;

import org.java2dart.expression.BaseExpressionVisitor;
import org.java2dart.expression.builder.IExpressionBuilder;
import org.java2dart.logging.Logging;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.*;


public class DartExpressionVisitor extends BaseExpressionVisitor {

    public DartExpressionVisitor(IExpressionBuilder buider) {
        super(buider);
    }

    @Override
    public <T> void visitCtThisAccess(CtThisAccess<T> thisAccess) {
        builder.thisAccess();
    }

    @Override
    public <T> void visitCtSuperAccess(CtSuperAccess<T> f) {
        builder.superAccess();
    }

    @Override
    public <R> void visitCtReturn(CtReturn<R> returnStatement) {
        builder.returnStatement(returnStatement);
    }

    @Override
    public <T> void visitCtFieldRead(CtFieldRead<T> fieldRead) {
        builder.fieldRead(fieldRead);
    }

    @Override
    public <T> void visitCtFieldWrite(CtFieldWrite<T> fieldWrite) {
        builder.fieldWrite(fieldWrite);
    }


    @Override
    public <T, A extends T> void visitCtAssignment(CtAssignment<T, A> assignement) {
        //  Logging.info("visitCtAssignment");
        builder.assignment(assignement);
    }

    @Override
    public <T> void visitCtLiteral(CtLiteral<T> literal) {
        builder.literal(literal);
    }

    @Override
    public <T> void visitCtLocalVariable(CtLocalVariable<T> localVariable) {
        builder.localVariable(localVariable);
    }

    @Override
    public <T> void visitCtVariableRead(CtVariableRead<T> variableRead) {
        builder.variableRead(variableRead);
    }

    @Override
    public <T> void visitCtVariableWrite(CtVariableWrite<T> variableWrite) {
        final var name = variableWrite.getVariable().getSimpleName();

        Logging.debug("visitCtVariableWrite: " + name);

        //  variableWrite.
    }

    @Override
    public <T> void visitCtNewArray(CtNewArray<T> newArray) {
        builder.newArray(newArray);
    }


    @Override
    public <T> void visitCtArrayRead(CtArrayRead<T> arrayRead) {
        Logging.warning("Do not implemented - visitCtArrayRead");
    }

    @Override
    public <T> void visitCtArrayWrite(CtArrayWrite<T> arrayWrite) {
        Logging.warning("Do not implemented - visitCtArrayWrite");

    }


    @Override
    public <T> void visitCtAssert(CtAssert<T> asserted) {
        Logging.warning("Do not implemented - visitCtAssert");
    }


    @Override
    public <T> void visitCtBinaryOperator(CtBinaryOperator<T> operator) {
        builder.binaryOperator(operator);
    }

    @Override
    public <R> void visitCtBlock(CtBlock<R> block) {
        Logging.warning("Do not implemented - visitCtBlock");
    }

    @Override
    public void visitCtBreak(CtBreak breakStatement) {
        Logging.warning("Do not implemented - visitCtBreak");
    }

    @Override
    public <S> void visitCtCase(CtCase<S> caseStatement) {
        Logging.warning("Do not implemented - visitCtCase");

    }

    @Override
    public void visitCtCatch(CtCatch catchBlock) {
        Logging.warning("Do not implemented - visitCtCatch");
    }


    @Override
    public <T> void visitCtConditional(CtConditional<T> conditional) {
        Logging.warning("Do not implemented - visitCtConditional");
    }

    @Override
    public void visitCtContinue(CtContinue continueStatement) {
        Logging.warning("Do not implemented - visitCtContinue");
    }

    @Override
    public void visitCtDo(CtDo doLoop) {
        Logging.warning("Do not implemented - visitCtDo");
    }


    @Override
    public void visitCtFor(CtFor forLoop) {
        Logging.warning("Do not implemented - visitCtFor");
    }

    @Override
    public void visitCtForEach(CtForEach foreach) {
        Logging.warning("Do not implemented - visitCtForEach");
    }

    @Override
    public void visitCtIf(CtIf ifElement) {
        Logging.warning("Do not implemented - visitCtIf");
    }


    @Override
    public <T> void visitCtInvocation(CtInvocation<T> invocation) {

        builder.invocation(invocation);
    }

    @Override
    public void visitCtTextBlock(CtTextBlock ctTextBlock) {
        Logging.warning("Do not implemented - visitCtTextBlock");
    }


    @Override
    public <T> void visitCtCatchVariable(CtCatchVariable<T> catchVariable) {
        Logging.warning("Do not implemented - visitCtCatchVariable");
    }

    @Override
    public <T> void visitCtCatchVariableReference(CtCatchVariableReference<T> reference) {
        Logging.warning("Do not implemented - visitCtCatchVariableReference");
    }



    @Override
    public <T> void visitCtConstructorCall(CtConstructorCall<T> ctConstructorCall) {
        Logging.warning("Do not implemented - visitCtConstructorCall");
    }

    @Override
    public <T> void visitCtNewClass(CtNewClass<T> newClass) {
        Logging.warning("Do not implemented - visitCtNewClass");
    }

    @Override
    public <T> void visitCtLambda(CtLambda<T> lambda) {
        Logging.warning("Do not implemented - visitCtLambda");
    }

    @Override
    public <T, E extends CtExpression<?>> void visitCtExecutableReferenceExpression(CtExecutableReferenceExpression<T, E> expression) {
        Logging.warning("Do not implemented - visitCtExecutableReferenceExpression");
    }

    @Override
    public <T, A extends T> void visitCtOperatorAssignment(CtOperatorAssignment<T, A> assignment) {
        Logging.warning("Do not implemented - visitCtOperatorAssignment");
    }


    @Override
    public <S> void visitCtSwitch(CtSwitch<S> switchStatement) {
        Logging.warning("Do not implemented - switchStatement");
    }

    @Override
    public <T, S> void visitCtSwitchExpression(CtSwitchExpression<T, S> switchExpression) {
        Logging.warning("Do not implemented - visitCtSwitchExpression");
    }

    @Override
    public void visitCtSynchronized(CtSynchronized synchro) {
        Logging.warning("Do not implemented - visitCtSynchronized");
    }

    @Override
    public void visitCtThrow(CtThrow throwStatement) {
        Logging.warning("Do not implemented - visitCtThrow");
    }

    @Override
    public void visitCtTry(CtTry tryBlock) {
        Logging.warning("Do not implemented - visitCtTry");
    }

    @Override
    public void visitCtTryWithResource(CtTryWithResource tryWithResource) {
        Logging.warning("Do not implemented - visitCtTryWithResource");
    }


    @Override
    public <T> void visitCtTypeAccess(CtTypeAccess<T> typeAccess) {
        Logging.warning("Do not implemented - visitCtTypeAccess");
    }

    @Override
    public <T> void visitCtUnaryOperator(CtUnaryOperator<T> operator) {
        Logging.warning("Do not implemented - visitCtUnaryOperator");

    }


    @Override
    public void visitCtWhile(CtWhile whileLoop) {
        Logging.warning("Do not implemented - visitCtWhile");
    }



    @Override
    public void visitCtYieldStatement(CtYieldStatement statement) {

    }

    @Override
    public void visitCtTypePattern(CtTypePattern pattern) {

    }

    @Override
    public void visitCtRecord(CtRecord recordType) {

    }

    @Override
    public void visitCtRecordComponent(CtRecordComponent recordComponent) {

    }
}
