package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Aplikacija {
	String imeAplikacije;
	String domenAplikacije;
	ArrayList<Recept> recepti;
	ArrayList<Korisnik> korisnici;
	Korisnik ulogovan;
	
	public Aplikacija(String imeAplikacije, String domenAplikacije, ArrayList<Korisnik> korisnici,
			ArrayList<Recept> recepti) {
		super();
		this.imeAplikacije = imeAplikacije;
		this.domenAplikacije = domenAplikacije;
		this.recepti = recepti;
		this.korisnici = korisnici;
	}
	public String getImeAplikacije() {
		return imeAplikacije;
	}
	public void setImeAplikacije(String imeAplikacije) {
		this.imeAplikacije = imeAplikacije;
	}
	public String getDomenAplikacije() {
		return domenAplikacije;
	}
	public void setDomenAplikacije(String domenAplikacije) {
		this.domenAplikacije = domenAplikacije;
	}
	public ArrayList<Recept> getRecepti() {
		return recepti;
	}
	public void setRecepti(ArrayList<Recept> recepti) {
		this.recepti = recepti;
	}
	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}
	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
	public Korisnik getUlogovan() {
		return ulogovan;
	}
	public void setUlogovan(Korisnik ulogovan) {
		this.ulogovan = ulogovan;
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
	public void registrujKorisnika(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated method stub
		// RECI MARKIZI I JELENI DA NAPRAVE OVE SMECE PROZORE I VRATITI NA REGISTRACIJU 
		// A KAD JE USPESNA OBAVESTITI I PREBACITI NA EKRAN PRIJAVE 
		if(string.equals("") || string2.equals("") || string3.equals("") || string4.equals("") || string5.equals("")) {
			System.out.println("NE MOZE");
			return;
		}
		for(Korisnik  korisnik : korisnici) {
			if(korisnik.username.equals(string3)) {
				System.out.println("NE MOZE");
				return;
			}
		}
		
		Korisnik vrati = new Korisnik(string,string2,string3,string4,string5,TipKorisnika.Korisnik);
		this.korisnici.add(vrati);
		
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
				pw.println(artikal.ime+"-"+artikal.prezime+"-"+artikal.username+"-"+
							artikal.password+"-"+artikal.email+"-"+artikal.tip.name());
			}
			pw.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	public boolean ulogujSe(String text, String text2) {
		// TODO Auto-generated method stub
		for(Korisnik korisnik: korisnici) {
			if(korisnik.username.equals(text) && korisnik.password.equals(text2)) {
				System.out.println("Ulogovan si");
				ulogovan = korisnik;
				return true;
			}
		}
		System.out.println("Nisi ulogovan");
		return false;
	}
	
	public ArrayList<Recept> nadjiRecepteKorisnikove(Korisnik korisnik){
		ArrayList<Recept> receptiKorisnika = new ArrayList<Recept>();
		for(Recept recept : recepti) {
			if(recept.autor.equals(korisnik.username)) {
				receptiKorisnika.add(recept);
			}
		}
		return receptiKorisnika;
	}
}
