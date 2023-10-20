package org.java2dart.synthesize.type;

import org.java2dart.types.array.ArrayTypeDescription;
import org.java2dart.types.generic.GenericTypeDescription;
import org.java2dart.types.none.VoidTypeDescription;
import org.java2dart.types.object.ObjectTypeDescription;
import org.java2dart.types.object.parameterized.ParameterizedTypeDescription;
import org.java2dart.types.primitive.PrimitiveTypeDescription;
import org.jspecify.annotations.NonNull;


public interface TypeSpecifier {
    //
    @NonNull String specify(VoidTypeDescription description);

    @NonNull String specify(PrimitiveTypeDescription description);

    @NonNull String specify(ObjectTypeDescription description);

    @NonNull String specify(ParameterizedTypeDescription description);

    @NonNull String specify(ArrayTypeDescription description);

    @NonNull String specify(GenericTypeDescription description);
}
