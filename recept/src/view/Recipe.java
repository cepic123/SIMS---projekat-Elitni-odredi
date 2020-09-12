package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Recipe extends JPanel {
	
	private JLabel recipeName;
	private JLabel username;
	private JLabel recipeDescription;
	private ImageHolder ri;
	private JButton detailsButton;
	
	public Recipe() {
		
//		setMaximumSize(new Dimension(750,300));
//		setMinimumSize(new Dimension(750,300));
//		setPreferredSize(new Dimension(750,200));
		
		
		
		initComponents();
		
	}
	
	private void initComponents() {
		
		Border blackBorder = BorderFactory.createLineBorder(Color.black);
		setBorder(blackBorder);
		
		username = new JLabel();
		recipeName = new JLabel();
		recipeDescription = new JLabel();
		detailsButton = new JButton("Detaljnije");
		ri = new ImageHolder();
		
		setData();
		
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
	
	public void setData() {
		//Kontam da ovde prosledis neku strukturu podataka tipa Recept pa da izvlacis iz njega podatke, a ovo je samo primer
		
		username.setText("makica123");
		recipeName.setText("Pasta Bolonjeze");
		recipeDescription.setText("<html>"+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, "
				+ "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
				+ "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +"</html>");
		recipeDescription.setPreferredSize(new Dimension(400,100));
		ri.setImage("images/recept1.jpg");
	}

}
