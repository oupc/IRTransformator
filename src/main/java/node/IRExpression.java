package node;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.jdt.core.dom.*;
import utils.ASTUtils;

@Getter
@Setter
public class IRExpression extends IRStatement{
    IROperator operator;
    Variable leftVariable;
    IRExpression expression;
    ASTNode statement;


    public IRExpression(ASTNode node) {
        this.statement = node;
    }

    public void setOperator(InfixExpression.Operator operator) {
        this.operator = new IROperator(operator);
    }

    public IRExpression(Variable variable){
        super();
        leftVariable = variable;
    }

    public IRExpression newIRExpression(Variable variable){
        return new IRExpression(variable);
    }
}
