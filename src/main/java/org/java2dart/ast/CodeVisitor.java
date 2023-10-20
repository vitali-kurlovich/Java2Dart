package org.java2dart.ast;


import org.java2dart.factory.Factory;
import org.java2dart.logging.Logger;
import org.java2dart.logging.Logging;
import org.java2dart.synthesize.type.dart.DartTypeSpecifier;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.path.CtRole;
import spoon.reflect.reference.*;
import spoon.reflect.visitor.CtVisitor;

import java.lang.annotation.Annotation;

public class CodeVisitor implements CtVisitor {


    private void print(String string) {
        System.out.print(string);
    }

    private void newline() {
        print("\n");
    }

    private void whitespace() {
        print(" ");
    }

    @Override
    public <A extends Annotation> void visitCtAnnotation(CtAnnotation<A> ctAnnotation) {

        print("visitCtAnnotation");
        newline();

    }

    @Override
    public <T> void visitCtCodeSnippetExpression(CtCodeSnippetExpression<T> ctCodeSnippetExpression) {
        print("visitCtCodeSnippetExpression");
        newline();
    }

    @Override
    public void visitCtCodeSnippetStatement(CtCodeSnippetStatement ctCodeSnippetStatement) {
        print("visitCtCodeSnippetStatement");
        newline();
    }

    @Override
    public <A extends Annotation> void visitCtAnnotationType(CtAnnotationType<A> ctAnnotationType) {

        print("visitCtAnnotationType");
        newline();

    }

    @Override
    public void visitCtAnonymousExecutable(CtAnonymousExecutable ctAnonymousExecutable) {
        print("visitCtAnonymousExecutable");
        newline();
    }

    @Override
    public <T> void visitCtArrayRead(CtArrayRead<T> ctArrayRead) {
        print("visitCtArrayRead");
        newline();
    }

    @Override
    public <T> void visitCtArrayWrite(CtArrayWrite<T> ctArrayWrite) {
        print("visitCtArrayWrite");
        newline();
    }

    @Override
    public <T> void visitCtArrayTypeReference(CtArrayTypeReference<T> ctArrayTypeReference) {
        print("visitCtArrayTypeReference");
        newline();
    }

    @Override
    public <T> void visitCtAssert(CtAssert<T> ctAssert) {
        print("visitCtAssert");
        newline();
    }


    @Override
    public <T> void visitCtBinaryOperator(CtBinaryOperator<T> ctBinaryOperator) {
        newline();
        print("visitCtBinaryOperator");

        final var leftExp = ctBinaryOperator.getLeftHandOperand();
        final var rightExp = ctBinaryOperator.getRightHandOperand();

        leftExp.accept(this);
        whitespace();

        final var king = ctBinaryOperator.getKind();

        print(king.toString());

        whitespace();
        rightExp.accept(this);

        newline();
    }

    @Override
    public <R> void visitCtBlock(CtBlock<R> ctBlock) {
        print("visitCtBlock");
        newline();
    }

    @Override
    public void visitCtBreak(CtBreak ctBreak) {
        print("visitCtBreak");
        newline();
    }

    @Override
    public <S> void visitCtCase(CtCase<S> ctCase) {
        print("visitCtCase");
        newline();
    }

    @Override
    public void visitCtCatch(CtCatch ctCatch) {
        print("visitCtCatch");
        newline();
    }

    @Override
    public <T> void visitCtClass(CtClass<T> ctClass) {
        print("visitCtClass");
        newline();

        final var factory = Factory.Schema();
        final var schema = factory.schema(ctClass);
        final var schemeSpecifier = Factory.Specifier().schemeSpecifier();
        final var source = schemeSpecifier.specify(schema);
        Logging.info(source);

       // final var path = ctClass.getPath();
       // print(path.toString());

      //  ctClass.getPackage().accept(this);


       // ctClass.getFields().forEach(f -> f.accept(this));

        // ctClass.getMethods().forEach(m -> m.accept(this));

    }

    @Override
    public void visitCtTypeParameter(CtTypeParameter ctTypeParameter) {
        print("visitCtTypeParameter");
        newline();
    }

    @Override
    public <T> void visitCtConditional(CtConditional<T> ctConditional) {
        print("CtConditional");
        newline();
    }

    @Override
    public <T> void visitCtConstructor(CtConstructor<T> ctConstructor) {
        print("visitCtConstructor");
        newline();
    }

    @Override
    public void visitCtContinue(CtContinue ctContinue) {
        print("visitCtContinue");
        newline();
    }

    @Override
    public void visitCtDo(CtDo ctDo) {
        print("visitCtDo");
        newline();
    }

    @Override
    public <T extends Enum<?>> void visitCtEnum(CtEnum<T> ctEnum) {
        print("visitCtEnum");
        newline();
    }

    @Override
    public <T> void visitCtExecutableReference(CtExecutableReference<T> ctExecutableReference) {
        print("visitCtExecutableReference");
        newline();
    }

    @Override
    public <T> void visitCtField(CtField<T> ctField) {


        print("visitCtField");
        newline();

        final var type = ctField.getType();

        final var factory = Factory.TypeDescription();

        try {
            final var desc = factory.description(type);

            final var specifier = new DartTypeSpecifier();


            print(specifier.specify(desc));


        } catch (Exception e) {

        }
    }

    @Override
    public <T> void visitCtEnumValue(CtEnumValue<T> ctEnumValue) {
        print("visitCtEnumValue");
        newline();
    }

    @Override
    public <T> void visitCtThisAccess(CtThisAccess<T> ctThisAccess) {
        print("visitCtThisAccess");
        newline();
    }

    @Override
    public <T> void visitCtFieldReference(CtFieldReference<T> ctFieldReference) {
        print("visitCtFieldReference");
        newline();
    }

    @Override
    public <T> void visitCtUnboundVariableReference(CtUnboundVariableReference<T> ctUnboundVariableReference) {
        print("visitCtUnboundVariableReference");
        newline();
    }

    @Override
    public void visitCtFor(CtFor ctFor) {
        print("visitCtFor");
        newline();
    }

    @Override
    public void visitCtForEach(CtForEach ctForEach) {
        print("visitCtForEach");
        newline();
    }

    @Override
    public void visitCtIf(CtIf ctIf) {
        print("visitCtIf");
        newline();
    }

    @Override
    public <T> void visitCtInterface(CtInterface<T> ctInterface) {
        print("visitCtInterface");
        newline();

        final var factory = Factory.Schema();
        final var schema = factory.schema(ctInterface);
        final var schemeSpecifier = Factory.Specifier().schemeSpecifier();
        final var source = schemeSpecifier.specify(schema);
        Logging.info(source);
    }

    @Override
    public <T> void visitCtInvocation(CtInvocation<T> ctInvocation) {
        print("visitCtInvocation");
        newline();
    }

    @Override
    public <T> void visitCtLiteral(CtLiteral<T> ctLiteral) {
        newline();
        print("visitCtLiteral");
        newline();

        final var literalType = ctLiteral.getType().getSimpleName();

        print("type: " + literalType);
        newline();
        final var value = ctLiteral.getValue();

        print(value.toString());


    }

    @Override
    public void visitCtTextBlock(CtTextBlock ctTextBlock) {
        print("visitCtTextBlock");
        newline();
    }

    @Override
    public <T, A extends T> void visitCtAssignment(CtAssignment<T, A> ctAssignment) {
        newline();
        print("visitCtAssignment");
        newline();

        var assigned = ctAssignment.getValueByRole(CtRole.ASSIGNED);


        print(assigned.toString());
        newline();

        final var assigmentExp = ctAssignment.getAssignment();


        assigmentExp.accept(this);


        newline();

        print("------");
        newline();

    }


    @Override
    public <T> void visitCtLocalVariable(CtLocalVariable<T> ctLocalVariable) {
        print("visitCtLocalVariable");
        newline();


        var assigned = ctLocalVariable.getReference().getSimpleName();   ///..getValueByRole(CtRole.ASSIGNED);


        print(assigned);
        newline();

        var expression = ctLocalVariable.getDefaultExpression();

        expression.accept(this);

        //print(expression.toString());
        newline();

        print("------");
        newline();
    }


    @Override
    public <T> void visitCtLocalVariableReference(CtLocalVariableReference<T> ctLocalVariableReference) {
        print("visitCtLocalVariableReference");
        newline();
    }

    @Override
    public <T> void visitCtCatchVariable(CtCatchVariable<T> ctCatchVariable) {
        print("visitCtCatchVariable");
        newline();
    }

    @Override
    public <T> void visitCtCatchVariableReference(CtCatchVariableReference<T> ctCatchVariableReference) {
        print("visitCtCatchVariableReference");
        newline();
    }

    @Override
    public <T> void visitCtMethod(CtMethod<T> ctMethod) {
        print("visitCtMethod");
        newline();

        var ctTypeReference = ctMethod.getType();

        final var factory = Factory.TypeDescription();

        try {
            final var desc = factory.description(ctTypeReference);
            System.out.println(desc.toString());
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


    }

    @Override
    public <T> void visitCtAnnotationMethod(CtAnnotationMethod<T> ctAnnotationMethod) {
        print("visitCtAnnotationMethod");
        newline();
    }

    @Override
    public <T> void visitCtNewArray(CtNewArray<T> ctNewArray) {
        print("visitCtNewArray");
        newline();
    }

    @Override
    public <T> void visitCtConstructorCall(CtConstructorCall<T> ctConstructorCall) {
        print("visitCtConstructorCall");
        newline();
    }

    @Override
    public <T> void visitCtNewClass(CtNewClass<T> ctNewClass) {
        print("visitCtNewClass");
        newline();
    }

    @Override
    public <T> void visitCtLambda(CtLambda<T> ctLambda) {
        print("visitCtLambda");
        newline();
    }

    @Override
    public <T, E extends CtExpression<?>> void visitCtExecutableReferenceExpression(CtExecutableReferenceExpression<T, E> ctExecutableReferenceExpression) {
        print("visitCtExecutableReferenceExpression");
        newline();
    }

    @Override
    public <T, A extends T> void visitCtOperatorAssignment(CtOperatorAssignment<T, A> ctOperatorAssignment) {

        print("visitCtOperatorAssignment");
        newline();
    }

    @Override
    public void visitCtPackage(CtPackage ctPackage) {
        print("visitCtPackage");
        whitespace();
        print(ctPackage.getSimpleName());
        newline();


    }

    @Override
    public void visitCtPackageReference(CtPackageReference ctPackageReference) {
        print("visitCtPackageReference");
        newline();
    }

    @Override
    public <T> void visitCtParameter(CtParameter<T> ctParameter) {
        print("visitCtParameter");
        newline();
    }

    @Override
    public <T> void visitCtParameterReference(CtParameterReference<T> ctParameterReference) {
        print("visitCtParameterReference");
        newline();
    }

    @Override
    public <R> void visitCtReturn(CtReturn<R> ctReturn) {
        print("visitCtReturn");
        newline();
    }

    @Override
    public <R> void visitCtStatementList(CtStatementList ctStatementList) {
        print("visitCtStatementList");
        newline();
    }

    @Override
    public <S> void visitCtSwitch(CtSwitch<S> ctSwitch) {
        print("visitCtSwitch");
        newline();
    }

    @Override
    public <T, S> void visitCtSwitchExpression(CtSwitchExpression<T, S> ctSwitchExpression) {
        print("visitCtSwitchExpression");
        newline();
    }

    @Override
    public void visitCtSynchronized(CtSynchronized ctSynchronized) {
        print("visitCtSynchronized");
        newline();
    }

    @Override
    public void visitCtThrow(CtThrow ctThrow) {
        print("visitCtThrow");
        newline();
    }

    @Override
    public void visitCtTry(CtTry ctTry) {
        print("visitCtTry");
        newline();
    }

    @Override
    public void visitCtTryWithResource(CtTryWithResource ctTryWithResource) {
        print("visitCtTryWithResource");
        newline();
    }

    @Override
    public void visitCtTypeParameterReference(CtTypeParameterReference ctTypeParameterReference) {
        print("visitCtTypeParameterReference");
        newline();
    }

    @Override
    public void visitCtWildcardReference(CtWildcardReference ctWildcardReference) {
        print("visitCtWildcardReference");
        newline();
    }

    @Override
    public <T> void visitCtIntersectionTypeReference(CtIntersectionTypeReference<T> ctIntersectionTypeReference) {
        print("visitCtIntersectionTypeReference");
        newline();
    }

    @Override
    public <T> void visitCtTypeReference(CtTypeReference<T> ctTypeReference) {
        print("visitCtTypeReference");
        print("    ");
        final var simpleName = ctTypeReference.getSimpleName();

        print(simpleName);
        newline();

//        final var factory = Factory.TypeDescription();
//
//        try {
//            final var desc = factory.description(ctTypeReference);
//            System.out.println(desc.toString());
//        } catch (Exception e) {
//
//            System.out.println(e.getMessage());
//        }
//
//        //System.out.println(desc.toString());
//
        final var decl = ctTypeReference.getDeclaration();

        if (decl != null) {
            decl.accept(this);
        }

        // ctTypeReference.getDeclaration().accept(this);
    }

    @Override
    public <T> void visitCtTypeAccess(CtTypeAccess<T> ctTypeAccess) {
        print("visitCtTypeAccess");
        newline();
    }

    @Override
    public <T> void visitCtUnaryOperator(CtUnaryOperator<T> ctUnaryOperator) {
        print("visitCtUnaryOperator");
        newline();
    }

    @Override
    public <T> void visitCtVariableRead(CtVariableRead<T> ctVariableRead) {

        newline();
        print("visitCtVariableRead");
        newline();

        final var varible = ctVariableRead.getVariable();
        print(varible.getSimpleName());
        newline();


    }

    @Override
    public <T> void visitCtVariableWrite(CtVariableWrite<T> ctVariableWrite) {
        print("visitCtVariableWrite");
        newline();
    }

    @Override
    public void visitCtWhile(CtWhile ctWhile) {
        print("visitCtWhile");
        newline();
    }

    @Override
    public <T> void visitCtAnnotationFieldAccess(CtAnnotationFieldAccess<T> ctAnnotationFieldAccess) {
        print("visitCtAnnotationFieldAccess");
        newline();
    }

    @Override
    public <T> void visitCtFieldRead(CtFieldRead<T> ctFieldRead) {
        print("visitCtFieldRead");
        newline();
    }

    @Override
    public <T> void visitCtFieldWrite(CtFieldWrite<T> ctFieldWrite) {
        print("visitCtFieldWrite");
        newline();
    }

    @Override
    public <T> void visitCtSuperAccess(CtSuperAccess<T> ctSuperAccess) {
        print("visitCtSuperAccess");
        newline();
    }

    @Override
    public void visitCtComment(CtComment ctComment) {
        print("visitCtComment");
        newline();
    }

    @Override
    public void visitCtJavaDoc(CtJavaDoc ctJavaDoc) {
        print("visitCtJavaDoc");
        newline();
    }

    @Override
    public void visitCtJavaDocTag(CtJavaDocTag ctJavaDocTag) {
        print("visitCtJavaDocTag");
        newline();
    }

    @Override
    public void visitCtImport(CtImport ctImport) {
        print("visitCtImport");
        newline();
    }

    @Override
    public void visitCtModule(CtModule ctModule) {
        print("visitCtModule");
        newline();

        ctModule.getExportedPackages().forEach(pack -> pack.accept(this));

        ctModule.getRootPackage().accept(this);

        ctModule.getReferencedTypes().forEach(t -> t.accept(this));

        // ctModule.accept(this);
    }

    @Override
    public void visitCtModuleReference(CtModuleReference ctModuleReference) {
        print("visitCtModuleReference");
        newline();
    }

    @Override
    public void visitCtPackageExport(CtPackageExport ctPackageExport) {
        print("visitCtPackageExport");
        newline();
    }

    @Override
    public void visitCtModuleRequirement(CtModuleRequirement ctModuleRequirement) {
        print("visitCtModuleRequirement");
        newline();
    }

    @Override
    public void visitCtProvidedService(CtProvidedService ctProvidedService) {
        print("visitCtProvidedService");
        newline();
    }

    @Override
    public void visitCtUsedService(CtUsedService ctUsedService) {
        print("visitCtUsedService");
        newline();
    }

    @Override
    public void visitCtCompilationUnit(CtCompilationUnit ctCompilationUnit) {
        print("visitCtCompilationUnit");
        newline();
    }

    @Override
    public void visitCtPackageDeclaration(CtPackageDeclaration ctPackageDeclaration) {
        print("visitCtPackageDeclaration");
        newline();
    }

    @Override
    public void visitCtTypeMemberWildcardImportReference(CtTypeMemberWildcardImportReference ctTypeMemberWildcardImportReference) {
        print("visitCtTypeMemberWildcardImportReference");
        newline();
    }

    @Override
    public void visitCtYieldStatement(CtYieldStatement ctYieldStatement) {
        print("visitCtYieldStatement");
        newline();
    }

    @Override
    public void visitCtTypePattern(CtTypePattern ctTypePattern) {
        print("visitCtTypePattern");
        newline();
    }

    @Override
    public void visitCtRecord(CtRecord ctRecord) {
        print("visitCtRecord");
        newline();
    }

    @Override
    public void visitCtRecordComponent(CtRecordComponent ctRecordComponent) {
        print("visitCtRecordComponent");
        newline();
    }
}
