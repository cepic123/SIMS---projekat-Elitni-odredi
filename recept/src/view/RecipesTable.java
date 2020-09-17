package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import model.Aplikacija;
import model.Recept;

public class RecipesTable extends JTable{
	private Aplikacija aplikacija;
	private DefaultTableModel model;
	public RecipesTable(Aplikacija aplikacija) {
		this.aplikacija = aplikacija;
		Border blackBorder = BorderFactory.createLineBorder(Color.black);
		setBorder(blackBorder);
		String columns[]={"Autor","Naziv","Vreme pripreme","Opis","Detaljnije"};
		Object[][] data = {};

        model = new DefaultTableModel(data, columns);
//        setEnabled(false);
        this.setModel(model);
        
	}
	
	DefaultTableModel getDefModel() {
		return this.model;
	}
	private void initComponents() {
		
	}
//	int [][] matrix = new int[10][20];
//	for(int i = 0; i < 10; i++) {
//	    for(int j = 0; j < 20; j++) {
//	        // read information from somewhere
//	        matrix[i][j] = information;
//	    }
//	}
	 void setUserRecipes() {
		 String columns[]={"Autor","Naziv","Vreme pripreme","Opis","Detaljnije"};
		 Object[][] data = new Object[aplikacija.getUlogovan().getMojiRecepti().size()][5];
		 int i = 0;
		 for(Recept recept:aplikacija.getUlogovan().getMojiRecepti()) {
			 data[i][0] = recept.getAutor();
			 data[i][1] = recept.getNaziv();
			 data[i][2] = recept.getVremePripreme().toString();
			 data[i][3] = recept.getUputstvo();
			 data[i][4] = "Detaljnije";
			 i ++;
				 //{recept.getAutor(),recept.getNaziv(),recept.Integer.ParseInt().getVremePripreme(),recept.getUputstvo(),"Detaljnije"};
		 }
		 model = new DefaultTableModel(data, columns);
	     this.setModel(model); 
	}

	public void setUserRecipess(ArrayList<Recept> recepti) {
		// TODO Auto-generated method stub
		String columns[]={"Autor","Naziv","Vreme pripreme","Opis","Detaljnije"};
		 Object[][] data = new Object[recepti.size()][5];
		 int i = 0;
		 for(Recept recept:recepti) {
			 data[i][0] = recept.getAutor();
			 data[i][1] = recept.getNaziv();
			 data[i][2] = recept.getVremePripreme().toString();
			 data[i][3] = recept.getUputstvo();
			 data[i][4] = "Detaljnije";
			 i ++;
				 //{recept.getAutor(),recept.getNaziv(),recept.Integer.ParseInt().getVremePripreme(),recept.getUputstvo(),"Detaljnije"};
		 }
		 model = new DefaultTableModel(data, columns);
	     this.setModel(model);
	}

	
}
