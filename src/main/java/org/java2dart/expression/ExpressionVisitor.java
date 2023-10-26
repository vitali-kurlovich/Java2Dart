package org.java2dart.expression;

import org.java2dart.expression.builder.IExpressionBuilder;
import org.java2dart.logging.Logging;
import spoon.reflect.code.*;
import spoon.reflect.declaration.*;
import spoon.reflect.reference.*;

import java.lang.annotation.Annotation;


public class ExpressionVisitor extends BaseExpressionVisitor {




    public ExpressionVisitor(IExpressionBuilder buider) {
        super(buider);
    }

    @Override
    public <T> void visitCtThisAccess(CtThisAccess<T> thisAccess) {
        // Logging.info("visitCtThisAccess");
        builder.thisAccess();
        //print("this");

    }

    @Override
    public <T> void visitCtSuperAccess(CtSuperAccess<T> f) {
        builder.superAccess();
    }

    @Override
    public <T> void visitCtFieldRead(CtFieldRead<T> fieldRead) {

    }

    @Override
    public <T> void visitCtFieldWrite(CtFieldWrite<T> fieldWrite) {
        //Logging.info("visitCtFieldWrite");


        fieldWrite.getTarget().accept(this);

        final var name = fieldWrite.getVariable().getSimpleName();

        print("." + name);

    }







    @Override
    public <T, A extends T> void visitCtAssignment(CtAssignment<T, A> assignement) {
        //  Logging.info("visitCtAssignment");

        final var assigned = assignement.getAssigned();

        assigned.accept(this);

        print(" = ");

        final var exp = assignement.getAssignment();
        exp.accept(this);

        print(";\n");

    }


    @Override
    public <T> void visitCtArrayRead(CtArrayRead<T> arrayRead) {

    }

    @Override
    public <T> void visitCtArrayWrite(CtArrayWrite<T> arrayWrite) {

    }

    @Override
    public <T> void visitCtArrayTypeReference(CtArrayTypeReference<T> reference) {

    }

    @Override
    public <T> void visitCtAssert(CtAssert<T> asserted) {

    }



    @Override
    public <T> void visitCtBinaryOperator(CtBinaryOperator<T> operator) {
        //Logging.info("visitCtBinaryOperator");
        operator.getLeftHandOperand().accept(this);


        switch (operator.getKind()) {

            case OR -> {
                print(" || ");
            }
            case AND -> {
                print(" && ");
            }
            case BITOR -> {
            }
            case BITXOR -> {
            }
            case BITAND -> {
            }
            case EQ -> {
            }
            case NE -> {
            }
            case LT -> {
            }
            case GT -> {
            }
            case LE -> {
            }
            case GE -> {
            }
            case SL -> {
            }
            case SR -> {
            }
            case USR -> {
            }
            case PLUS -> {
                print(" + ");
            }
            case MINUS -> {
                print(" - ");
            }
            case MUL -> {
                print(" * ");
            }
            case DIV -> {
                print(" / ");
            }
            case MOD -> {
                print(" % ");
            }
            case INSTANCEOF -> {
            }
        }

        operator.getRightHandOperand().accept(this);


    }

    @Override
    public <R> void visitCtBlock(CtBlock<R> block) {

    }

    @Override
    public void visitCtBreak(CtBreak breakStatement) {

    }

    @Override
    public <S> void visitCtCase(CtCase<S> caseStatement) {

    }

    @Override
    public void visitCtCatch(CtCatch catchBlock) {

    }



    @Override
    public <T> void visitCtConditional(CtConditional<T> conditional) {

    }

    @Override
    public <T> void visitCtConstructor(CtConstructor<T> c) {

    }

    @Override
    public void visitCtContinue(CtContinue continueStatement) {

    }

    @Override
    public void visitCtDo(CtDo doLoop) {

    }


    @Override
    public <T> void visitCtEnumValue(CtEnumValue<T> enumValue) {

    }



    @Override
    public <T> void visitCtFieldReference(CtFieldReference<T> reference) {

    }

    @Override
    public <T> void visitCtUnboundVariableReference(CtUnboundVariableReference<T> reference) {

    }

    @Override
    public void visitCtFor(CtFor forLoop) {

    }

    @Override
    public void visitCtForEach(CtForEach foreach) {

    }

    @Override
    public void visitCtIf(CtIf ifElement) {

    }



    @Override
    public <T> void visitCtInvocation(CtInvocation<T> invocation) {

    }

//    @Override
//    public <T> void visitCtLiteral(CtLiteral<T> literal) {
//        final var value =  literal.getValue();
//    }

    @Override
    public <T> void visitCtLiteral(CtLiteral<T> literal) {

        if (literal.getValue() == null) {
            print("null");
        }

        if (literal.getValue() instanceof Integer) {
            final Integer value = (Integer) literal.getValue();
            print(String.valueOf(value));
        }

        if (literal.getValue() instanceof String) {
            final String value = (String) literal.getValue();
            print("\"" + value + "\"" );
        }


    }



    @Override
    public void visitCtTextBlock(CtTextBlock ctTextBlock) {

    }

    @Override
    public <T> void visitCtLocalVariable(CtLocalVariable<T> localVariable) {

        final var name = localVariable.getSimpleName();

        print("var " + name);

        final var expr = localVariable.getDefaultExpression();
        if (expr != null) {
            print(" = ");
            expr.accept(this);
        }


        print(";\n");

        //localVariable.getAssignment().accept(this);

    }

    @Override
    public <T> void visitCtLocalVariableReference(CtLocalVariableReference<T> reference) {

    }

    @Override
    public <T> void visitCtCatchVariable(CtCatchVariable<T> catchVariable) {

    }

    @Override
    public <T> void visitCtCatchVariableReference(CtCatchVariableReference<T> reference) {

    }


    @Override
    public <T> void visitCtNewArray(CtNewArray<T> newArray) {

    }

    @Override
    public <T> void visitCtConstructorCall(CtConstructorCall<T> ctConstructorCall) {

    }

    @Override
    public <T> void visitCtNewClass(CtNewClass<T> newClass) {

    }

    @Override
    public <T> void visitCtLambda(CtLambda<T> lambda) {

    }

    @Override
    public <T, E extends CtExpression<?>> void visitCtExecutableReferenceExpression(CtExecutableReferenceExpression<T, E> expression) {

    }

    @Override
    public <T, A extends T> void visitCtOperatorAssignment(CtOperatorAssignment<T, A> assignment) {

    }




    @Override
    public <R> void visitCtReturn(CtReturn<R> returnStatement) {

    }



    @Override
    public <S> void visitCtSwitch(CtSwitch<S> switchStatement) {

    }

    @Override
    public <T, S> void visitCtSwitchExpression(CtSwitchExpression<T, S> switchExpression) {

    }

    @Override
    public void visitCtSynchronized(CtSynchronized synchro) {

    }

    @Override
    public void visitCtThrow(CtThrow throwStatement) {

    }

    @Override
    public void visitCtTry(CtTry tryBlock) {

    }

    @Override
    public void visitCtTryWithResource(CtTryWithResource tryWithResource) {

    }

    @Override
    public <T> void visitCtTypeReference(CtTypeReference<T> reference) {

    }

    @Override
    public <T> void visitCtTypeAccess(CtTypeAccess<T> typeAccess) {

    }

    @Override
    public <T> void visitCtUnaryOperator(CtUnaryOperator<T> operator) {

    }

    @Override
    public <T> void visitCtVariableRead(CtVariableRead<T> variableRead) {

        final var name = variableRead.getVariable().getSimpleName();
        print(name);

    }

    @Override
    public <T> void visitCtVariableWrite(CtVariableWrite<T> variableWrite) {
       // Logging.info("visitCtVariableWrite");

        //  variableWrite.
    }

    @Override
    public void visitCtWhile(CtWhile whileLoop) {

    }




    @Override
    public void visitCtComment(CtComment comment) {

    }

    @Override
    public void visitCtJavaDoc(CtJavaDoc comment) {

    }

    @Override
    public void visitCtJavaDocTag(CtJavaDocTag docTag) {

    }





    @Override
    public void visitCtPackageDeclaration(CtPackageDeclaration packageDeclaration) {

    }

    @Override
    public void visitCtTypeMemberWildcardImportReference(CtTypeMemberWildcardImportReference wildcardReference) {

    }

    @Override
    public void visitCtYieldStatement(CtYieldStatement statement) {

    }

    @Override
    public void visitCtTypePattern(CtTypePattern pattern) {

    }

    @Override
    public void visitCtRecord(CtRecord recordType) {

    }

    @Override
    public void visitCtRecordComponent(CtRecordComponent recordComponent) {

    }


    private void print(String msg) {
        System.out.print(msg);
    }
}
