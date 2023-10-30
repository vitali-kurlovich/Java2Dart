package org.java2dart.expression;

import org.java2dart.expression.builder.IExpressionBuilder;
import spoon.reflect.code.CtAnnotationFieldAccess;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtStatementList;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.*;
import spoon.reflect.visitor.CtVisitor;

import java.lang.annotation.Annotation;

public abstract class BaseExpressionVisitor implements CtVisitor {
    protected final IExpressionBuilder builder;

    protected BaseExpressionVisitor(IExpressionBuilder buider) {
        this.builder = buider;
    }


    @Override
    public <A extends Annotation> void visitCtAnnotation(CtAnnotation<A> annotation) {

    }

    @Override
    public <T> void visitCtCodeSnippetExpression(CtCodeSnippetExpression<T> expression) {

    }

    @Override
    public void visitCtCodeSnippetStatement(CtCodeSnippetStatement statement) {

    }

    @Override
    public <A extends Annotation> void visitCtAnnotationType(CtAnnotationType<A> annotationType) {

    }

    @Override
    public void visitCtAnonymousExecutable(CtAnonymousExecutable anonymousExec) {

    }

    @Override
    public <T> void visitCtClass(CtClass<T> ctClass) {

    }


    @Override
    public <T extends Enum<?>> void visitCtEnum(CtEnum<T> ctEnum) {

    }

    @Override
    public <T> void visitCtInterface(CtInterface<T> intrface) {

    }


    @Override
    public <T> void visitCtFieldReference(CtFieldReference<T> reference) {

    }

    @Override
    public <T> void visitCtUnboundVariableReference(CtUnboundVariableReference<T> reference) {

    }

    @Override
    public <T> void visitCtArrayTypeReference(CtArrayTypeReference<T> reference) {

    }

    @Override
    public <T> void visitCtLocalVariableReference(CtLocalVariableReference<T> reference) {

    }

    @Override
    public void visitCtTypeParameter(CtTypeParameter typeParameter) {

    }

    @Override
    public <T> void visitCtField(CtField<T> f) {

    }

    @Override
    public <T> void visitCtMethod(CtMethod<T> m) {

    }

    @Override
    public <T> void visitCtAnnotationMethod(CtAnnotationMethod<T> annotationMethod) {

    }


    @Override
    public <T> void visitCtConstructor(CtConstructor<T> c) {

    }


    @Override
    public void visitCtPackage(CtPackage ctPackage) {

    }

    @Override
    public void visitCtPackageReference(CtPackageReference reference) {

    }

    @Override
    public <T> void visitCtParameter(CtParameter<T> parameter) {

    }

    @Override
    public <T> void visitCtParameterReference(CtParameterReference<T> reference) {

    }

    @Override
    public void visitCtTypeParameterReference(CtTypeParameterReference ref) {

    }

    @Override
    public void visitCtWildcardReference(CtWildcardReference wildcardReference) {

    }


    @Override
    public <T> void visitCtTypeReference(CtTypeReference<T> reference) {

    }

    @Override
    public <T> void visitCtIntersectionTypeReference(CtIntersectionTypeReference<T> reference) {

    }


    @Override
    public <T> void visitCtAnnotationFieldAccess(CtAnnotationFieldAccess<T> annotationFieldAccess) {

    }

    @Override
    public void visitCtImport(CtImport ctImport) {

    }

    @Override
    public void visitCtModule(CtModule module) {

    }

    @Override
    public void visitCtModuleReference(CtModuleReference moduleReference) {

    }

    @Override
    public void visitCtPackageExport(CtPackageExport moduleExport) {

    }

    @Override
    public void visitCtModuleRequirement(CtModuleRequirement moduleRequirement) {

    }

    @Override
    public void visitCtProvidedService(CtProvidedService moduleProvidedService) {

    }

    @Override
    public void visitCtUsedService(CtUsedService usedService) {

    }

    @Override
    public void visitCtCompilationUnit(CtCompilationUnit compilationUnit) {

    }

    @Override
    public <R> void visitCtStatementList(CtStatementList statements) {

    }

    @Override
    public <T> void visitCtExecutableReference(CtExecutableReference<T> reference) {

    }


}
