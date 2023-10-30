package org.java2dart.expression.builder;


import spoon.reflect.code.*;

public interface IExpressionBuilder {

    void thisAccess();

    void superAccess();

    void invocation(CtInvocation<?> invocation);

    void returnStatement(CtReturn<?> returnStatement);


    void assignment(CtAssignment<?, ?> assignment);

    void binaryOperator(CtBinaryOperator<?> operator);

    void literal(CtLiteral<?> literal);

    void fieldRead(CtFieldRead<?> fieldRead);

    void fieldWrite(CtFieldWrite<?> fieldWrite);

    void localVariable(CtLocalVariable<?> localVariable);

    void variableRead(CtVariableRead<?> variableRead);

    void variableWrite(CtVariableWrite<?> variableWrite);


    void  newArray(CtNewArray<?> newArray);

    void append(IExpressionBuilder builder);

    String toString();
}
