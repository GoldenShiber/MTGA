package maps;

import java.util.HashMap;
import java.util.Map;

import stats.CombatValue;

/*
 * The Library Map contains defines a way to fetch legal targets for either combat skills, different enemies or weapons that the characters can get.
 */


public class LibraryMap {

private Map<String, CombatValue> activityMap = new HashMap<>();
	
	
	public LibraryMap() {
		super();
		activityMap.put("Kampvana", new CombatValue("combat", 2));
		activityMap.put("Stridsvana", new CombatValue("combat", 1));
		activityMap.put("Beväpnad Strid", new CombatValue("weapon", 2));
		activityMap.put("Enhandsfattade Lätta Vapen(Höger hand)", new CombatValue("oneHandLightRight", 2));
		activityMap.put("Enhandsfattade Lätta Vapen(Vänster hand)", new CombatValue("oneHandLightLeft", 2));
		activityMap.put("Enhandsfattade Tunga Vapen(Höger hand)", new CombatValue("oneHandHeavyRight", 2));
		activityMap.put("Enhandsfattade Tunga Vapen(Vänster hand)", new CombatValue("oneHandHeavyLeft", 2));
		activityMap.put("Kastvapen(Höger hand)", new CombatValue("throwWeaponsRight", 2));
		activityMap.put("Kastvapen(Vänster hand)", new CombatValue("throwWeaponsLeft", 2));
		activityMap.put("Pilbågar och Slungor", new CombatValue("longRangeBow", 2));
		activityMap.put("Sköldbärare", new CombatValue("shield", 2));
		activityMap.put("Tvåhandade Vapen", new CombatValue("twoHanded", 2));
		activityMap.put("Armborst", new CombatValue("longRangeArbalest", 2));
		activityMap.put("Brottning", new CombatValue("wrestling", 2));
		activityMap.put("Holmgång", new CombatValue("unarmed", 2));
		activityMap.put("Obeväpnad Strid", new CombatValue("unarmed", 1));
		activityMap.put("Stridshandlingar", new CombatValue("generalCombat", 1));
		activityMap.put("Rustningsbärare", new CombatValue("armorSkill", 2));
		activityMap.put("Stridsreaktion", new CombatValue("initiative", 2));

	}
	
	public Map<String, CombatValue> getMap(){
		return activityMap;
	}
	
}
