package org.java2dart.ast.generate;

import spoon.reflect.reference.CtTypeReference;

public class TypeInformationTransformer {

    protected CtTypeReference<?> typeRef;

    public TypeInformationTransformer(CtTypeReference<?> typeRef) {
        this.typeRef = typeRef;
    }

    public String getTypeName() {
        if (isArray()) {
            return "List<" + transformTypeName() + ">";
        }

        return transformTypeName();
    }

    private boolean isArray() {
        return typeRef.isArray();
    }

    private String baseTypeName() {
        final var simpleName = typeRef.getSimpleName();

        if (typeRef.isArray()) {
            final var lastIndex = simpleName.indexOf("[]");
            return simpleName.substring(0, lastIndex);


        }

        return simpleName;
    }


    private String transformTypeName() {
        return baseTypeName();
    }


}
