package org.java2dart.factory.schema.ast;

import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.factory.variable.ASTVariableFactory;
import org.java2dart.schema.field.Field;
import spoon.reflect.declaration.CtField;

import java.util.ArrayList;
import java.util.List;

public class ASTSchemaFieldFactory extends ASTVariableFactory {
    public ASTSchemaFieldFactory(ASTTypeDescriptionFactory typeDescriptionFactory) {
        super(typeDescriptionFactory);
    }

    public List<Field> fields(List<CtField<?>> ctFields) {
        final var fields = new ArrayList<Field>();
        for (final var ref : ctFields) {
            fields.add(field(ref));
        }
        return fields;
    }

    public Field field(CtField<?> ctField) {
        return new Field(variable(ctField), ctField.getModifiers());
    }


}
