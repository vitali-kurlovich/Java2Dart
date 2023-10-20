package org.java2dart.factory.types;

import org.java2dart.types.TypeDescription;
import org.java2dart.types.array.ArrayTypeDescription;
import org.java2dart.types.generic.GenericClassTypeDescription;
import org.java2dart.types.generic.GenericInterfaceTypeDescription;
import org.java2dart.types.generic.GenericParameterTypeDescription;
import org.java2dart.types.generic.GenericTypeDescription;
import org.java2dart.types.none.VoidTypeDescription;
import org.java2dart.types.object.ClassTypeDescription;
import org.java2dart.types.object.EnumTypeDescription;
import org.java2dart.types.object.InterfaceTypeDescription;
import org.java2dart.types.object.parameterized.ParameterizedClassTypeDescription;
import org.java2dart.types.object.parameterized.ParameterizedInterfaceTypeDescription;
import org.java2dart.types.primitive.PrimitiveType;
import org.java2dart.types.primitive.PrimitiveTypeDescription;
import org.jspecify.annotations.NonNull;

import java.util.List;


public class TypeDescriptionFactory {

    public @NonNull VoidTypeDescription voidDescription() {
        return VoidTypeDescription.VOID;
    }

    public @NonNull PrimitiveTypeDescription primitiveDescription(String name) throws IllegalStateException {
        return PrimitiveTypeDescription.descriptionByName(name);
    }

    public @NonNull PrimitiveTypeDescription primitiveDescription(PrimitiveType type) {

        switch (type) {

            case BYTE -> {
                return byteDescription();
            }
            case SHORT -> {
                return shortDescription();
            }
            case INT -> {
                return intDescription();
            }
            case LONG -> {
                return longDescription();
            }
            case FLOAT -> {
                return floatDescription();
            }
            case DOUBLE -> {
                return doubleDescription();
            }
            case BOOLEAN -> {
                return booleanDescription();
            }
            case CHAR -> {
                return charDescription();
            }
        }
        return null;
    }

    public @NonNull ArrayTypeDescription arrayTypeDescription(TypeDescription description, boolean nullable) {
        assert (!description.isVoid());
        return new ArrayTypeDescription(description, nullable);
    }

    public @NonNull PrimitiveTypeDescription booleanDescription() {
        return PrimitiveTypeDescription.BOOLEAN;
    }

    public @NonNull PrimitiveTypeDescription byteDescription() {
        return PrimitiveTypeDescription.BYTE;
    }

    public @NonNull PrimitiveTypeDescription shortDescription() {
        return PrimitiveTypeDescription.SHORT;
    }

    public @NonNull PrimitiveTypeDescription intDescription() {
        return PrimitiveTypeDescription.INT;
    }

    public @NonNull PrimitiveTypeDescription longDescription() {
        return PrimitiveTypeDescription.LONG;
    }

    public @NonNull PrimitiveTypeDescription floatDescription() {
        return PrimitiveTypeDescription.FLOAT;
    }

    public @NonNull PrimitiveTypeDescription doubleDescription() {
        return PrimitiveTypeDescription.DOUBLE;
    }

    public @NonNull PrimitiveTypeDescription charDescription() {
        return PrimitiveTypeDescription.CHAR;
    }

    public @NonNull ClassTypeDescription classDescription(@NonNull String name, @NonNull boolean nullable) {
        return new ClassTypeDescription(name, nullable);
    }

    public @NonNull ParameterizedClassTypeDescription parameterizedClassDescription(@NonNull String name,
                                                                                    @NonNull List<TypeDescription> typeArguments,
                                                                                    @NonNull boolean nullable) {

        return new ParameterizedClassTypeDescription(name, typeArguments, nullable);
    }


    public @NonNull InterfaceTypeDescription interfaceDescription(@NonNull String name, @NonNull boolean nullable) {
        return new InterfaceTypeDescription(name, nullable);
    }

    public @NonNull ParameterizedInterfaceTypeDescription parameterizedInterfaceDescription(@NonNull String name,
                                                                                            @NonNull List<TypeDescription> typeArguments,
                                                                                            @NonNull boolean nullable) {

        return new ParameterizedInterfaceTypeDescription(name, typeArguments, nullable);
    }

    public @NonNull EnumTypeDescription enumDescription(@NonNull String name, @NonNull boolean nullable) {
        return new EnumTypeDescription(name, nullable);
    }

    public @NonNull GenericTypeDescription genericClassDescription(@NonNull String name) {
        return new GenericClassTypeDescription(name);
    }

    public @NonNull GenericTypeDescription genericInterfaceDescription(@NonNull String name) {
        return new GenericInterfaceTypeDescription(name);
    }

    public @NonNull GenericTypeDescription genericParameterDescription(@NonNull String name) {
        return new GenericParameterTypeDescription(name);
    }
}
