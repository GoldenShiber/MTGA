package forms;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import Utils.SpringUtilities;


/*
 * The add character class form is a way to add a character to the session. 
 * The prototype only includes simple data, in order to create and add a Trudvang character.
 * Future implementation includes civil abilities and smarter way to save the character data for future usage. 
 */

public class AddCharacterForm {

	private JFrame characterForm = new JFrame();
	
	private JPanel infoPanel = new JPanel(new SpringLayout());
	
	private JPanel interfacePanel = new JPanel();
	
	
	public AddCharacterForm() {
		initComponents();
		
	}
	
	private void initComponents() {
		
		
		String[] labels = {"Name", "HP"};
		
		interfacePanel.setLayout(new GridLayout(1, 2));
		infoPanel = new JPanel(new GridLayout(2,2));
		
		for ( int i = 0; i < labels.length; i++) {
			JLabel label = new JLabel(labels[i], JLabel.TRAILING);
			infoPanel.add(label, i, 0);
			JTextField textField = new JTextField(10);
			label.setLabelFor(textField);
			infoPanel.add(textField, i, 1);
		}

		
		interfacePanel.add(infoPanel, 0, 0);
		interfacePanel.add(new JButton("kek"), 0, 1);
		
		characterForm.setSize(new Dimension(250, 100));
		
		characterForm.setTitle("Character Form");
		
//		infoPanel.setLayout();
		// The name panel
//		infoPanel.add(nameLabel);
//		
////		nameInput.setSize(12, 1);
//		nameInput.setEditable(true);
//		nameLabel.setLabelFor(nameInput);
//		infoPanel.add(nameInput);
//		
//		// The HP panel
//		infoPanel.add(hpLabel);
//		
////		hpInput.setSize(12, 1);
//		hpInput.setEditable(true);
//		hpLabel.setLabelFor(hpInput);
//		infoPanel.add(hpInput);
		
//		infoPanel.add(namePanel);
//		infoPanel.add(hpPanel);
		
//		SpringUtilities.makeCompactGrid(infoPanel, 2, 2, 6, 6, 6, 6);

		characterForm.add(interfacePanel);
		
		characterForm.setVisible(true);
	}
	
	public static void main(String[] args) {  
		new AddCharacterForm();  
		}  
}
