package org.java2dart.ast.generate.builder.base;

import org.java2dart.ast.generate.builder.base.Builder;
import org.java2dart.ast.generate.toplevel.AbstrcationType;
import org.java2dart.ast.generate.toplevel.AccesLevel;
import org.java2dart.ast.generate.toplevel.TypeModifier;

public interface CodeBuilder extends Builder {
    void clean();
    void whitespace();
    void endline();
    void  newline();

    void append( String exp );

    void beginBlock();
    void endBlock();

    void append(AccesLevel level);
    void append(TypeModifier modifier);
    void append(AbstrcationType type);



}
