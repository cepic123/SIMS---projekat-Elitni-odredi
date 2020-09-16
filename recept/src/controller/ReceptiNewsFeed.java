package controller;
import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import view.*;

public class ReceptiNewsFeed {

	ArrayList<Recept> recepti;
	
	public ReceptiNewsFeed(ArrayList<Recept> arrayList) {
		super();
		this.recepti = arrayList;
	}

	public void napuniRecepte() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("recepti.txt"));
			String current;
			
			while((current = br.readLine()) != null) {
				String[] delovi = current.split("-");
				
				Recept vrati = new Recept(delovi[0],delovi[1],delovi[2],Integer.parseInt(delovi[3]),delovi[4]);
				this.recepti.add(vrati);
			}
			br.close();
			
		} 
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

	public ArrayList<Recept> getRecepti() {
		return recepti;
	}

	public void setRecepti(ArrayList<Recept> recepti) {
		this.recepti = recepti;
	}
	
	
}
