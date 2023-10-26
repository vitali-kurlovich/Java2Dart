package org.java2dart.expression.builder;


import org.java2dart.schema.field.Field;
import org.java2dart.schema.varible.IVariable;

public interface IExpressionBuilder {

    void thisAccess();
    void superAccess();


    void read(IVariable variable);
    void read(Field field);

    String toString();
}
