package utils;

import node.FileNode;

import java.io.File;
import java.util.List;

public class Config extends Properties {

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
