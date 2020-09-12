package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class RecipesTable extends JTable{
	
	
	public RecipesTable() {
		
		Border blackBorder = BorderFactory.createLineBorder(Color.black);
		setBorder(blackBorder);
		String columns[]={"Autor","Naziv","Vreme pripreme","Opis","Detaljnije"};
		Object[][] data = {};

        DefaultTableModel model = new DefaultTableModel(data, columns);
        this.setModel(model);
        
        setData();
	}
	
	private void initComponents() {
		
	}

	private void setData() {
		//punjenje tabele
	}
}
