package Utils;

import character.TrudvangCharacter;

/*
 * Most functions modifying a combat or civil skill check
 * needs to be added here. So it is easy to find and utilize an already
 * implemented method for general cases.
 */

public class statUtilities {

	public int calculateInitiative(TrudvangCharacter character) {
		int initiative = 0;
		initiative = (int) Math.random()*10 + character.initiativeModifier -1;
		return initiative;
	}
}
