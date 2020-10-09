package transfor;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.WhileStatement;
import utils.Config;
import utils.PropertiesKey;

public class Transformator {
    public static void trans(){
        Config.getPropertyList(PropertiesKey.COMPILATIONUNITS).forEach(value->{
            if(value instanceof CompilationUnit){
                CompilationUnit compilationUnit = (CompilationUnit) value;
                compilationUnit.accept(new ASTVisitor() {
                    @Override
                    public boolean visit(WhileStatement node) {
                        return super.visit(node);
                    }

                });
            }
        });
    }
}
