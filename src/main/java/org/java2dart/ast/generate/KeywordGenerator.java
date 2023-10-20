package org.java2dart.ast.generate;

import org.java2dart.ast.generate.toplevel.AbstrcationType;
import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.modifier.TypeModifier;

public interface KeywordGenerator {

    String accesLevelKeyword(AccesLevel level);

    String typeModifier(TypeModifier modifier);

    String abstrcationType(AbstrcationType type);

}

