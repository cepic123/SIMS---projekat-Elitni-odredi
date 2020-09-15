package controler;
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
				String[] sastojci = delovi[4].split("/");
				ArrayList<Kolicina> sas = new ArrayList<Kolicina>();
				
				for (String string : sastojci) {
					String[] sastavci = string.split(",");
					Sastojak s = new Sastojak(sastavci[1],TipSastojka.valueOf(sastavci[0]));
					Kolicina k = new Kolicina(Integer.parseInt(sastavci[2]),s);
					sas.add(k);
				}
				Recept vrati = new Recept(delovi[0],delovi[1],Integer.parseInt(delovi[2]),delovi[3],sas,delovi[5]);
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
