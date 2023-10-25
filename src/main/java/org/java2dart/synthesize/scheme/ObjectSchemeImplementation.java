package org.java2dart.synthesize.scheme;

import org.java2dart.schema.IObjectScheme;
import org.jspecify.annotations.NonNull;


public interface ObjectSchemeImplementation {
    @NonNull String implementation(IObjectScheme schema);
}
