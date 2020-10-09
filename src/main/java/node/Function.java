package node;

import lombok.Getter;

import java.util.List;

/**
 *  count : variable count
 */
@Getter
public class Function {
    public String name;
    public List<Variable> parameters;
    public int count = 0;
    public ClassDeclaration classDeclaration;
    public List<Statement> statements;
    public List<String> modifiers;
    public String returnType;
}
