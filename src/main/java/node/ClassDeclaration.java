package node;

import lombok.Getter;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.List;

@Getter
public class ClassDeclaration {
    public List<Function> functions;
    public String name;
    public CompilationUnit compilationUnit;
    public ClassDeclaration(){};

    public ClassDeclaration(String name) {
        this.name = name;
    }

    public ClassDeclaration(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }
}
