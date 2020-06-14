package main.character;

/*
 * The base of a character is their id(name), health, initiative and raud.
 * In the prototype, the initiative modifiers are hard coded, 
 * however when it is working as a simple prototype, general methods
 * are supposed to be used to simplify actions.
 */

public class TrudvangCharacter {
	public String name;
	public int health;
	public int initative;
	public int initiativeModifier = 0;
	public int raud;
	
	public TrudvangCharacter() {
		this.name = "";
		this.health = 0;
		this.initative = 0;
		this.initiativeModifier = 0;
		this.raud = 0;
	}
	
	public TrudvangCharacter(String name, int health, int initiative, int initiativeModifier, int raud) {
		this.name = name;
		this.health = health;
		this.initative = initiative;
		this.initiativeModifier = initiativeModifier;
		this.raud = raud;
	}

	@SuppressWarnings("unused")
	private String getName() {
		return name;
	}
	
	@SuppressWarnings("unused")
	private int getHealth() {
		return health;
	}
	
	@SuppressWarnings("unused")
	private int getInitiative() {
		return initative;
	}
	
	@SuppressWarnings("unused")
	private int getInitiativeModifier() {
		return initiativeModifier;
	}
	
	@SuppressWarnings("unused")
	private int getRaud() {
		return raud;
	}
	
}
