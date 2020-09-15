package controler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.*;

public class AddRecipec {
	ArrayList<Recept> recepti;

	public AddRecipec(ArrayList<Recept> recepti) {
		super();
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
	public void dodajRecept(String naziv,String opis,String urlSlike,String autor) {
		Recept novi = new Recept(naziv,autor,opis,0,urlSlike);
		System.out.println(recepti);
		recepti.add(novi);
		try {
			PrintWriter pw = new PrintWriter("recepti.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("recepti.txt",true));
			for (Recept artikal : recepti) {
				System.out.println(artikal.getNaziv() +"-" +artikal.getAutor()+ "-"  + artikal.getUputstvo() + "-" +artikal.getVremePripreme().toString() + "-" + artikal.getUrlSlike());
				pw.println(artikal.getNaziv() +"-" +artikal.getAutor()+ "-"  + artikal.getUputstvo() + "-" +artikal.getVremePripreme().toString() + "-" + artikal.getUrlSlike());
			}
			pw.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public ArrayList<Recept> getRecepti() {
		return recepti;
	}

	public void setRecepti(ArrayList<Recept> recepti) {
		this.recepti = recepti;
	}

}
