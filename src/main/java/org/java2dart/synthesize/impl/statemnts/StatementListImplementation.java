package org.java2dart.synthesize.impl.statemnts;

import org.jspecify.annotations.NonNull;
import spoon.reflect.code.CtStatementList;

public interface StatementListImplementation {
    @NonNull String source(CtStatementList statements);
}
