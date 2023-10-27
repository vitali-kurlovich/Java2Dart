package org.java2dart.expression;

import org.java2dart.expression.builder.ExpressionBuilder;
import org.java2dart.expression.builder.IExpressionBuilder;

public class ExpressionBuilderFactory {

  public   IExpressionBuilder builder() {
        return new ExpressionBuilder();
    }

}
