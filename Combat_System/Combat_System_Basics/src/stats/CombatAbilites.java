package stats;

import java.util.HashMap;

/*
 * The combat abilities affects the combat, and is defined with a ability name and a skill level for that ability.
 */

public class CombatAbilites {

	private final HashMap<String, Integer> combatMap;
	
	public CombatAbilites(HashMap<String, Integer> combatMap) {
		this.combatMap = combatMap;
	}

	public HashMap<String, Integer> getCombatMap() {
		return combatMap;
	}
	
}
