package node;

import org.eclipse.jdt.core.dom.*;

/**
 * @ClassName IRMethodInvocation
 * @Description TODO
 * @Version 1.0
 * @Author locy
 * @Date 2020/10/19 22:43
 **/
public class IRMethodInvocation extends IRExpression {

    public Variable name;
    public IRExpression expression;

    public IRMethodInvocation(ASTNode node) {
        super(node);
    }

    public IRMethodInvocation(SimpleName simpleName, IRExpression irExpression){
        super((Variable) null);
        name = new Variable(simpleName);
        expression = irExpression;
    }

}
