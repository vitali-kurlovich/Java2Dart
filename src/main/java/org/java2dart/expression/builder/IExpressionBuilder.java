package org.java2dart.expression.builder;


import spoon.reflect.code.*;

public interface IExpressionBuilder {

    void thisAccess();

    void superAccess();

    void assignment(CtAssignment<?, ?> assignment);

    void binaryOperator(CtBinaryOperator<?> operator);

    void literal(CtLiteral<?> literal);

    void fieldRead(CtFieldRead<?> fieldRead);

    void fieldWrite(CtFieldWrite<?> fieldWrite);

    void localVariable(CtLocalVariable<?> localVariable);

    void variableRead(CtVariableRead<?> variableRead);

    void variableWrite(CtVariableWrite<?> variableWrite);

//    void read(IVariable variable);
//    void read(Field field);

    void append(IExpressionBuilder builder);

    String toString();
}
