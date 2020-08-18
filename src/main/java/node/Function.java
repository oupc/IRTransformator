package node;

import lombok.Getter;

import java.util.List;

@Getter
public class Function {
    public String name;
    public List<Variable> parameters;
    public ClassDeclaration classDeclaration;
    public List<Statement> statements;
    public List<String> modifiers;
    public String returnType;

}
