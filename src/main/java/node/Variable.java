package node;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ITypeBinding;
import sun.text.normalizer.NormalizerBase;

@Getter
@Setter
public class Variable {
    public String name;
    public ITypeBinding typeBinding;
    public int id;
    public boolean virtual;
    public IRExpression expression;


    public Variable(int id) {
        this.id = id;
        this.virtual = true;
        this.name = "t"+id;
    }

    public Variable(){};

    public Variable(String name,ITypeBinding iTypeBinding){
        this.name = name;
        this.typeBinding = iTypeBinding;
    }

}
