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


public class BasicJson {

	@SuppressWarnings("unused")
	private static ArrayList<JSONObject> bigObjList = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		JSONArray value = new JSONArray();
		
	      JSONObject obj = new JSONObject();

	      ArrayList<String> nameList = new ArrayList<>();
	      HashMap<String, JSONArray> skillList = new HashMap<>();
	      
	      nameList.add("Peter");
	      nameList.add("Hycklare");
	      
	      JSONArray list1 = new JSONArray();
//	      list1.add("skill 1");
//	      list1.add("skill 2");
//	      list1.add("skill 3");
	      
	      skillList.put("Peter", list1);
	      
	      JSONArray list2 = new JSONArray();
	      list2.add("skill 4");
	      list2.add("skill 42");
	      
	      skillList.put("Hycklare", list2);
	      
	      JSONArray testSkillList = new JSONArray();

	      for(String name : nameList) {
	    	  obj = new JSONObject();
	    	  testSkillList = skillList.get(name);
	    	  obj.put("name", name);
	    	  obj.put("raud", 0);
	    	  obj.put("skill", testSkillList);
	    	  obj.put("health", 42);
	    	  obj.put("stamina", 0);
	    	  obj.put("intelligence", 0);
	    	  obj.put("charisma", 0);
	    	  obj.put("perception", 0);
	    	  obj.put("willpower", 0);
	    	  obj.put("agility", 0);
	    	  obj.put("strength", 0);


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
