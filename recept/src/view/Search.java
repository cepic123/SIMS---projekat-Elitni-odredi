package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Search extends JPanel {
	private JTextField recipeName;
	private JTextField author;
	private JTextField time;
	private JButton searchButton;
	private RecipesTable tableOfRecipes;
	
	public Search() {
		
		initComponents();
	}
	
	private void initComponents() {
		JLabel recipeNameL = new JLabel("Naziv recepta:");
		JLabel authorL = new JLabel("Autor:");
		JLabel timeL = new JLabel("Vreme spremanja:");
		
		recipeName = new JTextField(15);
		author = new JTextField(15);
		time = new JTextField(15);

		searchButton = new JButton("Pretrazi");
		
		tableOfRecipes = new RecipesTable();
		JScrollPane scrollPane = new JScrollPane(tableOfRecipes);
	    scrollPane.setPreferredSize(new Dimension(700,400));
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,3,3,3);
//		gbc.anchor = GridBagConstraints.NORTHWEST;
//		gbc.weightx = 1.0;
//		gbc.weighty = 1.0;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(recipeNameL, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(recipeName, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(authorL, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		add(author, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(timeL, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(time, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(searchButton, gbc);
		
		gbc.gridwidth = 4;
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		add(scrollPane, gbc);
	}
}
