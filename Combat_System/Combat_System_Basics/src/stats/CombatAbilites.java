package stats;

import java.util.Map;

/*
 * The combat abilities affects the combat, and is defined with a ability name and a skill level for that ability.
 */

public class CombatAbilites {

	private final Map<String, Integer> combatMap;
	
	public CombatAbilites(Map<String, Integer> combatMap) {
		this.combatMap = combatMap;
	}

	public Map<String, Integer> getCombatMap() {
		return combatMap;
	}
	
}
