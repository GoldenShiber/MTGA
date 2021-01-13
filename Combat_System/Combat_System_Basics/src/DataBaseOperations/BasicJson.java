package DataBaseOperations;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/*
 *  For future implementations the combat system will receive data from a database
 *  and a JSON database is most likely very easy to use in this case.
 */

import Utils.JSONUtilities;

public class BasicJson {

	@SuppressWarnings("unused")
	private static ArrayList<JSONObject> bigObjList = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		JSONArray value = new JSONArray();
		
	      JSONObject obj = new JSONObject();

	      ArrayList<String> nameList = new ArrayList<>();
	      HashMap<String, ArrayList<String>> skillList = new HashMap<>();
	      
	      nameList.add("Peter");
	      nameList.add("Hycklare");
	      
	      ArrayList<String> testList = new ArrayList<>();
	      testList.add("skill 1");
	      testList.add("skill 2");
	      testList.add("skill 3");
	      
	      skillList.put("Peter", testList);
	      
	      ArrayList<String> testList2 = new ArrayList<>();
	      testList2.add("skill 4");
	      testList2.add("skill 42");
	      
	      skillList.put("Hycklare", testList2);
	      
	      ArrayList<String> testSkillList = new ArrayList<>();

	      for(String name : nameList) {
	    	  obj = new JSONObject();
	    	  testSkillList = skillList.get(name);
	    	  obj.put("name", name);
	    	  obj.put("skill", JSONUtilities.listToJSONText(testSkillList));
	    	  value.add(obj);
	      }
	      
	    //Write JSON file
	        try (FileWriter file = new FileWriter("test.json")) {
	 
	            file.write(value.toJSONString());
	            file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	      
	   }
	
	
}
