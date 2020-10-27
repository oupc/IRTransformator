package node;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Statement;

/**
 * @ClassName IRClassInstance
 * @Description TODO
 * @Version 1.0
 * @Author locy
 * @Date 2020/10/19 22:44
 **/
public class IRClassInstance extends IRExpression{
    public IRClassInstance(ASTNode node) {
        super(node);
    }
}
