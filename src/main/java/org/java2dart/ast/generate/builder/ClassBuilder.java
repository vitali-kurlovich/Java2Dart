package org.java2dart.ast.generate.builder;

import org.java2dart.ast.dart.DartKeywordGenerator;
import org.java2dart.ast.generate.KeywordGenerator;
import org.java2dart.ast.generate.toplevel.AbstrcationType;
import org.java2dart.ast.generate.toplevel.AccesLevel;
import org.java2dart.ast.generate.toplevel.TypeModifier;

import java.util.ArrayList;

public class ClassBuilder implements Builder {

    private ArrayList<MethodBuilder> methods = new ArrayList<MethodBuilder>();
    private  ArrayList<FieldBuilder> fields = new ArrayList<FieldBuilder>();
  //  private final Builder[] methodsBuilders;
    private final String className;
    private final KeywordGenerator generator = new DartKeywordGenerator();
    private AccesLevel accesLevel = AccesLevel.PROTECTED ;

    private  boolean isFinal;
    private  boolean isAbstract;
    private  boolean isStatic;

    final StringBuilder builder = new StringBuilder();

    public ClassBuilder( String className) {
        // this.methodsBuilders = methodsBuilders;
        this.className = className;
    }

    String getClassName() {
        return  className;
    }

    public void setAccesLevel( AccesLevel level) {
        accesLevel  = level;
    }
    public void setFinal( boolean flag) {
        isFinal = flag;
    }

    public  void  setAbstract( boolean flag) {
        isAbstract = flag;
    }

    public  void  setStatic( boolean flag) {
        isStatic = flag;
    }

    public  void append(MethodBuilder builder) {
        methods.add(builder);
    }

    @Override
    public String build() {
        builder.setLength(0);

        append(generator.accesLevelKeyword(accesLevel));

        if (isStatic) {
            append(generator.typeModifier(TypeModifier.STATIC));
        }

        if (isAbstract) {
            append(generator.typeModifier(TypeModifier.ABSTRACT));
        }

        if (isFinal) {
            append(generator.typeModifier(TypeModifier.FINAL));
        }

        append(generator.abstrcationType(AbstrcationType.CLASS));

        append(className);

        append("{\n");
// TODO: implementation;

        for (final var field: fields ) {
            final var string = field.build();
            if (string != null) {
                append(string);
            }
        }

        for (final var method: methods ) {
            final var string = method.build();
            if (string != null) {
                append(string);
            }
        }

        append("}");
       // builder.append()

        return builder.toString();
    }

    private void append(String str) {
        builder.append(str);
        builder.append(" ");
    }
}
