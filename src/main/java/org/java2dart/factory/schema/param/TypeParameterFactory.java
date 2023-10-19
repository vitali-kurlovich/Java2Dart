package org.java2dart.factory.schema.param;

import org.java2dart.schema.TypeParameter;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class TypeParameterFactory {

public @NonNull TypeParameter typeParameter(@NonNull TypeDescription typeDescription, @Nullable List<TypeDescription> interfaces) {
    return new TypeParameter(typeDescription, interfaces);
}

    public @NonNull TypeParameter typeParameter(@NonNull TypeDescription typeDescription) {
        return new TypeParameter(typeDescription);
    }

}
