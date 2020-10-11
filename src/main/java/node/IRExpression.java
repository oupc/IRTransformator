package node;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.jdt.core.dom.InfixExpression;

@Getter
@Setter
public class IRExpression extends IRStatement{
    IROperator operator;
    Variable leftVariable;
    Variable rightVariable;

    public void setOperator(InfixExpression.Operator operator) {
        this.operator = new IROperator(operator);
    }
}
