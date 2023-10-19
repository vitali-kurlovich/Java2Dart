package org.java2dart.syntaxis;

import org.java2dart.types.array.ArrayTypeDescription;
import org.java2dart.types.generic.GenericTypeDescription;
import org.java2dart.types.none.VoidTypeDescription;
import org.java2dart.types.object.ObjectTypeDescription;
import org.java2dart.types.object.parameterized.ParameterizedTypeDescription;
import org.java2dart.types.primitive.PrimitiveTypeDescription;
import org.jspecify.annotations.NonNull;

public interface TypeSpecifier {
//
    public @NonNull String specify(VoidTypeDescription description);
   public @NonNull String specify(PrimitiveTypeDescription description);
    public @NonNull String specify(ObjectTypeDescription description);

    public @NonNull String specify(ParameterizedTypeDescription description);
    public @NonNull String specify(ArrayTypeDescription description);
    public @NonNull String specify(GenericTypeDescription description);
}
