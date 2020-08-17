package node;

import lombok.Getter;
import org.eclipse.jdt.core.dom.ASTNode;

@Getter
public class Node {
    public int line;
    public int endLine;
    public int column;
    public int endColumn;
    public ASTNode node;
}
