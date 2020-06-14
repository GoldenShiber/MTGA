package SkillTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import stats.CombatAbilites;

import org.junit.jupiter.api.Test;

class characterTest {
	
	@Test
	void combatSkillTest() {
		HashMap<String, Integer> testMap = new HashMap<String, Integer>();
		testMap.put("hej", 25);
		CombatAbilites combatMap = new CombatAbilites(testMap);
		assertEquals(testMap.get("hej"), combatMap.getCombatMap().get("hej"));
		
	}

}