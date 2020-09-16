package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.ZaSearch;
import model.Recept;
import model.Aplikacija;

public class Search extends JPanel implements ActionListener{
	private JTextField recipeName;
	private JTextField author;
	private JTextField time;
	private JButton searchButton;
	private RecipesTable tableOfRecipes;
	private Aplikacija aplikacija;
	
	public Search(Aplikacija aplikacija) {
		this.aplikacija = aplikacija;
		initComponents();
	}
	
	private void initComponents() {
//		zaSearch.napuniRecepte();
		JLabel recipeNameL = new JLabel("Naziv recepta:");
		JLabel authorL = new JLabel("Autor:");
		JLabel timeL = new JLabel("Vreme spremanja:");
		
		recipeName = new JTextField(15);
		author = new JTextField(15);
		time = new JTextField(15);

		searchButton = new JButton("Pretrazi");
		
		
		tableOfRecipes = new RecipesTable(aplikacija);
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
		setActionListeners();
	}
	
	private void setActionListeners() {
		searchButton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton)e.getSource();
		if(clicked == searchButton) {
			
//			tableOfRecipes.setData(zaSearch.nadjiRecepte(recipeName.getText(),Integer.parseInt(time.getText()),author.getText()));
		}
		
	}
	
}
