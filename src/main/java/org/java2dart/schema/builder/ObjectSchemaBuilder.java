package org.java2dart.schema.builder;

import org.java2dart.schema.*;
import org.java2dart.schema.modifier.Modifible;
import org.java2dart.schema.varible.Field;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.lang.reflect.Array;
import java.util.*;

public class ObjectSchemaBuilder {
    private  HashSet<ModifierKind> modifiers = new HashSet<ModifierKind>();
    private  NamedTypeDescription specification;
    private  @Nullable NamedTypeDescription superClass;
    private  HashSet<NamedTypeDescription> interfaces = new HashSet<NamedTypeDescription>();
    private  @Nullable ArrayList<TypeParameter> formalParameters = new ArrayList<TypeParameter>();

    private ArrayList<Field> fields = new ArrayList<Field>();

// CtTypeReference<T>
    public void setSpecification(@NonNull NamedTypeDescription specification) {
        assert (specification != null);
        this.specification = specification;
    }

    public void setSuperClass(@Nullable NamedTypeDescription superClass) {
        this.superClass = superClass;
    }

    public void append(ModifierKind modifierKind) {
        this.modifiers.add(modifierKind);
    }

    public void setModifiers( Set<ModifierKind> modifiers) {
        this.modifiers = new HashSet<ModifierKind>();
        this.modifiers.addAll(modifiers);
    }

    public void appendFormalParameter(TypeParameter parameter) {
        this.formalParameters.add(parameter);
    }

    public void setFormalParameters(List<TypeParameter> formalParameters ) {
        this.formalParameters = new ArrayList<TypeParameter>();
        for (final var param:formalParameters) {
            appendFormalParameter(param);
        }
    }

    public void appendInterface( @NonNull NamedTypeDescription supportedInterface) {
        assert (supportedInterface != null);
        this.interfaces.add(supportedInterface);
    }

    public void setInterfaces( @Nullable Set<NamedTypeDescription> interfaces) {

        this.interfaces = new HashSet<NamedTypeDescription>();
        for (final var i: interfaces) {
            appendInterface(i);
        }
    }

    public void appendField(  Field field) {
        assert (field != null);
        fields.add(field);

    }

    public void setFields( @Nullable List<Field> fields) {
        this.fields = new ArrayList<Field>();
        for (final var f: fields) appendField(f);
    }



   public IObjectScheme build() throws IllegalStateException{
        if (specification == null) {
            throw new RuntimeException("specification not set");
        }

        switch (specification.getTypeKing()) {

            case ENUM -> {
            }
            case CLASS -> {
                return new ClassSchema(modifiers, specification, formalParameters, superClass,  interfaces, fields);
            }
            case INTERFACE -> {
                return new InterfaceSchema(modifiers, specification, formalParameters, superClass,  interfaces,  fields);
            }

            case GENERIC ->   {
                return new GenericSchema(modifiers, specification, formalParameters, superClass,  interfaces, fields);
            }

            case PRIMITIVE -> {
                throw new IllegalStateException("Scheme can't be specify for primitive types");

            }
            case NONE -> {
                throw new IllegalStateException("Scheme can't be specify for void types");
            }
        }

       throw new RuntimeException("Implementation faild");

    }


}
