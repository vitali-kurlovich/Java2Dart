package org.java2dart.synthesize.type.dart;

import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.HashMap;
import java.util.Map;


public final class DartTypeSpecifier  implements TypeSpecifier {

    @Override
    public @NonNull String specify(CtTypeReference<?> typeReference) {
        final var simpleName = typeReference.getSimpleName();
        if (typeReference.isPrimitive()) {
           final var type = primitiveTypeMap.get(simpleName);
            return specify(type);
        }

        if (typeReference.isArray()) {
            final var arrayReference = (CtArrayTypeReference<?>) typeReference;
            final var base = arrayReference.getArrayType();
            final var dimension = arrayReference.getDimensionCount();
            return specifyArray(base, dimension);
        }

        if (typeReference.isParameterized()) {
            var needsSeparator = false;

           final var builder = new  StringBuilder(simpleName);
            builder.append("<");
            for (final var arg: typeReference.getActualTypeArguments()) {
                if (needsSeparator) {
                    builder.append(", ");
                }
                builder.append( specify(arg) );
                needsSeparator = true;
            }

            builder.append(">");
           return builder.toString();
        }

        return simpleName;
    }


    private @NonNull String specifyArray(CtTypeReference<?> elementTypeRef, int dimension) {
        final var type = specify(elementTypeRef);
        return specifyArray(type, dimension);
    }

    private @NonNull String specifyArray( @NonNull String elementType, int dimension) {
        if (dimension == 0) {
            return  elementType;
        }

        return "List<" + specifyArray( elementType, dimension - 1 ) + ">";
    }

    private @NonNull String specify(PrimitiveType primitiveType) {

        switch (primitiveType) {
            case BYTE, INT, SHORT, LONG -> {
                return "int";
            }
            case FLOAT, CHAR -> {
                return "float";
            }
            case DOUBLE -> {
                return "double";
            }
            case BOOLEAN -> {
                return "bool";
            }
        }

        return "void";
    }

    private final static Map<String, PrimitiveType> primitiveTypeMap = initializeMap();

    private static Map<String, PrimitiveType> initializeMap() {

        final var map = new HashMap<String, PrimitiveType>();
        map.put("byte", PrimitiveType.BYTE);
        map.put("short", PrimitiveType.SHORT);
        map.put("int", PrimitiveType.INT);
        map.put("long", PrimitiveType.LONG);
        map.put("float", PrimitiveType.FLOAT);
        map.put("double", PrimitiveType.DOUBLE);
        map.put("boolean", PrimitiveType.BOOLEAN);
        map.put("char", PrimitiveType.CHAR);
        map.put("void", PrimitiveType.VOID);
        return map;
    }

    public enum PrimitiveType {
        BYTE,
        SHORT,
        INT,
        LONG,
        FLOAT,
        DOUBLE,
        BOOLEAN,
        CHAR,
        VOID
    }


}
