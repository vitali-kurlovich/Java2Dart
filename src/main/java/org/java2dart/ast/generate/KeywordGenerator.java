package org.java2dart.ast.generate;

import org.java2dart.ast.generate.toplevel.AbstrcationType;
import org.java2dart.ast.generate.toplevel.AccesLevel;
import org.java2dart.ast.generate.toplevel.TypeModifier;

public interface KeywordGenerator {

    String accesLevelKeyword(AccesLevel level);

    String typeModifier(TypeModifier modifier);

    String abstrcationType(AbstrcationType type);

}

