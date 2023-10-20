package org.java2dart.synthesize.definition.dart;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.synthesize.scheme.BaseObjectSchemeSpecifier;
import org.java2dart.synthesize.definition.BaseSchemeDefinitionSpecifier;
import org.jspecify.annotations.NonNull;

public class DartSchemeDefinitionSpecifier extends BaseSchemeDefinitionSpecifier {
    public DartSchemeDefinitionSpecifier(BaseObjectSchemeSpecifier typeParameterSpecifier) {
        super( typeParameterSpecifier);
    }

    @Override
    public @NonNull String specify(IObjectScheme scheme) {

        final var builder = new StringBuilder();

        switch (scheme.getSpecification().getTypeKing()) {
            case ENUM -> {
                builder.append("enum ");
            }
            case CLASS -> {
                builder.append("class ");
            }
            case INTERFACE -> {
                builder.append("interface ");
            }
            default -> {}
        }

        builder.append( schemeSpecifier.specify(scheme));


        return builder.toString();
    }

}
