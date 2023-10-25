package org.java2dart.synthesize.definition.scheme;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.schema.method.IMethod;
import org.jspecify.annotations.NonNull;


public interface SchemeDefinitionSpecifier {

    @NonNull String specify(IObjectScheme scheme);

}
