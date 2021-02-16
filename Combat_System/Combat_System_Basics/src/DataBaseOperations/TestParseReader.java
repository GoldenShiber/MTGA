package DataBaseOperations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Utils.JSONUtilities;
import main.character.TrudvangCharacter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class TestParseReader {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        // Better taste in progress soon.
        try (Reader reader = new FileReader("/home/goldenshiber/MTGA/Combat_System/Combat_System_Basics/test.json")) {
            Object obj = parser.parse(new FileReader("/home/goldenshiber/MTGA/Combat_System/Combat_System_Basics/test.json"));

         // convert object to JSONArray
         JSONArray jsonArray = (JSONArray ) obj;
         ArrayList<TrudvangCharacter> characterList = new ArrayList<>();
         // loop array
            jsonArray.forEach(item -> {
            	TrudvangCharacter newCharacter = new TrudvangCharacter();
            	JSONObject newObject = (JSONObject) item;
            	newCharacter.name = (String) newObject.get("name").toString();
            	newCharacter.statMap.put("health", Integer.parseInt(newObject.get("health").toString()));
            	newCharacter.statMap.put("raud", Integer.parseInt(newObject.get("raud").toString()));
            	newCharacter.statMap.put("stamina", Integer.parseInt(newObject.get("stamina").toString()));
            	newCharacter.statMap.put("intelligence", Integer.parseInt(newObject.get("intelligence").toString()));
            	newCharacter.statMap.put("charisma", Integer.parseInt(newObject.get("charisma").toString()));
            	newCharacter.statMap.put("perception", Integer.parseInt(newObject.get("perception").toString()));
            	newCharacter.statMap.put("intelligence", Integer.parseInt(newObject.get("intelligence").toString()));
            	newCharacter.statMap.put("charisma", Integer.parseInt(newObject.get("charisma").toString()));
            	newCharacter.statMap.put("willpower", Integer.parseInt(newObject.get("willpower").toString()));
            	newCharacter.statMap.put("intelligence", Integer.parseInt(newObject.get("intelligence").toString()));
            	newCharacter.statMap.put("agility", Integer.parseInt(newObject.get("agility").toString()));
            	newCharacter.statMap.put("strength", Integer.parseInt(newObject.get("strength").toString()));
            	ArrayList<String> characterSkillList = new ArrayList<>();
                JSONArray skillList = (JSONArray) newObject.get("skill");
                Iterator<String> iterator = skillList.iterator();
                while (iterator.hasNext()) {
                	characterSkillList.add(iterator.next());
                }
                // Add the created/existing character to a character list
                newCharacter.skillList = characterSkillList;
                characterList.add(newCharacter);
            });

            JSONUtilities.saveCharacterList(characterList, "newTEst.json");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        

    }
	
}
