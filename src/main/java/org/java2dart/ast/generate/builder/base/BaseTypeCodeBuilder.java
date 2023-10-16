package org.java2dart.ast.generate.builder.base;

import org.java2dart.ast.generate.toplevel.AccesLevel;
import org.java2dart.ast.generate.toplevel.TypeModifier;
import spoon.reflect.declaration.CtModifiable;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtTypeInformation;

import java.util.ArrayList;
// CtTypeInformation
// CtNamedElement
public class BaseTypeCodeBuilder extends BaseCodeBuilder {

    protected final CtNamedElement element;
    protected final CtModifiable modifiable;

    public BaseTypeCodeBuilder(CtType<?> modifiable) {
        this(modifiable, modifiable);
    }

    public BaseTypeCodeBuilder(CtModifiable modifiable, CtNamedElement element) {
        this.modifiable = modifiable;
        this.element = element;
    }

    public void appendName() {
        append(name());
        whitespace();
    }

    public void appendTypeProperty() {
        append(accesLevel());

        final var modifiers = this.modifiers();
        for (final var modifier : modifiers) {
            append(modifier);
            // whitespace();
        }
    }

    public ArrayList<TypeModifier> modifiers() {
        final var modifiers = new ArrayList<TypeModifier>();

        if (isFinal()) {
            modifiers.add(TypeModifier.FINAL);
        }

        if (isStatic()) {
            modifiers.add(TypeModifier.STATIC);
        }

        if (isAbstract()) {
            modifiers.add(TypeModifier.ABSTRACT);
        }

        return modifiers;
    }


    public String name() {

        return  element.getSimpleName();
    }

    public AccesLevel accesLevel() {
        if (isPublic()) {
            return AccesLevel.PUBLIC;
        }

        if (isPrivate()) {
            return AccesLevel.PRIVATE;
        }

        if (isProtected()) {
            return AccesLevel.PROTECTED;
        }

        return AccesLevel.PROTECTED;
    }

    public boolean isPublic() {
        return modifiable.isPublic();
    }


    public boolean isFinal() {
        return modifiable.isFinal();
    }


    public boolean isStatic() {
        return modifiable.isStatic();
    }


    public boolean isProtected() {
        return modifiable.isProtected();
    }


    public boolean isPrivate() {
        return modifiable.isPrivate();
    }


    public boolean isAbstract() {
        return modifiable.isAbstract();
    }


    public boolean isTransient() {
        return modifiable.isTransient();
    }


    public boolean isVolatile() {
        return modifiable.isVolatile();
    }


    public boolean isSynchronized() {
        return modifiable.isSynchronized();
    }

    public boolean isNative() {
        return modifiable.isNative();
    }

    public boolean isStrictfp() {
        return modifiable.isStrictfp();
    }

}
