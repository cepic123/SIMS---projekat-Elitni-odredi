package view;

import controler.*;
import model.Recept;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class RecipePanel extends JPanel {
	
	private JLabel recipeName;
	private JLabel username;
	private JLabel recipeDescription;
	private ImageHolder ri;
	private JButton detailsButton;
	
	public RecipePanel() {
		
		initComponents();
		
	}
	
	private void initComponents() {
		
//		Border blackBorder = BorderFactory.createLineBorder(Color.black);
//		setBorder(blackBorder);
		setBackground(Color.white);
		
		username = new JLabel();
		recipeName = new JLabel();
		recipeDescription = new JLabel();
		detailsButton = new JButton("Detaljnije");
		ri = new ImageHolder();
				
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 3;
	    add(ri, gbc);
		
	    
	    gbc.ipady = 20;
		gbc.gridx = 1;
	    gbc.gridy = 1;
	    add(recipeName, gbc);
	    
	    gbc.gridwidth = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    add(username, gbc);

	    gbc.gridwidth = 3;
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    add(recipeDescription, gbc);
	    
	    gbc.gridwidth = 3;
	    gbc.gridx = 0;
	    gbc.gridy = 4;
//	    add(detailsButton);
	    
	}
	
	public void setData(Recept recept) {
		//Kontam da ovde prosledis neku strukturu podataka tipa Recept pa da izvlacis iz njega podatke, a ovo je samo primer
		username.setText(recept.getAutor());
		recipeName.setText(recept.getNaziv());
		recipeDescription.setText(recept.getUputstvo());
		recipeDescription.setPreferredSize(new Dimension(400,100));
		ri.setImage(recept.getUrlSlike());
	}

}
