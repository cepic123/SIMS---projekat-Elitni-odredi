package view;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import model.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import controler.*;

public class NewsFeed extends JPanel {
	JButton addRecipe;
	private ArrayList<RecipePanel> recipes;
	private JButton next;
	private ReceptiNewsFeed rc = new ReceptiNewsFeed(new ArrayList<Recept>());
	public NewsFeed() {
		initComponents();
	
	}
	
	private void initComponents() {
		rc.napuniRecepte();	

		recipes = new ArrayList<RecipePanel>();
		next = new JButton("Sledeca strana");
		
		for(int i = 0; i < rc.getRecepti().size(); i++) {
			RecipePanel rp = new RecipePanel();
			recipes.add(rp);
		}
		
		addRecipe = new JButton("Dodaj recept");
		addRecipe.setPreferredSize(new Dimension(160, 40));
		addRecipe.setMinimumSize(new Dimension(160, 40));
		addRecipe.setMaximumSize(new Dimension(160, 40));
	
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,0,0,0);
		
		gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.ipadx = 80;  
	    add(addRecipe, gbc);
	    gbc.insets = new Insets(20,0,0,0);
	    
		gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 2;
	    add(recipes.get(0), gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    add(recipes.get(1), gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    add(recipes.get(2), gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    add(recipes.get(3), gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    add(next, gbc);
	    
	    setData();
	}
	
	private void setData() {
		for(int i = 0; i < recipes.size(); i++) {
			recipes.get(i).setData(rc.getRecepti().get(i));
		}
	}
}

