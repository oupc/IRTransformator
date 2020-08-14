package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

public class ReadLine {
    public static final Logger LOG = LoggerFactory.getLogger(ReadLine.class);

    public static void readLine(String[] strings){
        new Config().Init();
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]){
                case "-path":
                    String path = strings[++i];
                    Config.setProperty(PropertiesKey.PROJECT_PATH,path);
                    break;
                default:
                    LOG.error("参数错误，退出");
                    System.exit(0);
                    break;
            }
        }
        ReadFile.readFile();
    }
}
