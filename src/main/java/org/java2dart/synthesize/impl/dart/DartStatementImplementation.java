package org.java2dart.synthesize.impl.dart;

import org.java2dart.expression.dart.DartExpressionBuilder;
import org.java2dart.expression.dart.DartExpressionVisitor;
import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.statemnts.StatementImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.code.CtStatement;

public class DartStatementImplementation implements StatementImplementation {

    private final @NonNull DartDefinitionFactory factory;

    public DartStatementImplementation(@NonNull DartDefinitionFactory factory) {
        this.factory = factory;
    }

    @Override
    public @NonNull String source(CtStatement statement) {
        final var builder = new DartExpressionBuilder(factory);

       final var visitor = new DartExpressionVisitor(builder);

        statement.accept(visitor);


        return builder.toString();
    }
}
