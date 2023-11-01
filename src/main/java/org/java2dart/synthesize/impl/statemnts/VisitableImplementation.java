package org.java2dart.synthesize.impl.statemnts;

import org.jspecify.annotations.NonNull;
import spoon.reflect.visitor.CtVisitable;

public interface VisitableImplementation {
    @NonNull String source(CtVisitable visitable);

}
