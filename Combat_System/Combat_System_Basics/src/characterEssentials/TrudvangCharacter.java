package characterEssentials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maps.CombatConverter;
import stats.CombatAbilites;

/*
 * The base of a character is their id(name), health, initiative and raud.
 * In the prototype, the initiative modifiers are hard coded, 
 * however when it is working as a simple prototype, general methods
 * are supposed to be used to simplify actions.
 */

public class TrudvangCharacter {
	private String name;
	private CombatAbilites combatSkills;
	private Map<String, Integer> statMap;
	private List<String> skillList;
	
	public TrudvangCharacter() {
		statMap = new HashMap<>();
		skillList = new ArrayList<>();
		this.name = "";
		statMap.put("health", 0);
		statMap.put("stamina", 0);
		statMap.put("intelligence", 0);
		statMap.put("charisma", 0);
		statMap.put("perception", 0);
		statMap.put("willpower", 0);
		statMap.put("agility", 0);
		statMap.put("strength", 0);
		statMap.put("stamina", 0);
		statMap.put("initiative", 0);
		statMap.put("initiativeModifier", 0);
		statMap.put("raud", 0);
		this.combatSkills = new CombatAbilites(new HashMap<String, Integer>());
	}
	
	public TrudvangCharacter(String name, Map<String, Integer> combatSet, Map<String, Integer> characterStats) {
		statMap = new HashMap<>();
		skillList = new ArrayList<>();
		statMap.put("initiative", 0);
		statMap.put("initiativeModifier", 0);
		this.name = name;
		this.statMap = characterStats;
		this.combatSkills = new CombatAbilites(combatSet);
	}

	public void updateCombatValues() {
		CombatConverter combatMap = new CombatConverter();
		for(String skill : skillList) {
			String[] skillData = skill.split(" ");
			statMap.put(combatMap.getMap().get(skillData[0]).getStatName(),
					combatMap.getMap().get(skillData[0]).getMultiPlier() * Integer.parseInt(skillData[1]));
			
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, Integer> getStatMap(){
		return statMap;
	}
	
	public void setStatMap(Map<String, Integer> statMap){
		this.statMap = statMap;
	}
	
	public CombatAbilites getCombatMap(){
		return combatSkills;
	}
	
	public List<String> getSkillList(){
		return skillList;
	}
	
	public void setSkillList( List<String> skillList){
		this.skillList = skillList;
	}
}
