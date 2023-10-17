package org.java2dart.ast.generate.builder.base;

import org.java2dart.ast.generate.TypeInformationTransformer;
import spoon.reflect.declaration.CtTypeInformation;


public class TypeInformationCodeBuilder extends BaseCodeBuilder {
    protected final CtTypeInformation information;

    public TypeInformationCodeBuilder(CtTypeInformation information) {
        this.information = information;
    }

    @Override
    public String build() {


        append(getSimpleName());
        whitespace();
        return super.build();
    }


    public String getSimpleName() {
        var ref = information.getTypeErasure();
        final var transformer = new TypeInformationTransformer(ref);
        return transformer.getTypeName();
    }

    public boolean isPrimitive() {
        return information.isPrimitive();
    }

    public boolean isAnonymous() {
        return information.isAnonymous();
    }

    public boolean isLocalType() {
        return information.isLocalType();
    }

    public boolean isClass() {
        return information.isClass();
    }

    public boolean isInterface() {
        return information.isInterface();
    }

    public boolean isEnum() {
        return information.isEnum();
    }

    public boolean isAnnotationType() {
        return information.isAnnotationType();
    }

    public boolean isGenerics() {
        return information.isGenerics();
    }


    public boolean isParameterized() {
        return information.isParameterized();
    }


}
