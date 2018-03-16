package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.*;

public class GetProperties {
    private static String configFilePath = "src/main/java/config/config.json";
    public static HashMap<String,String> configItems;

    public static void GetProperties(){getConfigItems();}

    private static void getConfigItems(){
        configItems = new HashMap<String,String>();
        try{
            FileReader configReader = new FileReader(configFilePath);
            BufferedReader bufferedReader = new BufferedReader(configReader);
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line = null;
            while((line = bufferedReader.readLine())!=null){
                jsonStringBuilder.append(line);
            }
            String jsonString = jsonStringBuilder.toString();
            JSONObject configJSONReader = new JSONObject(jsonString.trim());
            Iterator<String> keys = configJSONReader.keys();

            while(keys.hasNext()){
                String key = (String)keys.next();
                configItems.put(key, (String) configJSONReader.get(key));
            }
        }catch (FileNotFoundException fn){
            fn.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

