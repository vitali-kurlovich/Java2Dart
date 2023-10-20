package org.java2dart.factory.schema;

import org.java2dart.schema.ClassSchema;
import org.java2dart.schema.IObjectScheme;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class SchemaFactory {
    public @NonNull ClassSchema classSchema(NamedTypeDescription specification,
                                            @Nullable NamedTypeDescription superClass,
                                            @Nullable Set<NamedTypeDescription> interfaces) {
        return new ClassSchema(specification, superClass, null, interfaces);
    }

    public @NonNull ClassSchema classSchema(NamedTypeDescription specification,
                                            @Nullable NamedTypeDescription superClass,
                                            @Nullable List<IObjectScheme> formalParameters,
                                            @Nullable Set<NamedTypeDescription> interfaces) {
        return new ClassSchema(specification, superClass, formalParameters, interfaces);
    }
}
