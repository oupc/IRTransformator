package node;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expression {
    Operator operator;
    Variable leftVariable;
    Variable rightVariable;

}
