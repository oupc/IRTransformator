package node;

import com.sun.xml.internal.ws.server.provider.ProviderInvokerTube;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import java.beans.MethodDescriptor;
import java.util.List;

/**
 *  count : variable count
 */
@Getter
@Setter
public class Function {
    public String name;
    public List<Variable> parameters;
    public int count = 0;
    public ClassDeclaration classDeclaration;
    public List<IRStatement> statements;
    public List<String> modifiers;
    public String returnType;
    public MethodDeclaration methodDeclaration;

    public Function(String name, List<Variable> parameters, ClassDeclaration classDeclaration, List<String> modifiers, String returnType) {
        this.name = name;
        this.parameters = parameters;
        this.classDeclaration = classDeclaration;
        this.modifiers = modifiers;
        this.returnType = returnType;
    }

    public Function(String name, List<Variable> parameters, ClassDeclaration classDeclaration, List<String> modifiers, String returnType, MethodDeclaration methodDeclaration) {
        this.name = name;
        this.parameters = parameters;
        this.classDeclaration = classDeclaration;
        this.modifiers = modifiers;
        this.returnType = returnType;
        this.methodDeclaration = methodDeclaration;
    }

    public Function(){};

    public Function(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
    }

    public Variable newVarable(){
        return new Variable(count++);
    }

    public IRExpression newExpression(){
        IRExpression irExpression = new IRExpression(new Variable());
        statements.add(irExpression);
        return irExpression;
    }

}
