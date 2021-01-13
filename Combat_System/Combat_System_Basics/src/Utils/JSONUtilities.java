package Utils;

import java.util.ArrayList;

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
}
