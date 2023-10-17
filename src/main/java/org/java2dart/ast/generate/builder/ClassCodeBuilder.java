package org.java2dart.ast.generate.builder;

import org.java2dart.ast.generate.builder.base.BaseTypeCodeBuilder;
import org.java2dart.ast.generate.toplevel.AbstrcationType;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ClassCodeBuilder extends BaseTypeCodeBuilder {

    //  private final Builder[] methodsBuilders;
    private final CtClass classType;
    //private ArrayList<MethodBuilder> methods = new ArrayList<MethodBuilder>();
    private ArrayList<FieldCodeBuilder> fields = new ArrayList<FieldCodeBuilder>();


    public ClassCodeBuilder(CtClass classType) {
        super(classType);
        this.classType = classType;
    }

    public boolean isExtended() {
        return classType.getSuperclass() != null;
    }

    public Set<CtMethod<?>> methods() {
        return  classType.getMethods();
    }

    public List<CtField<?>> fields() {
        return classType.getFields();
    }


    @Override
    public String build() {

        clean();
        appendModifiers();
        append(AbstrcationType.CLASS);
        appendName();


        beginBlock();
        newline();
        // TODO: Fields & Methods

        final var fields = fields();
        for (final var field :
                fields) {
            final var builder = new FieldCodeBuilder(field);
            append(builder);
        }

        final var methods = methods();

        for (final var method: methods) {
            final var builder = new MethodBuilder(method);
            append(builder);
            newline();
        }


        endBlock();

        return super.build();
    }


}
