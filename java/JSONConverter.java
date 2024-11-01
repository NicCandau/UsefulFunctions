import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class JSONConverter {
    public static JSONArray convertJSON(){
        try{
            // Read JSON file into String variable
            String JSONfileString = Files.readString(Path.of("<path_string>"));
            
            JSONParser parser = new JSONParser();   
            
            try{
                // Parse JSON String into Java Object
                Object obj = parser.parse(JSONfileString);

                // Cast to JSON Array.
                // array[0] = the first element
                // Use 'array.get["<key>"]' to get specific values.
                JSONArray array = (JSONArray)obj;
                return array;
            }
            catch(ParseException e)
            {
                return null;
            }
        }
        catch(IOException e)
        {
            return null;
        }
    }
}
