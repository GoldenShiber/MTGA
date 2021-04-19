package status;

import java.util.HashMap;

import characterEssentials.TrudvangCharacter;

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
		characterList.put(character.getName(), character);
	}
	
	public TrudvangCharacter getCharacter(String name) {
		return characterList.get(name);
	}
	
	public void removeCharacter(String name) {
		characterList.remove(name);
	}
	
	public HashMap<String, TrudvangCharacter> getCharacterList(){
		return characterList;
	}
	
	public void cleanse() {
		characterList = new HashMap<>();
	}
	
}
