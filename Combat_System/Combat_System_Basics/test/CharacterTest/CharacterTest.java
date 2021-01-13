package CharacterTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;


import main.character.TrudvangCharacter;

import org.junit.jupiter.api.Test;

class CharacterTest {

	@Test
	void characterTest() {
		TrudvangCharacter testCharacter = new TrudvangCharacter("John", 10, 10, 5, 5, new HashMap<String, Integer>());
		// TODO: Use AssertEqual to check if the character retrieves the correct values.
		assertEquals(testCharacter.health, 10);
		assertEquals(testCharacter.name, "John");
		assertEquals(testCharacter.initative, 10);
		assertEquals(testCharacter.initiativeModifier, 5);
		assertEquals(testCharacter.raud, 5);
		
	}

}
