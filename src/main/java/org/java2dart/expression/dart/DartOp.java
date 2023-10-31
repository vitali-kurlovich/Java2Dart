package org.java2dart.expression.dart;

import org.java2dart.expression.dart.op.DartOperator;
import org.java2dart.expression.dart.op.DartLiteral;
import org.java2dart.expression.dart.op.DartLocalVariable;
import org.java2dart.expression.dart.op.DartTypeAccess;
import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.jspecify.annotations.NonNull;

public final class DartOp {
    public final DartOperator operator = new DartOperator();
    public final DartLiteral literal = new DartLiteral();
    public final DartLocalVariable localVariable;
    public  final DartTypeAccess typeAccess;

    public DartOp(@NonNull DartDefinitionFactory factory) {
        localVariable = new DartLocalVariable(factory);
        typeAccess = new DartTypeAccess(factory);
    }
}
