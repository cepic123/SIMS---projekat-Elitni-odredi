package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import model.Recept;

public class RecipesTable extends JTable{
	
	
	public RecipesTable() {
		
		Border blackBorder = BorderFactory.createLineBorder(Color.black);
		setBorder(blackBorder);
		String columns[]={"Autor","Naziv","Vreme pripreme","Opis","Detaljnije"};
		Object[][] data = {};

        DefaultTableModel model = new DefaultTableModel(data, columns);
        this.setModel(model);
        
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
	 void setData(ArrayList<Recept> recepti) {
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
		 DefaultTableModel model = new DefaultTableModel(data, columns);
	     this.setModel(model); 
	}
}
