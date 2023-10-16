package org.java2dart.ast.generate.builder;

import org.java2dart.ast.generate.builder.base.BaseTypeCodeBuilder;
import org.java2dart.ast.generate.toplevel.AbstrcationType;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;

import java.util.ArrayList;
import java.util.List;


public class ClassBuilder extends BaseTypeCodeBuilder {

    //private ArrayList<MethodBuilder> methods = new ArrayList<MethodBuilder>();
    private  ArrayList<FieldCodeBuilder> fields = new ArrayList<FieldCodeBuilder>();
    //  private final Builder[] methodsBuilders;
    private final CtClass classType;


    public ClassBuilder(CtClass classType) {
        super(classType);

        this.classType = classType;
    }

    public boolean isExtended() {



        return classType.getSuperclass() != null;
    }

    public  List<CtField<?>> fields() {
        return  classType.getFields();
    }



    @Override
    public String build() {

        //classType.getSuperclass().getSimpleName()


        clean();
        appendTypeProperty();
        append(AbstrcationType.CLASS);
        appendName();


        beginBlock();
        newline();
        // TODO: Fields & Methods

        final var fields = fields();
        for (final var field:
             fields) {
           final var builder = new FieldCodeBuilder(field);

           final var exp = builder.build();
           append(exp);
        }



        endBlock();

        return super.build();
    }


}
