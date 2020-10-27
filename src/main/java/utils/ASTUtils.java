package utils;

import com.sun.org.apache.xalan.internal.lib.ExsltBase;
import node.*;
import org.eclipse.jdt.core.IRegion;
import org.eclipse.jdt.core.dom.*;

import javax.lang.model.type.ReferenceType;

public class ASTUtils {

    /**
     * return variable
     * @param expression
     * @return
     */
    public static Variable getVariable(Expression expression) {
        if(expression instanceof SimpleName){
            return new Variable(((SimpleName) expression).getIdentifier(),((SimpleName) expression).resolveBinding());
        }else if(expression instanceof MethodInvocation){
            return new Variable(((MethodInvocation) expression).getName().getIdentifier(),expression.resolveTypeBinding());
        }
        return null;
    }

    public static IRExpression getRight(Expression initializer) {
        if(initializer instanceof MethodInvocation){
            MethodInvocation methodInvocation = (MethodInvocation) initializer;
            IRExpression irExpression = getRight(methodInvocation.getExpression());
            Function function = Config.getCurrentFunction();
            IRExpression expression = function.newExpression();
            IRMethodInvocation irMethodInvocation = new IRMethodInvocation(methodInvocation.getName(),irExpression);
            return expression.getLeftVariable();
        }

        if(initializer instanceof ClassInstanceCreation){
            return new IRClassInstance(initializer);
        }

        if(initializer instanceof SimpleName){
            return new Variable((SimpleName) initializer);
        }
        return null;
    }

    /**
     *
     * @param expression
     * @param function
     * @return return new variable
     */
    public Variable infixExpressionResolve(InfixExpression expression, Function function){
        Variable variable = new Variable(function.count++);
        variable.getExpression().setLeftVariable(infixExpressionResolve(expression.getLeftOperand(),function));
//        variable.getExpression().setRightVariable(infixExpressionResolve(expression.getRightOperand(),function));
        variable.getExpression().setOperator(expression.getOperator());
        return variable;
    }

    public Variable infixExpressionResolve(SimpleName simpleName,Function function){
        return new Variable(simpleName.getIdentifier(),simpleName.resolveTypeBinding());
    }

    public Variable infixExpressionResolve(Expression expression,Function function){
        return infixExpressionResolve(expression,function);
    }





}
