package org.java2dart.ast.generate;

import org.java2dart.ast.generate.builder.base.CodeBuilder;
import org.java2dart.factory.Factory;
import org.java2dart.synthesize.type.dart.DartTypeSpecifier;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.path.CtRole;
import spoon.reflect.reference.*;
import spoon.reflect.visitor.CtVisitor;

import java.lang.annotation.Annotation;

public class CodeVisitor implements CtVisitor {

    protected final CodeBuilder builder;

    public CodeVisitor(CodeBuilder builder) {
        this.builder = builder;
    }

    @Override
    public <A extends Annotation> void visitCtAnnotation(CtAnnotation<A> ctAnnotation) {

        builder.append("visitCtAnnotation");
        builder.newline();

    }

    @Override
    public <T> void visitCtCodeSnippetExpression(CtCodeSnippetExpression<T> ctCodeSnippetExpression) {
        builder.append("visitCtCodeSnippetExpression");
        builder.newline();
    }

    @Override
    public void visitCtCodeSnippetStatement(CtCodeSnippetStatement ctCodeSnippetStatement) {
        builder.append("visitCtCodeSnippetStatement");
        builder.newline();
    }

    @Override
    public <A extends Annotation> void visitCtAnnotationType(CtAnnotationType<A> ctAnnotationType) {

        builder.append("visitCtAnnotationType");
        builder.newline();

    }

    @Override
    public void visitCtAnonymousExecutable(CtAnonymousExecutable ctAnonymousExecutable) {
        builder.append("visitCtAnonymousExecutable");
        builder.newline();
    }

    @Override
    public <T> void visitCtArrayRead(CtArrayRead<T> ctArrayRead) {
        builder.append("visitCtArrayRead");
        builder.newline();
    }

    @Override
    public <T> void visitCtArrayWrite(CtArrayWrite<T> ctArrayWrite) {
        builder.append("visitCtArrayWrite");
        builder.newline();
    }

    @Override
    public <T> void visitCtArrayTypeReference(CtArrayTypeReference<T> ctArrayTypeReference) {
        builder.append("visitCtArrayTypeReference");
        builder.newline();
    }

    @Override
    public <T> void visitCtAssert(CtAssert<T> ctAssert) {
        builder.append("visitCtAssert");
        builder.newline();
    }


    @Override
    public <T> void visitCtBinaryOperator(CtBinaryOperator<T> ctBinaryOperator) {
        builder.newline();
        builder.append("visitCtBinaryOperator");

        final var leftExp = ctBinaryOperator.getLeftHandOperand();
        final var rightExp = ctBinaryOperator.getRightHandOperand();

        leftExp.accept(this);
        builder.whitespace();

        final var king = ctBinaryOperator.getKind();

        builder.append(king.toString());

        builder.whitespace();
        rightExp.accept(this);

        builder.newline();
    }

    @Override
    public <R> void visitCtBlock(CtBlock<R> ctBlock) {
        builder.append("visitCtBlock");
        builder.newline();
    }

    @Override
    public void visitCtBreak(CtBreak ctBreak) {
        builder.append("visitCtBreak");
        builder.newline();
    }

    @Override
    public <S> void visitCtCase(CtCase<S> ctCase) {
        builder.append("visitCtCase");
        builder.newline();
    }

    @Override
    public void visitCtCatch(CtCatch ctCatch) {
        builder.append("visitCtCatch");
        builder.newline();
    }

    @Override
    public <T> void visitCtClass(CtClass<T> ctClass) {
        builder.append("visitCtClass");
        builder.newline();


        final var factory = Factory.Schema();

       final var schema = factory.classSchema(ctClass);

       final var schemeSpecifier = Factory.Specifier().schemeSpecifier();

       final var source = schemeSpecifier.specify(schema);


       System.out.println( source );

        final var path = ctClass.getPath();
        builder.append(path.toString());

        ctClass.getPackage().accept(this);


        ctClass.getFields().forEach(f -> f.accept(this));

       // ctClass.getMethods().forEach(m -> m.accept(this));

    }

    @Override
    public void visitCtTypeParameter(CtTypeParameter ctTypeParameter) {
        builder.append("visitCtTypeParameter");
        builder.newline();
    }

    @Override
    public <T> void visitCtConditional(CtConditional<T> ctConditional) {
        builder.append("CtConditional");
        builder.newline();
    }

    @Override
    public <T> void visitCtConstructor(CtConstructor<T> ctConstructor) {
        builder.append("visitCtConstructor");
        builder.newline();
    }

    @Override
    public void visitCtContinue(CtContinue ctContinue) {
        builder.append("visitCtContinue");
        builder.newline();
    }

    @Override
    public void visitCtDo(CtDo ctDo) {
        builder.append("visitCtDo");
        builder.newline();
    }

    @Override
    public <T extends Enum<?>> void visitCtEnum(CtEnum<T> ctEnum) {
        builder.append("visitCtEnum");
        builder.newline();
    }

    @Override
    public <T> void visitCtExecutableReference(CtExecutableReference<T> ctExecutableReference) {
        builder.append("visitCtExecutableReference");
        builder.newline();
    }

    @Override
    public <T> void visitCtField(CtField<T> ctField) {
        builder.append("visitCtField");
        builder.newline();


      final var type =  ctField.getType();


      final var factory = Factory.TypeDescription();

      try {
         final var desc = factory.description(type);

        final var  specifier = new DartTypeSpecifier();



         System.out.println( specifier.specify(desc));

      } catch (Exception e) {

      }

    }

    @Override
    public <T> void visitCtEnumValue(CtEnumValue<T> ctEnumValue) {
        builder.append("visitCtEnumValue");
        builder.newline();
    }

    @Override
    public <T> void visitCtThisAccess(CtThisAccess<T> ctThisAccess) {
        builder.append("visitCtThisAccess");
        builder.newline();
    }

    @Override
    public <T> void visitCtFieldReference(CtFieldReference<T> ctFieldReference) {
        builder.append("visitCtFieldReference");
        builder.newline();
    }

    @Override
    public <T> void visitCtUnboundVariableReference(CtUnboundVariableReference<T> ctUnboundVariableReference) {
        builder.append("visitCtUnboundVariableReference");
        builder.newline();
    }

    @Override
    public void visitCtFor(CtFor ctFor) {
        builder.append("visitCtFor");
        builder.newline();
    }

    @Override
    public void visitCtForEach(CtForEach ctForEach) {
        builder.append("visitCtForEach");
        builder.newline();
    }

    @Override
    public void visitCtIf(CtIf ctIf) {
        builder.append("visitCtIf");
        builder.newline();
    }

    @Override
    public <T> void visitCtInterface(CtInterface<T> ctInterface) {
        builder.append("visitCtInterface");
        builder.newline();
    }

    @Override
    public <T> void visitCtInvocation(CtInvocation<T> ctInvocation) {
        builder.append("visitCtInvocation");
        builder.newline();
    }

    @Override
    public <T> void visitCtLiteral(CtLiteral<T> ctLiteral) {
        builder.newline();
        builder.append("visitCtLiteral");
        builder.newline();

        final var literalType = ctLiteral.getType().getSimpleName();

        builder.append("type: " + literalType);
        builder.newline();
        final var value = ctLiteral.getValue();

        builder.append(value.toString());


    }

    @Override
    public void visitCtTextBlock(CtTextBlock ctTextBlock) {
        builder.append("visitCtTextBlock");
        builder.newline();
    }

    @Override
    public <T, A extends T> void visitCtAssignment(CtAssignment<T, A> ctAssignment) {
        builder.newline();
        builder.append("visitCtAssignment");
        builder.newline();

        var assigned = ctAssignment.getValueByRole(CtRole.ASSIGNED);


        builder.append(assigned.toString());
        builder.newline();

        final var assigmentExp = ctAssignment.getAssignment();


        assigmentExp.accept(this);


        builder.newline();

        builder.append("------");
        builder.newline();

    }


    @Override
    public <T> void visitCtLocalVariable(CtLocalVariable<T> ctLocalVariable) {
        builder.append("visitCtLocalVariable");
        builder.newline();


        var assigned = ctLocalVariable.getReference().getSimpleName();   ///..getValueByRole(CtRole.ASSIGNED);


        builder.append(assigned);
        builder.newline();

        var expression = ctLocalVariable.getDefaultExpression();

        expression.accept(this);

        //builder.append(expression.toString());
        builder.newline();

        builder.append("------");
        builder.newline();
    }


    @Override
    public <T> void visitCtLocalVariableReference(CtLocalVariableReference<T> ctLocalVariableReference) {
        builder.append("visitCtLocalVariableReference");
        builder.newline();
    }

    @Override
    public <T> void visitCtCatchVariable(CtCatchVariable<T> ctCatchVariable) {
        builder.append("visitCtCatchVariable");
        builder.newline();
    }

    @Override
    public <T> void visitCtCatchVariableReference(CtCatchVariableReference<T> ctCatchVariableReference) {
        builder.append("visitCtCatchVariableReference");
        builder.newline();
    }

    @Override
    public <T> void visitCtMethod(CtMethod<T> ctMethod) {
        builder.append("visitCtMethod");
        builder.newline();

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
        builder.append("visitCtAnnotationMethod");
        builder.newline();
    }

    @Override
    public <T> void visitCtNewArray(CtNewArray<T> ctNewArray) {
        builder.append("visitCtNewArray");
        builder.newline();
    }

    @Override
    public <T> void visitCtConstructorCall(CtConstructorCall<T> ctConstructorCall) {
        builder.append("visitCtConstructorCall");
        builder.newline();
    }

    @Override
    public <T> void visitCtNewClass(CtNewClass<T> ctNewClass) {
        builder.append("visitCtNewClass");
        builder.newline();
    }

    @Override
    public <T> void visitCtLambda(CtLambda<T> ctLambda) {
        builder.append("visitCtLambda");
        builder.newline();
    }

    @Override
    public <T, E extends CtExpression<?>> void visitCtExecutableReferenceExpression(CtExecutableReferenceExpression<T, E> ctExecutableReferenceExpression) {
        builder.append("visitCtExecutableReferenceExpression");
        builder.newline();
    }

    @Override
    public <T, A extends T> void visitCtOperatorAssignment(CtOperatorAssignment<T, A> ctOperatorAssignment) {

        builder.append("visitCtOperatorAssignment");
        builder.newline();
    }

    @Override
    public void visitCtPackage(CtPackage ctPackage) {
        builder.append("visitCtPackage");
        builder.whitespace();
        builder.append(ctPackage.getSimpleName());
        builder.newline();


    }

    @Override
    public void visitCtPackageReference(CtPackageReference ctPackageReference) {
        builder.append("visitCtPackageReference");
        builder.newline();

        //ctPackageReference.getDirectChildren().forEach( t -> t.accept(this));

        // ctPackageReference.asIterable().forEach(el -> el.accept(this));

        //final var fragment = ctPackageReference.getOriginalSourceFragment();
        //builder.append( fragment.getSourceCode() );

    }

    @Override
    public <T> void visitCtParameter(CtParameter<T> ctParameter) {
        builder.append("visitCtParameter");
        builder.newline();
    }

    @Override
    public <T> void visitCtParameterReference(CtParameterReference<T> ctParameterReference) {
        builder.append("visitCtParameterReference");
        builder.newline();
    }

    @Override
    public <R> void visitCtReturn(CtReturn<R> ctReturn) {
        builder.append("visitCtReturn");
        builder.newline();
    }

    @Override
    public <R> void visitCtStatementList(CtStatementList ctStatementList) {
        builder.append("visitCtStatementList");
        builder.newline();
    }

    @Override
    public <S> void visitCtSwitch(CtSwitch<S> ctSwitch) {
        builder.append("visitCtSwitch");
        builder.newline();
    }

    @Override
    public <T, S> void visitCtSwitchExpression(CtSwitchExpression<T, S> ctSwitchExpression) {
        builder.append("visitCtSwitchExpression");
        builder.newline();
    }

    @Override
    public void visitCtSynchronized(CtSynchronized ctSynchronized) {
        builder.append("visitCtSynchronized");
        builder.newline();
    }

    @Override
    public void visitCtThrow(CtThrow ctThrow) {
        builder.append("visitCtThrow");
        builder.newline();
    }

    @Override
    public void visitCtTry(CtTry ctTry) {
        builder.append("visitCtTry");
        builder.newline();
    }

    @Override
    public void visitCtTryWithResource(CtTryWithResource ctTryWithResource) {
        builder.append("visitCtTryWithResource");
        builder.newline();
    }

    @Override
    public void visitCtTypeParameterReference(CtTypeParameterReference ctTypeParameterReference) {
        builder.append("visitCtTypeParameterReference");
        builder.newline();
    }

    @Override
    public void visitCtWildcardReference(CtWildcardReference ctWildcardReference) {
        builder.append("visitCtWildcardReference");
        builder.newline();
    }

    @Override
    public <T> void visitCtIntersectionTypeReference(CtIntersectionTypeReference<T> ctIntersectionTypeReference) {
        builder.append("visitCtIntersectionTypeReference");
        builder.newline();
    }

    @Override
    public <T> void visitCtTypeReference(CtTypeReference<T> ctTypeReference) {
        builder.append("visitCtTypeReference");
        builder.append("    ");
        final var simpleName = ctTypeReference.getSimpleName();

        builder.append(simpleName);
        builder.newline();

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
        builder.append("visitCtTypeAccess");
        builder.newline();
    }

    @Override
    public <T> void visitCtUnaryOperator(CtUnaryOperator<T> ctUnaryOperator) {
        builder.append("visitCtUnaryOperator");
        builder.newline();
    }

    @Override
    public <T> void visitCtVariableRead(CtVariableRead<T> ctVariableRead) {

        builder.newline();
        builder.append("visitCtVariableRead");
        builder.newline();

        final var varible = ctVariableRead.getVariable();
        builder.append(varible.getSimpleName());
        builder.newline();


    }

    @Override
    public <T> void visitCtVariableWrite(CtVariableWrite<T> ctVariableWrite) {
        builder.append("visitCtVariableWrite");
        builder.newline();
    }

    @Override
    public void visitCtWhile(CtWhile ctWhile) {
        builder.append("visitCtWhile");
        builder.newline();
    }

    @Override
    public <T> void visitCtAnnotationFieldAccess(CtAnnotationFieldAccess<T> ctAnnotationFieldAccess) {
        builder.append("visitCtAnnotationFieldAccess");
        builder.newline();
    }

    @Override
    public <T> void visitCtFieldRead(CtFieldRead<T> ctFieldRead) {
        builder.append("visitCtFieldRead");
        builder.newline();
    }

    @Override
    public <T> void visitCtFieldWrite(CtFieldWrite<T> ctFieldWrite) {
        builder.append("visitCtFieldWrite");
        builder.newline();
    }

    @Override
    public <T> void visitCtSuperAccess(CtSuperAccess<T> ctSuperAccess) {
        builder.append("visitCtSuperAccess");
        builder.newline();
    }

    @Override
    public void visitCtComment(CtComment ctComment) {
        builder.append("visitCtComment");
        builder.newline();
    }

    @Override
    public void visitCtJavaDoc(CtJavaDoc ctJavaDoc) {
        builder.append("visitCtJavaDoc");
        builder.newline();
    }

    @Override
    public void visitCtJavaDocTag(CtJavaDocTag ctJavaDocTag) {
        builder.append("visitCtJavaDocTag");
        builder.newline();
    }

    @Override
    public void visitCtImport(CtImport ctImport) {
        builder.append("visitCtImport");
        builder.newline();
    }

    @Override
    public void visitCtModule(CtModule ctModule) {
        builder.append("visitCtModule");
        builder.newline();

        ctModule.getExportedPackages().forEach(pack -> pack.accept(this));

        ctModule.getRootPackage().accept(this);

        ctModule.getReferencedTypes().forEach(t -> t.accept(this));

        // ctModule.accept(this);
    }

    @Override
    public void visitCtModuleReference(CtModuleReference ctModuleReference) {
        builder.append("visitCtModuleReference");
        builder.newline();
    }

    @Override
    public void visitCtPackageExport(CtPackageExport ctPackageExport) {
        builder.append("visitCtPackageExport");
        builder.newline();
    }

    @Override
    public void visitCtModuleRequirement(CtModuleRequirement ctModuleRequirement) {
        builder.append("visitCtModuleRequirement");
        builder.newline();
    }

    @Override
    public void visitCtProvidedService(CtProvidedService ctProvidedService) {
        builder.append("visitCtProvidedService");
        builder.newline();
    }

    @Override
    public void visitCtUsedService(CtUsedService ctUsedService) {
        builder.append("visitCtUsedService");
        builder.newline();
    }

    @Override
    public void visitCtCompilationUnit(CtCompilationUnit ctCompilationUnit) {
        builder.append("visitCtCompilationUnit");
        builder.newline();
    }

    @Override
    public void visitCtPackageDeclaration(CtPackageDeclaration ctPackageDeclaration) {
        builder.append("visitCtPackageDeclaration");
        builder.newline();
    }

    @Override
    public void visitCtTypeMemberWildcardImportReference(CtTypeMemberWildcardImportReference ctTypeMemberWildcardImportReference) {
        builder.append("visitCtTypeMemberWildcardImportReference");
        builder.newline();
    }

    @Override
    public void visitCtYieldStatement(CtYieldStatement ctYieldStatement) {
        builder.append("visitCtYieldStatement");
        builder.newline();
    }

    @Override
    public void visitCtTypePattern(CtTypePattern ctTypePattern) {
        builder.append("visitCtTypePattern");
        builder.newline();
    }

    @Override
    public void visitCtRecord(CtRecord ctRecord) {
        builder.append("visitCtRecord");
        builder.newline();
    }

    @Override
    public void visitCtRecordComponent(CtRecordComponent ctRecordComponent) {
        builder.append("visitCtRecordComponent");
        builder.newline();
    }
}
