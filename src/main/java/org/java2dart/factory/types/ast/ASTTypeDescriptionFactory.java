package org.java2dart.factory.types.ast;

import org.java2dart.factory.types.TypeDescriptionFactory;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class ASTTypeDescriptionFactory extends TypeDescriptionFactory {

    public @Nullable TypeDescription description(CtTypeReference<?> ctTypeReference) throws IllegalStateException {

        if (ctTypeReference.isArray()) {
            if (ctTypeReference instanceof CtArrayTypeReference<?>) {
                final var arrayTypeReference = (CtArrayTypeReference<?>) ctTypeReference;
                final var componentTypeReference = arrayTypeReference.getComponentType();

                final var component = description(componentTypeReference);

                return arrayTypeDescription(component, true);
            } else {
                throw new IllegalStateException("Can't resolve array type");
            }
        }


        if (ctTypeReference.isPrimitive()) {
            final var simpleName = ctTypeReference.getSimpleName();

            if (simpleName == "void") {
                return voidDescription();
            }

            return primitiveDescription(simpleName);
        }


        final var simpleName = ctTypeReference.getSimpleName();

        if (ctTypeReference.isClass()) {

            if (ctTypeReference.isParameterized()) {
                final var args = ctTypeReference.getActualTypeArguments();

                return parameterizedClassDescription(simpleName, descriptions(args), true);
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


            return genericDescription(simpleName);

            //  System.out.println("Generic");

        }

        return null;
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
