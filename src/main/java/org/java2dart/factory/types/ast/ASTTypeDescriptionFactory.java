package org.java2dart.factory.types.ast;

import org.java2dart.factory.types.TypeDescriptionFactory;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ASTTypeDescriptionFactory extends TypeDescriptionFactory {
    public @Nullable TypeDescription description(CtTypeReference<?> ctTypeReference) throws IllegalStateException {

        if (ctTypeReference.isArray()) {
            return arrayDescription(ctTypeReference);
        }

        final var simpleName = ctTypeReference.getSimpleName();

        if (ctTypeReference.isPrimitive()) {
            if (Objects.equals(simpleName, "void")) {
                return voidDescription();
            }
            return primitiveDescription(simpleName);
        }

        if (ctTypeReference.isClass()) {
            if (ctTypeReference.isParameterized()) {
                final var args = ctTypeReference.getActualTypeArguments();
                final var descriptions = descriptions(args);
                return parameterizedClassDescription(simpleName, descriptions, true);
            }
            return classDescription(simpleName, true);
        }

        if (ctTypeReference.isInterface()) {
            if (ctTypeReference.isParameterized()) {
                final var args = ctTypeReference.getActualTypeArguments();
                return parameterizedInterfaceDescription(simpleName, descriptions(args), true);
            }
            return interfaceDescription(simpleName, true);
        }

        if (ctTypeReference.isEnum()) {
            return enumDescription(simpleName, true);
        }

        if (ctTypeReference.isGenerics()) {
            if (ctTypeReference.isClass()) {
                return genericClassDescription(simpleName);
            }

            if (ctTypeReference.isInterface()) {
                return genericInterfaceDescription(simpleName);
            }

            if (ctTypeReference.isParentInitialized()) {
                return genericParameterDescription(simpleName);
            }
        }

        throw new RuntimeException();
    }


  private   TypeDescription arrayDescription(CtTypeReference<?> ctTypeReference) {
        assert (ctTypeReference.isArray());

        if (ctTypeReference instanceof CtArrayTypeReference<?> arrayTypeReference) {
            final var componentTypeReference = arrayTypeReference.getComponentType();

            final var component = description(componentTypeReference);

            return arrayTypeDescription(component, true);
        }

        throw new IllegalStateException("Can't resolve array type");

    }


    private @NonNull List<TypeDescription> descriptions(List<CtTypeReference<?>> ctTypeReferences) throws IllegalStateException {
        final var descriptions = new ArrayList<TypeDescription>();

        for (final var ref : ctTypeReferences) {
            final var dsc = description(ref);
            descriptions.add(dsc);
        }

        return descriptions;
    }

}
