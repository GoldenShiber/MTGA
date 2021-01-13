package SkillTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import stats.CombatAbilites;

import org.junit.jupiter.api.Test;

import maps.CombatConverter;

class characterTest {
	
	@Test
	void combatAbilityTest() {
		HashMap<String, Integer> testMap = new HashMap<String, Integer>();
		testMap.put("hej", 25);
		CombatAbilites combatMap = new CombatAbilites(testMap);
		assertEquals(testMap.get("hej"), combatMap.getCombatMap().get("hej"));
		
		
	}
	
	@Test
	void combatConverterTest() {
		CombatConverter convertMap = new CombatConverter();
		String[] testArray= {"Kampvana 3", "Stridsvana 4", "Stridshandlingar 1"};
		int[] verifyNumberArray = {6, 4, 1};
		for(int i = 0; i < testArray.length; i++) {
			String[] skillSplit = testArray[i].split(" ");
			assertEquals(verifyNumberArray[i],
					Integer.parseInt(skillSplit[1])*convertMap.getMap().get(skillSplit[0]).getMultiPlier());
		}
		
	}

}