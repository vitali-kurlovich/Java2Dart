package org.java2dart.schema.modifier;


public  enum AccesLevel {
    PUBLIC, PROTECTED, PRIVATE, DEFAULT;

    public boolean isPublic() {
        return this == AccesLevel.PUBLIC;
    }

    public boolean isProtected() {
        return this == AccesLevel.PROTECTED;
    }

    public boolean isPrivate() {
        return this == AccesLevel.PRIVATE;
    }
}

