package stats;

import java.util.HashMap;

public class CombatAbilites {

	private final HashMap<String, Integer> combatMap;
	
	public CombatAbilites(HashMap<String, Integer> combatMap) {
		this.combatMap = combatMap;
	}

	public HashMap<String, Integer> getCombatMap() {
		return combatMap;
	}
	
}
