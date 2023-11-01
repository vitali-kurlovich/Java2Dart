package org.java2dart.synthesize.impl.dart;

import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.field.FieldImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtField;

public final class DartFieldImplementation implements FieldImplementation {
   private final @NonNull DartDefinitionFactory factory;
    private final  @NonNull DartVisitableImplementation statementImpl;

    public DartFieldImplementation(@NonNull DartDefinitionFactory factory) {
        this.factory = factory;
        statementImpl = new DartVisitableImplementation(factory);
    }

    @Override
    public @NonNull String source(CtField<?> field) {

        final var builder = new StringBuilder();

        final var fieldDefinition = factory.fieldDefinitionSpecifier();

        builder.append(fieldDefinition.specify(field));

      final var expr =  field.getDefaultExpression();

      if (expr != null) {
        final var source =  statementImpl.source(expr);
          builder.append(" = ");
          builder.append(source);
      }

        return builder.toString();
    }
}
