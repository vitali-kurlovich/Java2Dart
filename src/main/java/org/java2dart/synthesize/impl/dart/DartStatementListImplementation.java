package org.java2dart.synthesize.impl.dart;

import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.statemnts.StatementListImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.code.CtStatementList;

public class DartStatementListImplementation implements StatementListImplementation {
    private final DartVisitableImplementation statementImpl;

    public DartStatementListImplementation(@NonNull DartDefinitionFactory factory) {
        statementImpl = new DartVisitableImplementation(factory);
    }

    @Override
    public @NonNull String source(CtStatementList statements) {
        final var builder = new StringBuilder();

       // final var source = statementImpl.source(statements);
       // builder.append(source);//.append(";\n");

        for (final var statement:statements.getStatements()) {
            final var source = statementImpl.source(statement).trim();
            builder.append(source).append(";\n");
        }
        return builder.toString().trim();
    }
}
