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
		
		this.imeAplikacije = imeAplikacije;
		this.domenAplikacije = domenAplikacije;
		this.recepti = recepti;
		this.korisnici = korisnici;
		
		
		napuniKorisnike();
		napuniRecepte();
		napuniRecepteKorisnika();
	}
	
	private void napuniRecepteKorisnika() {
		// TODO Auto-generated method stub
		
		for(Recept recept : recepti) {
			for(Korisnik korisnik : korisnici) {
				if(recept.autor.equals(korisnik.username)) {
					korisnik.getMojiRecepti().add(recept);
				}
			}
		}		
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

				Recept vrati = new Recept(delovi[0],delovi[1],delovi[2],Integer.parseInt(delovi[3]),delovi[4]);
				this.recepti.add(vrati);
			}
			br.close();
			
		} 
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public boolean registracija(String name, String surname, String username, String password, String email) {
		for(Korisnik korisnik : korisnici) {
			if(korisnik.getUsername().equals(username)) {
				return false;
			}
			if(korisnik.getEmail().equals(email)) {
				return false;
			}
		}
		
		
		Korisnik noviKorisnik = new Korisnik(name, surname, username, password, email, TipKorisnika.Korisnik);
		korisnici.add(noviKorisnik);
		upisiKorisnike();
		return true;
	}
	
	public void dodajRecept(String naziv,String opis,String urlSlike,String autor) {
		Recept novi = new Recept(naziv,autor,opis,0,urlSlike);
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

	public void updateRecept(String naziv, String opis, String imgUrl, String autor) {
		// TODO Auto-generated method stub
		for(Recept recept : recepti) {
		if(autor.equals(recept.getAutor()) && naziv.equals(recept.getNaziv())) {
			recept.setUputstvo(opis);
			recept.setUrlSlike(imgUrl);
		}
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
				pw.println(artikal.getNaziv() +"-" +artikal.getAutor()+ "-"  + artikal.getUputstvo() + "-" +artikal.getVremePripreme().toString() + "-" + artikal.getUrlSlike());
			}
			pw.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}	
	}

	public boolean ulogujSe(String text, String text2) {
		// TODO Auto-generated method stub
		for(Korisnik korisnik: korisnici) {
		if(korisnik.username.equals(text) && korisnik.password.equals(text2)) {
			ulogovan = korisnik;
			return true;
			}
		}
		return false;
	}
	
	public void upisiKorisnike() {
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

	public void azurirajKorisnika(String text, String text2, String ime, String prezime) {
		// TODO Auto-generated method stub
		for(Korisnik korisnik : korisnici) {
			if(korisnik.getUsername().equals(text)) {
				korisnik.setPassword(text2);
				korisnik.setIme(ime);
				korisnik.setPrezime(prezime);
			}
		}
		upisiKorisnike();
	}

	public void obrisiRecept(String valueAt, String valueAt2) {
		// TODO Auto-generated method stub
		ArrayList<Recept> noviRecepti = new ArrayList<Recept>();
		for(Recept recept : recepti) {
			if(valueAt.equals(recept.getAutor()) && valueAt2.equals(recept.getNaziv())) {
				continue;}
				else {
					noviRecepti.add(recept);
				}
		}
		setRecepti(noviRecepti);
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

	public ArrayList<Recept> pretragaRecepta(String text, Integer vreme, String text2) {
		// TODO Auto-generated method stub
		ArrayList<Recept> receptiZaSearch = new ArrayList<Recept>();
		
		for(Recept recept: this.recepti) {
			if(recept.getNaziv().toLowerCase().contains(text.toLowerCase())) {
				receptiZaSearch.add(recept);
				
				continue;
			}
			if(recept.getVremePripreme()<= vreme) {
				receptiZaSearch.add(recept);
				
				continue;
			}
			if(recept.getAutor().toLowerCase().contains(text2.toLowerCase())) {
				receptiZaSearch.add(recept);
				
				continue;
			}
		}
		return receptiZaSearch;
	}
}



