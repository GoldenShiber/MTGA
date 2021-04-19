package modelTables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import characterEssentials.TrudvangCharacter;

public class CharacterTable extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TrudvangCharacter> characterList = new ArrayList<>();
	private String[] columns = {"Name", "Health", "Initiative"};
	
	public CharacterTable() {
		super();
	}
	
	public CharacterTable(List<TrudvangCharacter> characters) {
		super();
		characterList = characters;
	}
	
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return characterList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		TrudvangCharacter character = characterList.get(row);
		switch(col) {
			case 0: return character.getName();
			case 1: return character.getStatMap().get("health");
			case 2: return character.getStatMap().get("initiative");
			default: return null;
		}
		
	}

}
