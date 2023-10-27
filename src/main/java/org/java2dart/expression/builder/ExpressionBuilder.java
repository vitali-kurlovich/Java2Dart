package org.java2dart.expression.builder;

import org.java2dart.schema.field.Field;
import org.java2dart.schema.varible.IVariable;

public class ExpressionBuilder implements IExpressionBuilder {

    private final StringBuilder builder = new StringBuilder();

    public  void thisAccess() {
        builder.append("this");
    }

    public void superAccess() {
        builder.append("super");
    }

    public void read(IVariable variable) {
     final var name =  variable.getName();

        builder.append(name);

    }

    public void read(Field field) {
        final var name =  field.getName();


        builder.append(".").append(name);
    }



    public void append(IExpressionBuilder builder) {
        this.builder.append(builder.toString());
    }


    public  String toString() {
      return   builder.toString();
    }



}
