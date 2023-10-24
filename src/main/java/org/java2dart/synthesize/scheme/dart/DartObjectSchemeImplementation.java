package org.java2dart.synthesize.scheme.dart;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.synthesize.impl.VaribleImplementation;
import org.java2dart.synthesize.impl.dart.DartVaribleImplementation;
import org.java2dart.synthesize.scheme.BaseObjectSchemeImplementation;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.scheme.ObjectSchemeSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public class DartObjectSchemeImplementation extends BaseObjectSchemeImplementation {

  private final VaribleImplementation varibleImplementation;

  private  final ObjectSchemeSpecifier objectSchemeSpecifier;

    public DartObjectSchemeImplementation(BaseTypeSpecifier typeSpecifier) {
        super(typeSpecifier);

      this.varibleImplementation = new DartVaribleImplementation(typeSpecifier);
      this.objectSchemeSpecifier = new DartObjectSchemeSpecifier(typeSpecifier);

    }

    @Override
    public @NonNull String implementation(IObjectScheme schema) {

        final var builder = new StringBuilder();
        builder.append(objectSchemeSpecifier.specify(schema));

        builder.append(" {\n");

        for (final var field: schema.getFields() ) {



          final var implVar =  varibleImplementation.varible(field.getModifiers(), field.getName(), field.getType());

            builder.append(implVar);
            builder.append(";\n");

        }

        builder.append("}");

        return builder.toString();
    }


}

