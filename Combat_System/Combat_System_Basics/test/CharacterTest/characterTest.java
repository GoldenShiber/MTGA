package CharacterTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

import character.TrudvangCharacter;

import org.junit.jupiter.api.Test;

class characterTest {

	
	
	@Test
	void characterTest() {
		TrudvangCharacter testCharacter = new TrudvangCharacter("John", 10, 10, 5, 5);
		// TODO: Use AssertEqual to check if the character retrieves the correct values.
		assertEquals(testCharacter.health, 10);
		assertEquals(testCharacter.name, "John");
		assertEquals(testCharacter.initative, 10);
		assertEquals(testCharacter.initiativeModifier, 5);
		assertEquals(testCharacter.raud, 5);
		
	}

}
