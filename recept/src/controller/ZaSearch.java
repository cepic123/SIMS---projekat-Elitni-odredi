package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.Recept;

public class ZaSearch {
	ArrayList<Recept> recepti;

	public ZaSearch(ArrayList<Recept> recepti) {
		super();
		this.recepti = recepti;
	}

	public ArrayList<Recept> getRecepti() {
		return recepti;
	}

	public void setRecepti(ArrayList<Recept> recepti) {
		this.recepti = recepti;
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
	
	public ArrayList<Recept> nadjiRecepte(String naziv, int vremeKuvanja, String autor){
		ArrayList<Recept> receptiZaSearch = new ArrayList<Recept>();
		for(Recept recept: recepti) {
			if(recept.getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
				receptiZaSearch.add(recept);
				continue;
			}
			if(recept.getVremePripreme()<= vremeKuvanja) {
				receptiZaSearch.add(recept);
				continue;
			}
			if(recept.getAutor().toLowerCase().contains(autor.toLowerCase())) {
				receptiZaSearch.add(recept);
				continue;
			}
		}
		return receptiZaSearch;
	}
}
