package org.java2dart.expression;

import org.java2dart.expression.builder.IExpressionBuilder;
import org.java2dart.logging.Logging;
import spoon.reflect.code.*;
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
        Logging.warning("Do not implemented - visitCtAnnotation");
    }

    @Override
    public <T> void visitCtCodeSnippetExpression(CtCodeSnippetExpression<T> expression) {
        Logging.warning("Do not implemented - visitCtCodeSnippetExpression");
    }

    @Override
    public void visitCtCodeSnippetStatement(CtCodeSnippetStatement statement) {
        Logging.warning("Do not implemented - visitCtCodeSnippetStatement");
    }

    @Override
    public <A extends Annotation> void visitCtAnnotationType(CtAnnotationType<A> annotationType) {
        Logging.warning("Do not implemented - visitCtAnnotationType");
    }

    @Override
    public void visitCtAnonymousExecutable(CtAnonymousExecutable anonymousExec) {
        Logging.warning("Do not implemented - visitCtAnonymousExecutable");
    }

    @Override
    public <T> void visitCtClass(CtClass<T> ctClass) {
        Logging.warning("Do not implemented - visitCtClass");
    }


    @Override
    public <T extends Enum<?>> void visitCtEnum(CtEnum<T> ctEnum) {
        Logging.warning("Do not implemented - visitCtEnum");
    }

    @Override
    public <T> void visitCtInterface(CtInterface<T> intrface) {
        Logging.warning("Do not implemented - visitCtInterface");
    }


    @Override
    public <T> void visitCtFieldReference(CtFieldReference<T> reference) {
        Logging.warning("Do not implemented - visitCtFieldReference");
    }

    @Override
    public <T> void visitCtUnboundVariableReference(CtUnboundVariableReference<T> reference) {
        Logging.warning("Do not implemented - visitCtUnboundVariableReference");
    }

    @Override
    public <T> void visitCtEnumValue(CtEnumValue<T> enumValue) {
        Logging.warning("Do not implemented - visitCtEnumValue");
    }


    @Override
    public <T> void visitCtArrayTypeReference(CtArrayTypeReference<T> reference) {
        Logging.warning("Do not implemented - visitCtArrayTypeReference");
    }

    @Override
    public <T> void visitCtLocalVariableReference(CtLocalVariableReference<T> reference) {
        Logging.warning("Do not implemented - visitCtLocalVariableReference");
    }

    @Override
    public void visitCtTypeParameter(CtTypeParameter typeParameter) {
        Logging.warning("Do not implemented - visitCtTypeParameter");
    }

    @Override
    public <T> void visitCtField(CtField<T> f) {
        Logging.warning("Do not implemented - visitCtField");
    }

    @Override
    public <T> void visitCtMethod(CtMethod<T> m) {
        Logging.warning("Do not implemented - visitCtMethod");
    }

    @Override
    public <T> void visitCtAnnotationMethod(CtAnnotationMethod<T> annotationMethod) {
        Logging.warning("Do not implemented - visitCtAnnotationMethod");
    }


    @Override
    public <T> void visitCtConstructor(CtConstructor<T> c) {
        Logging.warning("Do not implemented - visitCtConstructor");
    }


    @Override
    public void visitCtPackage(CtPackage ctPackage) {
        Logging.warning("Do not implemented - visitCtPackage");
    }

    @Override
    public void visitCtPackageReference(CtPackageReference reference) {
        Logging.warning("Do not implemented - visitCtPackageReference");
    }

    @Override
    public <T> void visitCtParameter(CtParameter<T> parameter) {
        Logging.warning("Do not implemented - visitCtParameter");
    }

    @Override
    public <T> void visitCtParameterReference(CtParameterReference<T> reference) {
        Logging.warning("Do not implemented - visitCtParameterReference");
    }

    @Override
    public void visitCtTypeParameterReference(CtTypeParameterReference ref) {
        Logging.warning("Do not implemented - visitCtTypeParameterReference");
    }

    @Override
    public void visitCtWildcardReference(CtWildcardReference wildcardReference) {
        Logging.warning("Do not implemented - visitCtWildcardReference");
    }


    @Override
    public <T> void visitCtTypeReference(CtTypeReference<T> reference) {
        Logging.warning("Do not implemented - visitCtTypeReference");
    }

    @Override
    public <T> void visitCtIntersectionTypeReference(CtIntersectionTypeReference<T> reference) {
        Logging.warning("Do not implemented - visitCtIntersectionTypeReference");
    }


    @Override
    public <T> void visitCtAnnotationFieldAccess(CtAnnotationFieldAccess<T> annotationFieldAccess) {
        Logging.warning("Do not implemented - visitCtAnnotationFieldAccess");
    }

    @Override
    public void visitCtImport(CtImport ctImport) {
        Logging.warning("Do not implemented - visitCtImport");
    }


    @Override
    public void visitCtPackageDeclaration(CtPackageDeclaration packageDeclaration) {
        Logging.warning("Do not implemented - visitCtPackageDeclaration");
    }

    @Override
    public void visitCtTypeMemberWildcardImportReference(CtTypeMemberWildcardImportReference wildcardReference) {
        Logging.warning("Do not implemented - visitCtTypeMemberWildcardImportReference");
    }

    @Override
    public void visitCtModule(CtModule module) {
        Logging.warning("Do not implemented - visitCtModule");
    }

    @Override
    public void visitCtModuleReference(CtModuleReference moduleReference) {
        Logging.warning("Do not implemented - visitCtModuleReference");
    }

    @Override
    public void visitCtPackageExport(CtPackageExport moduleExport) {
        Logging.warning("Do not implemented - visitCtPackageExport");
    }

    @Override
    public void visitCtModuleRequirement(CtModuleRequirement moduleRequirement) {
        Logging.warning("Do not implemented - visitCtModuleRequirement");
    }

    @Override
    public void visitCtProvidedService(CtProvidedService moduleProvidedService) {
        Logging.warning("Do not implemented - visitCtProvidedService");
    }

    @Override
    public void visitCtUsedService(CtUsedService usedService) {
        Logging.warning("Do not implemented - visitCtUsedService");
    }

    @Override
    public void visitCtCompilationUnit(CtCompilationUnit compilationUnit) {
        Logging.warning("Do not implemented - visitCtCompilationUnit");
    }

    @Override
    public <R> void visitCtStatementList(CtStatementList statements) {
        Logging.warning("Do not implemented - visitCtStatementList");
    }

    @Override
    public <T> void visitCtExecutableReference(CtExecutableReference<T> reference) {
        Logging.warning("Do not implemented - visitCtExecutableReference");
    }


    @Override
    public void visitCtComment(CtComment comment) {
        Logging.warning("Do not implemented - visitCtComment");
    }

    @Override
    public void visitCtJavaDoc(CtJavaDoc comment) {
        Logging.warning("Do not implemented - visitCtJavaDoc");
    }

    @Override
    public void visitCtJavaDocTag(CtJavaDocTag docTag) {
        Logging.warning("Do not implemented - visitCtJavaDocTag");
    }


}
