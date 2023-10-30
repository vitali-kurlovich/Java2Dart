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
    public <T> void visitCtArrayRead(CtArrayRead<T> arrayRead) {

    }

    @Override
    public <T> void visitCtArrayWrite(CtArrayWrite<T> arrayWrite) {

    }


    @Override
    public <T> void visitCtAssert(CtAssert<T> asserted) {

    }


    @Override
    public <T> void visitCtBinaryOperator(CtBinaryOperator<T> operator) {
        builder.binaryOperator(operator);
    }

    @Override
    public <R> void visitCtBlock(CtBlock<R> block) {

    }

    @Override
    public void visitCtBreak(CtBreak breakStatement) {

    }

    @Override
    public <S> void visitCtCase(CtCase<S> caseStatement) {

    }

    @Override
    public void visitCtCatch(CtCatch catchBlock) {

    }


    @Override
    public <T> void visitCtConditional(CtConditional<T> conditional) {

    }

    @Override
    public void visitCtContinue(CtContinue continueStatement) {

    }

    @Override
    public void visitCtDo(CtDo doLoop) {

    }


    @Override
    public <T> void visitCtEnumValue(CtEnumValue<T> enumValue) {

    }


    @Override
    public void visitCtFor(CtFor forLoop) {

    }

    @Override
    public void visitCtForEach(CtForEach foreach) {

    }

    @Override
    public void visitCtIf(CtIf ifElement) {

    }


    @Override
    public <T> void visitCtInvocation(CtInvocation<T> invocation) {

    }

    @Override
    public void visitCtTextBlock(CtTextBlock ctTextBlock) {

    }


    @Override
    public <T> void visitCtCatchVariable(CtCatchVariable<T> catchVariable) {

    }

    @Override
    public <T> void visitCtCatchVariableReference(CtCatchVariableReference<T> reference) {

    }


    @Override
    public <T> void visitCtNewArray(CtNewArray<T> newArray) {

    }

    @Override
    public <T> void visitCtConstructorCall(CtConstructorCall<T> ctConstructorCall) {

    }

    @Override
    public <T> void visitCtNewClass(CtNewClass<T> newClass) {

    }

    @Override
    public <T> void visitCtLambda(CtLambda<T> lambda) {

    }

    @Override
    public <T, E extends CtExpression<?>> void visitCtExecutableReferenceExpression(CtExecutableReferenceExpression<T, E> expression) {

    }

    @Override
    public <T, A extends T> void visitCtOperatorAssignment(CtOperatorAssignment<T, A> assignment) {

    }


    @Override
    public <R> void visitCtReturn(CtReturn<R> returnStatement) {

    }


    @Override
    public <S> void visitCtSwitch(CtSwitch<S> switchStatement) {

    }

    @Override
    public <T, S> void visitCtSwitchExpression(CtSwitchExpression<T, S> switchExpression) {

    }

    @Override
    public void visitCtSynchronized(CtSynchronized synchro) {

    }

    @Override
    public void visitCtThrow(CtThrow throwStatement) {

    }

    @Override
    public void visitCtTry(CtTry tryBlock) {

    }

    @Override
    public void visitCtTryWithResource(CtTryWithResource tryWithResource) {

    }



    @Override
    public <T> void visitCtTypeAccess(CtTypeAccess<T> typeAccess) {

    }

    @Override
    public <T> void visitCtUnaryOperator(CtUnaryOperator<T> operator) {

    }



    @Override
    public void visitCtWhile(CtWhile whileLoop) {

    }


    @Override
    public void visitCtComment(CtComment comment) {

    }

    @Override
    public void visitCtJavaDoc(CtJavaDoc comment) {

    }

    @Override
    public void visitCtJavaDocTag(CtJavaDocTag docTag) {

    }


    @Override
    public void visitCtPackageDeclaration(CtPackageDeclaration packageDeclaration) {

    }

    @Override
    public void visitCtTypeMemberWildcardImportReference(CtTypeMemberWildcardImportReference wildcardReference) {

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


    private void print(String msg) {
        System.out.print(msg);
    }
}
