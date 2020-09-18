package view;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import model.*;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.*;

public class NewsFeed extends JPanel {
	JButton addRecipe;
	private ArrayList<RecipePanel> recipes;
	private JButton next;
	private Aplikacija aplikacija;
	public NewsFeed(Aplikacija aplikacija) {
		this.aplikacija = aplikacija;
		initComponents();
	
	}
	
	private void initComponents() {

		recipes = new ArrayList<RecipePanel>();
		next = new JButton("Sledeca strana");
		
		for(int i = 0; i < aplikacija.getRecepti().size(); i++) {
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

	    for(int i=0;i<recipes.size();i++) {
	    	gbc.gridx = 0;
		    gbc.gridy = i+1;
		    gbc.gridwidth = 2;
		    add(recipes.get(i), gbc);
	    }
	    
	    
	    setData();
	}
	
	private void setData() {
		for(int i = 0; i < recipes.size(); i++) {
			recipes.get(i).setData(aplikacija.getRecepti().get(i));
		}
	}

	public JButton getAddRecipe() {
		return addRecipe;
	}

	public void setAddRecipe(JButton addRecipe) {
		this.addRecipe = addRecipe;
	}

	public ArrayList<RecipePanel> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<RecipePanel> recipes) {
		this.recipes = recipes;
	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}

	
	
	
}

