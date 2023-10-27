package org.java2dart.factory;

import org.java2dart.expression.ExpressionBuilderFactory;
import org.java2dart.factory.schema.ast.ASTSchemaFactory;
import org.java2dart.factory.schema.ast.ASTSchemaFieldFactory;
import org.java2dart.factory.schema.ast.ASTSchemaMethodFactory;
import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.factory.variable.ASTVariableFactory;

public class ASTFactories {

    public final ASTTypeDescriptionFactory typeDescriptionFactory ;//= new ASTTypeDescriptionFactory();
    public final ASTVariableFactory variableFactory ;
    public final ASTSchemaFieldFactory  schemaFieldFactory;
    public final ASTSchemaMethodFactory schemaMethodFactory;

    public  final ASTSchemaFactory schemaFactory;
    public final ExpressionBuilderFactory expressionBuilderFactory;


   public ASTFactories() {
       final var typeDescription = new ASTTypeDescriptionFactory();
       final var schemaFieldFactory = new ASTSchemaFieldFactory(typeDescription);

       final var builderFactory = new ExpressionBuilderFactory();

       final var  schemaMethodFactory = new ASTSchemaMethodFactory(typeDescription, builderFactory);




       this.typeDescriptionFactory = typeDescription;
       this.variableFactory = schemaFieldFactory;
       this.schemaFieldFactory  = schemaFieldFactory;
       this.schemaMethodFactory = schemaMethodFactory;

       this.schemaFactory = new ASTSchemaFactory(typeDescription, schemaFieldFactory, schemaMethodFactory );

       this.expressionBuilderFactory = builderFactory;

   }



}
