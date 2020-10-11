package utils;

import node.Function;
import node.IROperator;
import node.Variable;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.SimpleName;

import javax.lang.model.type.ReferenceType;

public class ASTUtils {

    /**
     *
     * @param expression
     * @param function
     * @return return new variable
     */
    public Variable infixExpressionResolve(InfixExpression expression, Function function){
        Variable variable = new Variable(function.count++);
        variable.getExpression().setLeftVariable(infixExpressionResolve(expression.getLeftOperand(),function));
        variable.getExpression().setRightVariable(infixExpressionResolve(expression.getRightOperand(),function));
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
