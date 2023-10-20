package org.java2dart.ast.generate.builder.base;

import org.java2dart.schema.modifier.AccesLevel;
import org.java2dart.schema.modifier.TypeModifier;
import spoon.reflect.declaration.CtModifiable;

import java.util.ArrayList;

public class ModifiableCodeBuilder extends BaseCodeBuilder {
    protected final CtModifiable modifiable;

    public ModifiableCodeBuilder(CtModifiable modifiable) {
        this.modifiable = modifiable;

    }

    @Override
    public String build() {
        appendModifiers();
        return super.build();
    }

    public void appendModifiers() {
        append(accesLevel());

        final var modifiers = this.modifiers();
        for (final var modifier : modifiers) {
            append(modifier);
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
