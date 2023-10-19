package org.java2dart.synthesize.definition;

import org.java2dart.schema.ClassSchema;
import org.java2dart.schema.IObjectScheme;
import org.jspecify.annotations.NonNull;


public interface SchemeDefinitionSpecifier {

    @NonNull String specify(IObjectScheme scheme);

}
