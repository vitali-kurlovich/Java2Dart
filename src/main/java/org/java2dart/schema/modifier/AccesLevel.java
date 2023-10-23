package org.java2dart.schema.modifier;


public enum AccesLevel {
    PUBLIC, PROTECTED, PRIVATE, DEFAULT;


    public boolean isPublic() {
        return this == AccesLevel.PUBLIC;
    }

}

