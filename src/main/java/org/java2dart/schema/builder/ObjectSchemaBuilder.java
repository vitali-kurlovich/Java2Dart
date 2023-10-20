package org.java2dart.schema.builder;

import org.java2dart.schema.ClassSchema;
import org.java2dart.schema.IObjectScheme;
import org.java2dart.schema.TypeParameter;
import org.java2dart.schema.modifier.Modifible;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObjectSchemaBuilder {
    private  HashSet<Modifible.ModifierKind> modifiers = new HashSet<Modifible.ModifierKind>();
    private  NamedTypeDescription specification;
    private  @Nullable NamedTypeDescription superClass;
    private  HashSet<NamedTypeDescription> interfaces = new HashSet<NamedTypeDescription>();
    private  @Nullable ArrayList<TypeParameter> formalParameters = new ArrayList<TypeParameter>();

// CtTypeReference<T>
    public void setSpecification(@NonNull NamedTypeDescription specification) {
        assert (specification != null);
        this.specification = specification;
    }

    public void setSuperClass(@Nullable NamedTypeDescription superClass) {
        this.superClass = superClass;
    }

    public void append(Modifible.ModifierKind modifierKind) {
        this.modifiers.add(modifierKind);
    }

    public void setModifiers( Set<Modifible.ModifierKind> modifiers) {
        this.modifiers = new HashSet<Modifible.ModifierKind>();
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

   public IObjectScheme build() {
        if (specification == null) {
            throw new RuntimeException("specification not set");
        }

        return new ClassSchema(modifiers, specification, formalParameters, superClass,  interfaces);
    }


}
