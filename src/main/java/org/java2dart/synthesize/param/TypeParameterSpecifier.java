package org.java2dart.synthesize.param;

import org.java2dart.schema.TypeParameter;
import org.jspecify.annotations.NonNull;


public interface TypeParameterSpecifier {
    //TypeParameter
    @NonNull String specify(TypeParameter parameter);
}
