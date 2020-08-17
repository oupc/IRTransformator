package node;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.jdt.core.dom.ITypeBinding;

@Getter
@Setter
public class Variable {
    public String name;
    public ITypeBinding typeBinding;
    public int Id;
    public boolean virtual;
}
