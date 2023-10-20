package org.java2dart.schema.builder.ast;

import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.schema.TypeParameter;
import org.java2dart.schema.builder.ObjectSchemaBuilder;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.CtTypeParameter;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ASTObjectSchemaBuilder extends ObjectSchemaBuilder {

    private final ASTTypeDescriptionFactory typeDescriptionFactory;

    public ASTObjectSchemaBuilder(ASTTypeDescriptionFactory typeDescriptionFactory) {
        this.typeDescriptionFactory = typeDescriptionFactory;
    }

    public void setSpecification(@NonNull CtTypeReference<?> specification) throws IllegalStateException {
        assert (specification != null);

        final var spec = description(specification);
        setSpecification(spec);
        //this.specification = specification;
    }

    public void setSuperClass(@Nullable CtTypeReference<?> superClass) {
        final var spec = description(superClass);
        setSuperClass(spec);
    }

    public void appendFormalParameter(CtTypeParameter ctTypeParameter) {
        assert (ctTypeParameter != null);
        appendFormalParameter(typeParameter(ctTypeParameter));
    }

    public void appendInterface(@NonNull CtTypeReference<?> supportedInterface) {
        assert (supportedInterface != null);
        appendInterface(description(supportedInterface));
    }

    private @NonNull TypeParameter typeParameter(@NonNull CtTypeParameter ctTypeParameter) {

        final var builder = new ASTObjectSchemaBuilder(typeDescriptionFactory);
        final var specRef = ctTypeParameter.getReference();

        builder.setSpecification(specRef);
        builder.setSuperClass(ctTypeParameter.getSuperclass());

        for (final var ref : specRef.getSuperInterfaces()) {
            builder.appendInterface(ref);
        }

        final var schema = builder.build();

        return new TypeParameter(schema);
    }


    private NamedTypeDescription description(@Nullable CtTypeReference<?> ctTypeReference) throws IllegalStateException {
        if (ctTypeReference == null) {
            return null;
        }
        return (NamedTypeDescription) typeDescriptionFactory.description(ctTypeReference);
    }

    private List<NamedTypeDescription> descriptions(@Nullable List<CtTypeReference<?>> ctTypeReferences) throws IllegalStateException {

        final var specs = new ArrayList<NamedTypeDescription>();

        for (final var ref : ctTypeReferences) {
            specs.add(description(ref));
        }

        return specs;
    }
}
