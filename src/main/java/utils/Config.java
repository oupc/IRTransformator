package utils;

import lombok.Getter;
import lombok.Setter;
import node.FileNode;
import node.Function;

import java.io.File;

public class Config extends Properties {

    @Getter
    @Setter
    private static Function currentFunction;


    @Override
    public void Init() {
        super.Init();
    }

    public static void addFile(File file, String string) {
        switch (string){
            case "java":
                getPropertyList(JAVAFILES).add(new FileNode(file.getName(),file.getAbsolutePath()));
                break;
            case "jar":
                getPropertyList(JARFILES).add(new FileNode(file.getName(),file.getAbsolutePath()));
                break;
            default:
                break;
        }
    }
}
