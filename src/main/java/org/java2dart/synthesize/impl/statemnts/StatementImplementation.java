package org.java2dart.synthesize.impl.statemnts;

import org.jspecify.annotations.NonNull;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtStatementList;

public interface StatementImplementation {
    @NonNull String source(CtStatement statement);

}
