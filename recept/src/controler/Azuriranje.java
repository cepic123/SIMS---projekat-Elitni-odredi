package controler;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.*;
public class Azuriranje {
	ArrayList<Korisnik> korisnici;

	public Azuriranje(ArrayList<Korisnik> korisnici) {
		super();
		this.korisnici = korisnici;
	}

	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
	public void napuniKorisnike() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("korisnici.txt"));
			String current;
			
			while((current = br.readLine()) != null) {
				String[] delovi = current.split("-");
			
				Korisnik vrati = new Korisnik(delovi[0],delovi[1],delovi[2],delovi[3],delovi[4],TipKorisnika.valueOf(delovi[5]));
				this.korisnici.add(vrati);
			}
			br.close();
			
		} 
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public void izmeniKorisnika(String username, String password, String imePrezime) {
		String[] delovi = imePrezime.split(" ");
		
		String ime = delovi[0];
		String prezime = delovi[1];
		for(Korisnik korisnik : korisnici) {
			if(korisnik.getUsername().equals(username)) {
				korisnik.setPassword(password);
				korisnik.setIme(ime);
				korisnik.setPrezime(prezime);
			}
		}
		try {
			PrintWriter pw = new PrintWriter("korisnici.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("korisnici.txt",true));
			for (Korisnik artikal : korisnici) {
				pw.println(artikal.getIme()+"-"+artikal.getPrezime()+"-"+artikal.getUsername()+"-"+
							artikal.getPassword()+"-"+artikal.getEmail()+"-"+artikal.getTip().name());
			}
			pw.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}
