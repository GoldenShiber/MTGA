package modelTables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import characterEssentials.TrudvangCharacter;

public class CharacterCreationTable extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TrudvangCharacter> characterList = new ArrayList<>();
	private String[] columns = {"Name"};
	
	public CharacterCreationTable() {
		super();
	}
	
	public CharacterCreationTable(List<TrudvangCharacter> characters) {
		super();
		characterList = characters;
	}
	
	@Override
	public String getColumnName(int col) {
        return columns[col];
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
	public void setValueAt(Object value, int row, int col) {
        characterList.get(row).setName((String) value);
        fireTableCellUpdated(row, col);
    }
	
	@Override
	public Object getValueAt(int row, int col) {
		TrudvangCharacter character = characterList.get(row);
		switch(col) {
			case 0:
				return character.getName().toString();
			default: 
				return null;
		}
		
	}

}
