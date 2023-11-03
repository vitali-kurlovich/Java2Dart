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
        builder.variableWrite(variableWrite);


        //  variableWrite.
    }

    @Override
    public <T> void visitCtNewArray(CtNewArray<T> newArray) {
        builder.newArray(newArray);
    }


    @Override
    public <T> void visitCtArrayRead(CtArrayRead<T> arrayRead) {
        builder.arrayRead(arrayRead);
    }

    @Override
    public <T> void visitCtArrayWrite(CtArrayWrite<T> arrayWrite) {
        builder.arrayWrite(arrayWrite);
    }

    @Override
    public <T> void visitCtTypeAccess(CtTypeAccess<T> typeAccess) {
        builder.typeAccess(typeAccess);
    }


    @Override
    public <T> void visitCtAssert(CtAssert<T> asserted) {
        builder.assertBlock(asserted);
    }


    @Override
    public <T> void visitCtBinaryOperator(CtBinaryOperator<T> operator) {
        builder.binaryOperator(operator);
    }


    @Override
    public <T> void visitCtConditional(CtConditional<T> conditional) {
        builder.conditional(conditional);
    }

    @Override
    public <R> void visitCtBlock(CtBlock<R> block) {
        builder.block(block);
    }


    @Override
    public <T> void visitCtInvocation(CtInvocation<T> invocation) {
        builder.invocation(invocation);
    }

    @Override
    public void visitCtBreak(CtBreak breakStatement) {
        builder.breakBlock(breakStatement);
    }


    @Override
    public void visitCtContinue(CtContinue continueStatement) {
        builder.continueBlock(continueStatement);
    }

    @Override
    public void visitCtFor(CtFor forLoop) {

        builder.forLoop(forLoop);
    }

    @Override
    public void visitCtForEach(CtForEach foreach) {
        builder.forEach(foreach);
    }


    @Override
    public void visitCtWhile(CtWhile whileLoop) {
        Logging.warning("Do not implemented - visitCtWhile");
    }


    @Override
    public void visitCtDo(CtDo doLoop) {
        Logging.warning("Do not implemented - visitCtDo");
    }


    @Override
    public void visitCtIf(CtIf ifElement) {
        builder.ifBlock(ifElement);
    }


    @Override
    public <S> void visitCtSwitch(CtSwitch<S> switchStatement) {
        builder.switchBlock(switchStatement);
    }

    @Override
    public <T, S> void visitCtSwitchExpression(CtSwitchExpression<T, S> switchExpression) {
        Logging.warning("Do not implemented - visitCtSwitchExpression");
    }

    @Override
    public <S> void visitCtCase(CtCase<S> caseStatement) {
        builder.caseBlock(caseStatement);

    }

    @Override
    public void visitCtCatch(CtCatch catchBlock) {
        Logging.warning("Do not implemented - visitCtCatch");
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
        builder.operatorAssignment(assignment);
    }

    @Override
    public <T> void visitCtUnaryOperator(CtUnaryOperator<T> operator) {
        builder.unaryOperator(operator);
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
    public void visitCtYieldStatement(CtYieldStatement statement) {
        Logging.warning("Do not implemented - visitCtYieldStatement");
    }

    @Override
    public void visitCtTypePattern(CtTypePattern pattern) {
        Logging.warning("Do not implemented - visitCtTypePattern");
    }

    @Override
    public void visitCtRecord(CtRecord recordType) {
        Logging.warning("Do not implemented - visitCtRecord");
    }

    @Override
    public void visitCtRecordComponent(CtRecordComponent recordComponent) {
        Logging.warning("Do not implemented - visitCtRecordComponent");
    }
}
