package org.java2dart.synthesize.type;

import org.java2dart.types.TypeDescription;
import org.java2dart.types.array.ArrayTypeDescription;
import org.java2dart.types.generic.GenericTypeDescription;
import org.java2dart.types.none.VoidTypeDescription;
import org.java2dart.types.object.ObjectTypeDescription;
import org.java2dart.types.object.parameterized.ParameterizedTypeDescription;
import org.java2dart.types.primitive.PrimitiveTypeDescription;
import org.jspecify.annotations.NonNull;

public abstract class BaseTypeSpecifier implements TypeSpecifier {


    public @NonNull String specify(TypeDescription description) throws IllegalStateException {
        if (description instanceof VoidTypeDescription) {
            return specify((VoidTypeDescription) description);
        }

        if (description instanceof PrimitiveTypeDescription) {
            return specify((PrimitiveTypeDescription) description);
        }

        if (description instanceof ParameterizedTypeDescription) {
            return specify((ParameterizedTypeDescription) description);
        }

        if (description instanceof ObjectTypeDescription) {
            return specify((ObjectTypeDescription) description);
        }

        if (description instanceof ArrayTypeDescription) {
            return specify((ArrayTypeDescription) description);
        }


        if (description instanceof GenericTypeDescription) {
            return specify((GenericTypeDescription) description);
        }


        throw new IllegalStateException("Illegal TypeDescription");
    }


//    @Override
//    public @NonNull String specify(VoidTypeDescription description) {
//        return null;
//    }
//
//    @Override
//    public @NonNull String specify(PrimitiveTypeDescription description) {
//        return null;
//    }
//
//    @Override
//    public @NonNull String specify(ObjectTypeDescription description) {
//        return null;
//    }
//
//    @Override
//    public @NonNull String specify(ArrayTypeDescription description) {
//        return null;
//    }
//
//    @Override
//    public @NonNull String specify(GenericTypeDescription description) {
//        return null;
//    }
}
