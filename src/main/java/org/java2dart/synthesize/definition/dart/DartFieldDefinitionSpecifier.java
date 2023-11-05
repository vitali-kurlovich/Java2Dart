package org.java2dart.synthesize.definition.dart;

import org.java2dart.synthesize.definition.varible.FieldDefinitionSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtField;

public class DartFieldDefinitionSpecifier implements FieldDefinitionSpecifier {

    private final @NonNull DartModifiersDefinitionSpecifier modifiersSpecifier;

    private final @NonNull DartTypeReferenceSpecifier typeReferenceSpecifier;

    public DartFieldDefinitionSpecifier(@NonNull DartModifiersDefinitionSpecifier modifiersSpecifier,
                                        @NonNull DartTypeReferenceSpecifier typeReferenceSpecifier) {
        this.modifiersSpecifier = modifiersSpecifier;
        this.typeReferenceSpecifier = typeReferenceSpecifier;

    }

    @Override
    public @NonNull String specify(CtField<?> field) {
        String builder = modifiersSpecifier.specify(field) +
                " " +
                typeReferenceSpecifier.specify(field.getType()) +
                " " +
                field.getSimpleName();

        return builder.trim();
    }
}
