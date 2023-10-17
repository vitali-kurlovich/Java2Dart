package org.java2dart.ast.generate.builder;

import org.java2dart.ast.generate.builder.base.BaseCodeBuilder;
import spoon.reflect.code.*;


public class CodeBlockBuilder extends BaseCodeBuilder {
protected CtBlock<?> block;


    public CodeBlockBuilder(CtBlock<?> block) {
        this.block = block;
    }


    void buildBlock() {

      //  block.accept(new CodeVisitor(this));

        for (final var statement: block.getStatements()
             ) {
            statement.accept(new CodeVisitor(this));
        }

    }

    @Override
    public String build() {
        buildBlock();
        return super.build();
    }
}
