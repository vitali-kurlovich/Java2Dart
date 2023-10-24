package org.java2dart.factory.schema.ast;

import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.schema.varible.Field;
import spoon.reflect.declaration.CtField;

import java.util.ArrayList;
import java.util.List;

public class ASTSchemaFieldFactory {
    private final ASTTypeDescriptionFactory typeDescriptionFactory;

    public ASTSchemaFieldFactory(ASTTypeDescriptionFactory typeDescriptionFactory) {
        this.typeDescriptionFactory = typeDescriptionFactory;
    }

    public List<Field> fields(List<CtField<?>> ctFields) {
        final var fields = new ArrayList<Field>();

        for (final var ref : ctFields) {
            fields.add(field(ref));
        }

        return fields;

    }


    public Field field(CtField<?> ctField) {
        final var name = ctField.getSimpleName();
        final var type = typeDescriptionFactory.description(ctField.getType());
        final var modifiers = ctField.getModifiers();

        return new Field(name, type, modifiers);
    }


}
