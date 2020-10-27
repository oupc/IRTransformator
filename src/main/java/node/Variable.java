package node;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.jdt.core.dom.*;
import sun.text.normalizer.NormalizerBase;

@Getter
@Setter
public class Variable extends IRExpression {
    public String name;
    public IBinding typeBinding;
    public int id;
    public boolean virtual;
    public IRExpression expression;


    public Variable(int id) {
        super(null);
        this.id = id;
        this.virtual = true;
        this.name = "t"+id;
    }

    public Variable(){
        super(null);
    };

    public Variable(String name,IBinding iTypeBinding){
        super(null);
        this.name = name;
        this.typeBinding = iTypeBinding;
    }

    public Variable(SimpleName simpleName){
        this(simpleName.getIdentifier(),simpleName.resolveBinding());
    }

}
