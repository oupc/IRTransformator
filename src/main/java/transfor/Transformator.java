package transfor;

import node.ClassDeclaration;
import node.Function;
import node.IRStatement;
import org.eclipse.jdt.core.dom.*;
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
