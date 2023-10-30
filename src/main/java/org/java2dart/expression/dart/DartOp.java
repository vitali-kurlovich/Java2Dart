package org.java2dart.expression.dart;

import org.java2dart.expression.dart.op.DartBinaryOperator;
import org.java2dart.expression.dart.op.DartLiteral;
import org.java2dart.expression.dart.op.DartLocalVariable;
import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.jspecify.annotations.NonNull;

public class DartOp {
    public final DartBinaryOperator binOp = new DartBinaryOperator();
    public final DartLiteral literal = new DartLiteral();
    public final DartLocalVariable localVariable;

    public DartOp(@NonNull DartDefinitionFactory factory) {
        localVariable = new DartLocalVariable(factory);
    }
}
