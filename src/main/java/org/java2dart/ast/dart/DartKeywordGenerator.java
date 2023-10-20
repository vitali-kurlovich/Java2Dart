package org.java2dart.ast.dart;


import org.java2dart.ast.generate.toplevel.AbstrcationType;
import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.ast.generate.KeywordGenerator;
import org.java2dart.schema.modifier.TypeModifier;
import org.jspecify.annotations.NonNull;

public class DartKeywordGenerator implements KeywordGenerator {


    @Override
    @NonNull
    public String accesLevelKeyword(AccesLevel level) {
        switch (level) {
            case PUBLIC -> {
                return "public";
            }
            case PROTECTED -> {
                return "protected";
            }
            case PRIVATE -> {
                return "private";
            }
        }


        return null;
    }

    @Override
    @NonNull
    public String typeModifier(TypeModifier modifier) {
        switch (modifier) {
            case ABSTRACT -> {
                return "abstract";
            }
            case FINAL -> {
                return "final";
            }
            case STATIC -> {
                return "static";
            }
        }
        return null;
    }

    @Override
    public String abstrcationType(AbstrcationType type) {
        switch (type) {
            case CLASS -> {
                return "class";
            }
            case INTERFACE -> {
                return "interface";
            }
            case ENUM -> {
                return "enum";
            }
        }

        return null;
    }
}