package org.java2dart.expression.builder;



public interface IExpressionBuilder {

    void thisAccess();
    void superAccess();


//    void read(IVariable variable);
//    void read(Field field);

    void append(IExpressionBuilder builder);

    String toString();
}
