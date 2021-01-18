package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.character.TrudvangCharacter;

public class JSONUtilities {

	public static String listToJSONText(ArrayList<String> textList) {
		String testString = "";
		 for(int i = 0; i< textList.size(); i++) {
   		  if(i == textList.size() -1) {
   			  testString = testString + textList.get(i);
   		  }
   		  else {
   			  testString = testString + textList.get(i) + ", ";
   		  }
   	  }
		 return testString;
	}
	
	public static ArrayList<String> parseMultiList(String stringList){
		ArrayList<String> newStringList = new ArrayList<String>();
		String[] splitList = stringList.split(",");
		for(String text : splitList) {
			newStringList.add(text.trim());
		}
		return newStringList;
	}
	
	@SuppressWarnings("unchecked")
	public static void saveCharacterList(ArrayList<TrudvangCharacter> characterList, String saveFileName) {
		JSONArray characters = new JSONArray();
	    for(TrudvangCharacter character  : characterList) {
	    	JSONArray skillList = new JSONArray();
	    	for(String skill : character.skillList) {
	    		skillList.add(skill);
	    	}
	    	JSONObject saveCharacter = new JSONObject();
	    	for(String key : character.statMap.keySet()) {
	    		saveCharacter.put(key, character.statMap.get(key));
	    	}
	    	saveCharacter.put("skill", skillList);
	    	saveCharacter.put("name", character.name);
	    	characters.add(saveCharacter);
	    }
	    
	  //Write JSON file
        try (FileWriter file = new FileWriter(saveFileName)) {
 
            file.write(characters.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
      
	}
	    
	}

