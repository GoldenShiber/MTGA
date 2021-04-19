package Utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import characterEssentials.TrudvangCharacter;
import status.CharacterList;

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
	public static void saveCharacterList(List<TrudvangCharacter> characterList, String saveFileName) {
		JSONArray characters = new JSONArray();
	    for(TrudvangCharacter character  : characterList) {
	    	JSONArray skillList = new JSONArray();
	    	for(String skill : character.getSkillList()) {
	    		skillList.add(skill);
	    	}
	    	JSONObject saveCharacter = new JSONObject();
	    	for(String key : character.getStatMap().keySet()) {
	    		saveCharacter.put(key, character.getStatMap().get(key));
	    	}
	    	saveCharacter.put("skill", skillList);
	    	saveCharacter.put("name", character.getName());
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
	
	@SuppressWarnings("unchecked")
	public static void importJSONFile(String jsonPath) {
		JSONParser parser = new JSONParser();

        // Better taste in progress soon.
//        try (Reader reader = new FileReader("/home/goldenshiber/MTGA/Combat_System/Combat_System_Basics/test.json")) {
//            Object obj = parser.parse(new FileReader("/home/goldenshiber/MTGA/Combat_System/Combat_System_Basics/test.json"));
        try (Reader reader = new FileReader(jsonPath)) {
            Object obj = parser.parse(new FileReader(jsonPath));
         // convert object to JSONArray
         JSONArray jsonArray = (JSONArray ) obj;
         
         CharacterList.getInstance().cleanse();
         
         // loop array
            jsonArray.forEach(item -> {
            	TrudvangCharacter newCharacter = new TrudvangCharacter();
            	JSONObject newObject = (JSONObject) item;
            	
            	Map<String, Integer> statMap = new HashMap<String, Integer>();
            	newCharacter.setName((String) newObject.get("name").toString());
            	statMap.put("health", Integer.parseInt(newObject.get("health").toString()));
            	statMap.put("raud", Integer.parseInt(newObject.get("raud").toString()));
            	statMap.put("stamina", Integer.parseInt(newObject.get("stamina").toString()));
            	statMap.put("intelligence", Integer.parseInt(newObject.get("intelligence").toString()));
            	statMap.put("charisma", Integer.parseInt(newObject.get("charisma").toString()));
            	statMap.put("perception", Integer.parseInt(newObject.get("perception").toString()));
            	statMap.put("intelligence", Integer.parseInt(newObject.get("intelligence").toString()));
            	statMap.put("charisma", Integer.parseInt(newObject.get("charisma").toString()));
            	statMap.put("willpower", Integer.parseInt(newObject.get("willpower").toString()));
            	statMap.put("intelligence", Integer.parseInt(newObject.get("intelligence").toString()));
            	statMap.put("agility", Integer.parseInt(newObject.get("agility").toString()));
            	statMap.put("strength", Integer.parseInt(newObject.get("strength").toString()));
            	newCharacter.setStatMap(statMap);
            	ArrayList<String> characterSkillList = new ArrayList<>();
                JSONArray skillList = (JSONArray) newObject.get("skill");
                Iterator<String> iterator = skillList.iterator();
                while (iterator.hasNext()) {
                	characterSkillList.add(iterator.next());
                }
                // Add the created/existing character to a character list
                newCharacter.setSkillList(characterSkillList);
//                characterList.add(newCharacter);
                CharacterList.getInstance().addCharacter(newCharacter);
                
            });
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	    
}

