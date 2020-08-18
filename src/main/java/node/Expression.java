package node;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expression extends Statement{
    Operator operator;
    Variable leftVariable;
    Variable rightVariable;

}
