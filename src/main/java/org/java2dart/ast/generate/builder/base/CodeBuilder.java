package org.java2dart.ast.generate.builder.base;

import org.java2dart.ast.generate.toplevel.AbstrcationType;
import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.modifier.TypeModifier;

public interface CodeBuilder extends Builder {
    void clean();

    void whitespace();

    void endline();

    void newline();

    void append(String exp);

    void append(Builder builder);

    void beginBlock();

    void endBlock();

    void append(AccesLevel level);

    void append(TypeModifier modifier);

    void append(AbstrcationType type);


}
