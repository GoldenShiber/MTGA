package status;

import java.util.HashMap;

import main.character.TrudvangCharacter;

public class CharacterList {

	private static CharacterList instance = null;
	private HashMap<String, TrudvangCharacter> characterList = new HashMap<>();
	
	private CharacterList() {
		super();
	}
	
	public static CharacterList getInstance() {
		if(instance == null) {
			instance = new CharacterList();
		}
		return instance;
	}
	
	public void addCharacter(TrudvangCharacter character) {
		characterList.put(character.name, character);
	}
	
	public TrudvangCharacter getCharacter(String name) {
		return characterList.get(name);
	}
	
	public void removeCharacter(String name) {
		characterList.remove(name);
	}
	
	public void cleanse() {
		characterList = new HashMap<>();
	}
	
}
