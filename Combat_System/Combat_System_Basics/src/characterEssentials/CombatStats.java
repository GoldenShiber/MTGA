package characterEssentials;

import java.util.HashMap;

public class CombatStats extends BasicStats{

	/*
	 * The idea of the combat level is to determine the amount of combat points
	 * a character can use based on a their base combat level and skills involved in combat.
	 */
	private final HashMap<String, Integer> combatSkills = new HashMap<String, Integer>();
	
	@Override
	public void returnStats() {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateStats() {
		// TODO Auto-generated method stub
	}
	
	public void addToHashmap(String skill, int level) {
		combatSkills.put(skill, level);
	}
	
	public HashMap<String, Integer> getCombatSkills(){
		return combatSkills;
	}
}
