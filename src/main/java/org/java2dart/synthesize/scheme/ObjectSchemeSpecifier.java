package org.java2dart.synthesize.scheme;

import org.java2dart.schema.IObjectScheme;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;


public interface ObjectSchemeSpecifier {
    //TypeParameter
    @NonNull String specify(IObjectScheme parameter);
}

