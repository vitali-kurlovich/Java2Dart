package org.java2dart.expression.builder;


import spoon.reflect.code.*;

public interface IExpressionBuilder {

    void assertBlock(CtAssert<?> asserted);

    void thisAccess();

    void superAccess();

    void invocation(CtInvocation<?> invocation);

    void returnStatement(CtReturn<?> returnStatement);


    void assignment(CtAssignment<?, ?> assignment);

   void operatorAssignment(CtOperatorAssignment<?, ?> assignment);

    void binaryOperator(CtBinaryOperator<?> operator);

    void unaryOperator(CtUnaryOperator<?> operator);

    void literal(CtLiteral<?> literal);

    void fieldRead(CtFieldRead<?> fieldRead);

    void fieldWrite(CtFieldWrite<?> fieldWrite);

    void localVariable(CtLocalVariable<?> localVariable);

    void variableRead(CtVariableRead<?> variableRead);

    void variableWrite(CtVariableWrite<?> variableWrite);

    void newArray(CtNewArray<?> newArray);

    void arrayRead(CtArrayRead<?> arrayRead);

    void arrayWrite(CtArrayWrite<?> arrayWrite);

    void conditional(CtConditional<?> conditional);

    void typeAccess(CtTypeAccess<?> typeAccess);

    void block(CtBlock<?> block);
    void ifBlock(CtIf ifElement);

   void switchBlock(CtSwitch<?> switchStatement);
    void caseBlock(  CtCase<?> caseStatement);

    void breakBlock(CtBreak breakStatement);

    void forLoop(CtFor forLoop);

    void append(IExpressionBuilder builder);

    String toString();
}
