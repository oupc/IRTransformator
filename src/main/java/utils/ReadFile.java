package utils;

import com.sun.xml.internal.ws.encoding.ContentTypeImpl;

import java.io.File;

public class ReadFile {

    public static void readFile(){
        recordFiles(new File((String) Config.getProperty(PropertiesKey.PROJECT_PATH)));
    }

    public static void recordFiles(File file){
        if(file.isDirectory()){
            for (File listFile : file.listFiles()) {
                if(listFile.getName().endsWith("target")){
                    continue;
                }
                recordFiles(listFile);
            }
        }
        if(file.isFile()){
            Config.addFile(file,getFileEnd(file.getName()));
        }
    }

    public static String getFileEnd(String string){
        int index = string.indexOf(".");
        if(index != -1){
            return string.substring(index+1);
        }
        return "";
    }

}
