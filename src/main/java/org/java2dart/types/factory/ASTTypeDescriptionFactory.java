package org.java2dart.types.factory;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.Nullable;
import spoon.reflect.reference.CtTypeReference;

public class ASTTypeDescriptionFactory extends TypeDescriptionFactory {

   public @Nullable TypeDescription description(CtTypeReference<?> ctTypeReference) throws IllegalStateException {

      if ( ctTypeReference.isPrimitive() ) {
         final var simpleName = ctTypeReference.getSimpleName();

         if (simpleName == "void") {
             return voidDescription();
         }

         return primitiveDescription(simpleName);
      }

      if (ctTypeReference.isClass() ) {
         final var annatations = ctTypeReference.getAnnotations();

          final var simpleName = ctTypeReference.getSimpleName();

          return classDescription(simpleName, true);
      }


       return null;
   }

}
