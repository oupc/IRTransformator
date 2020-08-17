package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Properties implements PropertiesKey{
    private static Map<String,Object> map = new HashMap<>();

    public void Init(){
        map.put(JAVAFILES,new ArrayList<>());
        map.put(JARFILES,new ArrayList<>());
        map.put(COMPILATIONUNITS,new HashMap<>());
    }

    public static Object getProperty(String string){
        if(map.containsKey(string)){
            return map.get(string);
        }
        return null;
    }

    public static List getPropertyList(String string){
        return (List)(getProperty(string));
    }

    public static void setProperty(String name,Object object){
        map.put(name,object);
    }


}
