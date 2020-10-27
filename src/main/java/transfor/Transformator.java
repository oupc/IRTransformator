package transfor;

import node.*;
import org.eclipse.jdt.core.dom.*;
import utils.ASTUtils;
import utils.Config;
import utils.PropertiesKey;

import java.util.Stack;

public class Transformator {
    public static void trans(){
        Config.getPropertyList(PropertiesKey.COMPILATIONUNITS).forEach(value->{
            if(value instanceof CompilationUnit){
                CompilationUnit compilationUnit = (CompilationUnit) value;
                ClassDeclaration classDeclaration = new ClassDeclaration(compilationUnit);

                compilationUnit.accept(new ASTVisitor() {
                    Function currentFunction;
                    IRStatement irStatement;
                    @Override
                    public boolean visit(MethodDeclaration node) {
                        Function function = new Function(node.getName().getIdentifier(),node.parameters(),classDeclaration, node.modifiers(),null,node);
                        classDeclaration.functions.add(function);
                        currentFunction = function;
                        return true;
                    }

                    @Override
                    public boolean visit(VariableDeclarationFragment node) {
                        IRExpression irExpression = new IRExpression((Statement) node.getParent());
                        irExpression.setLeftVariable(new Variable(node.getName().getIdentifier(),node.resolveBinding()));
                        irExpression.setExpression(ASTUtils.getRight(node.getInitializer()));
                        return false;
                    }

                    @Override
                    public boolean visit(Assignment node) {
                        Variable variable = ASTUtils.getVariable(node.getLeftHandSide());
                        return super.visit(node);


                    }

                    @Override
                    public boolean visit(WhileStatement node) {
                        irStatement = null;
                        return super.visit(node);
                    }

                    @Override
                    public void endVisit(WhileStatement node) {
//                        irStatement.getLabel()
                        super.endVisit(node);
                    }
                });
            }
        });
    }
}
