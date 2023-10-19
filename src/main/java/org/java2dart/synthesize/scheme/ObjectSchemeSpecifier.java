package org.java2dart.synthesize.scheme;

import org.java2dart.schema.IObjectScheme;
import org.jspecify.annotations.NonNull;


public interface ObjectSchemeSpecifier {
    //TypeParameter
    @NonNull String specify(IObjectScheme parameter);
}
