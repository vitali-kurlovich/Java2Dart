package org.java2dart.synthesize.scheme;

import org.java2dart.schema.ClassSchema;
import org.java2dart.schema.TypeParameter;
import org.java2dart.types.none.VoidTypeDescription;
import org.jspecify.annotations.NonNull;


public interface SchemeSpecifier {

    @NonNull String specify(ClassSchema scheme);

}
