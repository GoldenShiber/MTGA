package main.character;

import java.util.ArrayList;
import java.util.HashMap;

import stats.CombatAbilites;

/*
 * The base of a character is their id(name), health, initiative and raud.
 * In the prototype, the initiative modifiers are hard coded, 
 * however when it is working as a simple prototype, general methods
 * are supposed to be used to simplify actions.
 */

public class TrudvangCharacter {
	public String name;
	public CombatAbilites combatSkills;
	public HashMap<String, Integer> statMap;
	public ArrayList<String> skillList;
	
	public TrudvangCharacter() {
		statMap = new HashMap<>();
		skillList = new ArrayList<>();
		this.name = "";
		statMap.put("health", 0);
		statMap.put("initiative", 0);
		statMap.put("initiativeModifier", 0);
		statMap.put("raud", 0);
		this.combatSkills = new CombatAbilites(new HashMap<String, Integer>());
	}
	
	public TrudvangCharacter(String name, HashMap<String, Integer> combatSet) {
		statMap = new HashMap<>();
		skillList = new ArrayList<>();
		statMap.put("initiative", 0);
		statMap.put("initiativeModifier", 0);
		this.name = name;
		this.combatSkills = new CombatAbilites(combatSet);
	}

	
}
