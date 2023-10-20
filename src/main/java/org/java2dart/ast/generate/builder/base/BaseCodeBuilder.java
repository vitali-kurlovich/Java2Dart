package org.java2dart.ast.generate.builder.base;

import org.java2dart.ast.dart.DartKeywordGenerator;
import org.java2dart.ast.generate.KeywordGenerator;
import org.java2dart.ast.generate.toplevel.AbstrcationType;
import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.modifier.TypeModifier;


public  class BaseCodeBuilder implements CodeBuilder {
    final StringBuilder builder = new StringBuilder();

    final KeywordGenerator keywordGenerator = new DartKeywordGenerator();

    @Override
    public void clean() {
        builder.setLength(0);
    }

    @Override
    public void append( String exp ) {
        builder.append(exp);
    }

    @Override
    public  void append(Builder builder) {
        final var exp = builder.build();

        if (exp != null) {
            append(exp);
        }
    }

    @Override
    public void whitespace() {
        append(" ");
    }

    @Override
    public void endline() {
        append(";");
    }


    @Override
    public void newline() {
        append("\n");
    }

    @Override
    public void beginBlock() {
        append("{");
    }

    @Override
    public void endBlock() {
        append("}");

    }

    @Override
    public void append(AccesLevel level) {
       final var exp = keywordGenerator.accesLevelKeyword(level);
        append(exp);
        whitespace();
    }

    @Override
    public void append(TypeModifier modifier) {
        final var exp = keywordGenerator.typeModifier(modifier);
        append(exp);
        whitespace();
    }

    @Override
    public void append(AbstrcationType type) {
        final var exp = keywordGenerator.abstrcationType(type);
        append(exp);
        whitespace();
    }

    @Override
    public String build() {
        return builder.toString();
    }
}
