package org.java2dart.factory.schema.ast;

import org.java2dart.expression.ExpressionBuilderFactory;
import org.java2dart.expression.builder.ExpressionBuilder;
import org.java2dart.expression.ExpressionVisitor;
import org.java2dart.expression.builder.IExpressionBuilder;
import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.schema.method.Method;
import org.java2dart.schema.method.Parameter;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ASTSchemaMethodFactory {

    private final ASTTypeDescriptionFactory typeDescriptionFactory;
    private final ExpressionBuilderFactory expressionBuilderFactory;

    public ASTSchemaMethodFactory(ASTTypeDescriptionFactory typeDescriptionFactory,  ExpressionBuilderFactory expressionBuilderFactory) {
        this.typeDescriptionFactory = typeDescriptionFactory;
        this.expressionBuilderFactory = expressionBuilderFactory;
    }

    public Set<Method> methods(Set<CtMethod<?>> methods) {
        final var result = new HashSet<Method>();

        for (final var ref : methods) {
            result.add(method(ref));
        }
        return result;
    }

    public Method method(CtMethod<?> method) {
        final var name = method.getSimpleName();
        final var type = typeDescriptionFactory.description(method.getType());
        final var modifiers = method.getModifiers();

    final var body = method.getBody();
    final var statements = body.getStatements();

       final var visitor = new  ExpressionVisitor(  expressionBuilderFactory.builder() );

        for (final var statement: statements) {
            statement.accept(visitor);
        }


        return new Method(name, type, modifiers, parameters(method.getParameters()));
    }

    public List<Parameter> parameters(List<CtParameter<?>> ctParameters) {
        final var fields = new ArrayList<Parameter>();
        for (final var ref : ctParameters) {
            fields.add(parameter(ref));
        }
        return fields;
    }

    Parameter parameter(CtParameter<?> parameter) {
        final var name = parameter.getSimpleName();
        final var type = typeDescriptionFactory.description(parameter.getType());
        final var modifiers = parameter.getModifiers();

        return new Parameter(name, type);
    }

}
