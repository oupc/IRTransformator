package JDT;

import node.FileNode;
import org.apache.logging.log4j.util.Strings;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FileASTRequestor;
import utils.Config;
import utils.PropertiesKey;

import java.util.List;
import java.util.Map;

public class Parser {

    public static void parser(){
        ASTParser astParser = ASTParser.newParser(AST.JLS10);
        List<FileNode> list = Config.getPropertyList(PropertiesKey.JAVAFILES);
        String[] strings = new String[list.size()];
        String[] encodings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i).file;
            encodings[i] = "utf-8";
        }
        astParser.createASTs( strings, encodings, new String[list.size()], new FileASTRequestor() {
            @Override
            public void acceptAST(String sourceFilePath, CompilationUnit ast) {
                Map<String,CompilationUnit> map = (Map<String, CompilationUnit>) Config.getProperty(PropertiesKey.COMPILATIONUNITS);
                map.put(sourceFilePath,ast);
            }
        }, null);
//        Config.PROPERTIES.getProperty(PropertiesKey.PROJECT_NAME);
    }

}
