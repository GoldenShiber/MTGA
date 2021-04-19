package forms;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import Utils.JSONUtilities;
import characterEssentials.TrudvangCharacter;
import modelTables.CharacterCreationTable;
import status.CharacterList;


/*
 * The add character class form is a way to add a character to the session. 
 * The prototype only includes simple data, in order to create and add a Trudvang character.
 * Future implementation includes civil abilities and smarter way to save the character data for future usage. 
 */

public class AddCharacterForm {

	private JFrame characterForm = new JFrame();
	
	private String[] labels = {"Name", "Health", "Stamina", "Intelligence", "Charisma", "Perception", "Willpower", "Agility", "Strength"};

	
	private JPanel infoPanel = new JPanel();
	private JPanel interfacePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel buttonFunctionPanel = new JPanel();
	private JPanel importExportPanel = new JPanel();
	
	private JPanel characterTablePanel = new JPanel();
	
	// Buttons
	private JButton addButton = new JButton("Add");
	private JButton editButton = new JButton("Edit");
	private JButton removeButton = new JButton("Remove");
	private JButton importButton = new JButton("Import");
	private JButton exportButton = new JButton("Export");
	private JButton applyButton = new JButton("Apply");
	private JButton cancelButton = new JButton("Cancel");
	
	// Table necessities
	private List<TrudvangCharacter> characterList = new ArrayList<>();
	private TableModel characterTableModel;
	private JTable characterTable = new JTable();
	private JScrollPane characterTablePane = new JScrollPane();
	
	public AddCharacterForm() {
		initComponents();
		applyActionListeneres();
		disableEditing();
		
	}
	
	private void initComponents() {
		
		// Swing is a fun interface and do stuff in reverse, though I will reverse the labels.
		Collections.reverse(Arrays.asList(labels));
		
		interfacePanel.setLayout(new GridLayout(1, 3));
		infoPanel = new JPanel(new GridLayout(labels.length+1, 2));
		buttonPanel = new JPanel(new GridLayout(3,3));
		buttonPanel.setBorder(BorderFactory.createTitledBorder("Characters"));
		buttonFunctionPanel = new JPanel(new GridLayout(3, 0));
		importExportPanel = new JPanel(new GridLayout(1, 2));
		
		characterTablePanel = new JPanel();
		
		for ( int i = 0; i < labels.length; i++) {
			JLabel label = new JLabel(labels[i], JLabel.CENTER);
			infoPanel.add(label, i, 0);
			JTextField textField = new JTextField(4);
			label.setLabelFor(textField);
			infoPanel.add(textField, i, 1);
		}
		infoPanel.add(applyButton);
		infoPanel.add(cancelButton);
		
		interfacePanel.add(infoPanel, 0, 0);
		
		buttonFunctionPanel.add(addButton);
		buttonFunctionPanel.add(editButton);
		buttonFunctionPanel.add(removeButton);
		
		buttonPanel.add(characterTablePanel);
		buttonPanel.add(buttonFunctionPanel);
		buttonPanel.add(importExportPanel);
		
		importExportPanel.add(importButton);
		importExportPanel.add(exportButton);
		
		interfacePanel.add(buttonPanel);
//		interfacePanel.add(characterTablePanel);
		
		characterList = new ArrayList<TrudvangCharacter>(CharacterList.getInstance().getCharacterList().values());
		characterTableModel = new CharacterCreationTable(characterList);
		characterTable = new JTable(characterTableModel);
		characterTablePane.setViewportView(characterTable);
		characterTablePanel.add(characterTablePane);
		
		characterForm.setSize(new Dimension(600, 300));
		
		characterForm.setTitle("Character Form");
		
		characterForm.add(interfacePanel);
		
		characterForm.setVisible(true);
	}
	
	private void applyActionListeneres() {
		addButton.addActionListener(new addCharacter());
		applyButton.addActionListener(new ApplyChanges());
		cancelButton.addActionListener(new CancelChanges());
		editButton.addActionListener(new editCharacter());
		exportButton.addActionListener(new ExportCharacters());
		importButton.addActionListener(new ImportCharacters());
	}
	
	private class addCharacter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			clearEditingFields();
			disableButtons();
			enableEditing();
			}
			
		}
		
	private class editCharacter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			disableButtons();
			enableEditing();
		}
		
	}
	
	private class ApplyChanges implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			enableButtons();
			disableEditing();
			if(verifyFields()) {
				TrudvangCharacter newCharacter = new TrudvangCharacter();
				newCharacter.setName(((JTextField) infoPanel.getComponent(1)).getText());
				
				int labelIndex=1;
				Map<String, Integer> statMap = newCharacter.getStatMap();
				for(int i = 3; i < labels.length*2 ; i+=2) {
					statMap.put(labels[labelIndex].toLowerCase(),Integer.valueOf(((JTextField) infoPanel.getComponent(i)).getText()));
					labelIndex++;
					}
				newCharacter.setStatMap(statMap);
				characterList.add(newCharacter);
//				characterTable = new JTable(new CharacterCreationTable(characterList));
				characterTablePane.setViewportView(characterTable);
				}
			clearEditingFields();
		}
		
	}
	
	private class CancelChanges implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			enableButtons();
			disableEditing();
			clearEditingFields();
		}
		
	}
	
	private class ExportCharacters implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JSONUtilities.saveCharacterList(characterList, "GUItest.json");
			
		}
		
	}
	
	private class ImportCharacters implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JSONUtilities.importJSONFile("GUItest.json");
			characterList = new ArrayList<TrudvangCharacter>(CharacterList.getInstance().getCharacterList().values());
			characterTableModel = new CharacterCreationTable(characterList);
			characterTable = new JTable(characterTableModel);
			characterTablePane.setViewportView(characterTable);
			
		}
		
	}
	
	private boolean verifyFields() {
		System.out.println(((JTextField) infoPanel.getComponent(1)).getText());
		if(((JTextField) infoPanel.getComponent(1)).getText().equals("")){
			System.out.println("The character does not have a name!");
			return false;
		}
		for(int i = 3; i < labels.length*2 ; i+=2) {
			if(!Utils.GeneralUtils.isNumeric(((JTextField) infoPanel.getComponent(i)).getText())) {
				System.out.println("Stat values are not filled");
				return false;
			}
		}
		return true;
	}
	
	private void enableButtons() {
		addButton.setEnabled(true);
		editButton.setEnabled(true);
		removeButton.setEnabled(true);
		importButton.setEnabled(true);
		exportButton.setEnabled(true);
	}
	
	private void disableButtons() {
		addButton.setEnabled(false);
		editButton.setEnabled(false);
		removeButton.setEnabled(false);
		importButton.setEnabled(false);
		exportButton.setEnabled(false);
	}
	
	private void enableEditing() {
		for ( int i = 0; i < labels.length*2; i+=2) {
			((JTextField) infoPanel.getComponent(i+1)).setEditable(true);
		}
		applyButton.setEnabled(true);
		cancelButton.setEnabled(true);
	}
	
	private void disableEditing() {
		for ( int i = 0; i < labels.length*2; i+=2) {
			((JTextField) infoPanel.getComponent(i+1)).setEditable(false);
		}
		applyButton.setEnabled(false);
		cancelButton.setEnabled(false);
	}
	
	private void clearEditingFields() {
		for ( int i = 0; i < labels.length*2; i+=2) {
			((JTextField) infoPanel.getComponent(i+1)).setText("");
		}
	}
	
	public static void main(String[] args) {  
		new AddCharacterForm();  
		
		}  
}
