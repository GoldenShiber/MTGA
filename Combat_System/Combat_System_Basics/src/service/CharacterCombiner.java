package service;

import java.io.IOException;

import maps.CombatConverter;
import stats.CombatValue;

public class CharacterCombiner {
	
	public static void main(String[] args) throws IOException {
	
		CombatConverter combatSkillConverter = new CombatConverter();
		CombatValue testSkill = combatSkillConverter.getMap().get("Kampvana");
		System.out.println(testSkill.getStatName());
	}	

}
