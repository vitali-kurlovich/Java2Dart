package org.java2dart.synthesize.impl.dart;

import org.java2dart.expression.dart.DartExpressionBuilder;
import org.java2dart.expression.dart.DartExpressionVisitor;
import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.statemnts.VisitableImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.visitor.CtVisitable;

public class DartVisitableImplementation implements VisitableImplementation {

    private final @NonNull DartDefinitionFactory factory;

    public DartVisitableImplementation(@NonNull DartDefinitionFactory factory) {
        this.factory = factory;
    }

    @Override
    public @NonNull String source(CtVisitable visitable) {
        final var builder = new DartExpressionBuilder(factory);

        final var visitor = new DartExpressionVisitor(builder);
        visitable.accept(visitor);

        return builder.toString().trim();
    }
}
