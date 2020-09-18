package controller;

import java.util.ArrayList;

import model.Aplikacija;
import model.Recept;

public class Controller {
	private Aplikacija aplikacija;

	public Controller(Aplikacija aplikacija) {
		this.aplikacija = aplikacija;
	}
	
	public void registracija(String name, String surname, String username, String password, String email) throws Exception {
		if(name == "" || username == "" || surname == "" || password == "" || email == "" ) {
			throw new NullPointerException();
		} 
		
		if(!aplikacija.registracija(name, surname, username, password, email)) {
			throw new Exception();
		}
			
	}
	
	public void dodajRecept(String naziv,String opis,String urlSlike,String autor) {
		
		if(naziv == "" || opis == "" || urlSlike == "") {
			throw new NullPointerException();
		}else {
			aplikacija.dodajRecept(naziv,opis,urlSlike,autor);
		}
		

	}

	public void updateRecept(String naziv, String opis, String imgUrl, String autor) {
		// TODO Auto-generated method stub
		if(naziv == "" || opis == "" || imgUrl == "") {
			throw new NullPointerException();
		}else {
			aplikacija.updateRecept(naziv,opis,imgUrl,autor);
		}
	}

	public void ulogujSe(String text, String text2) {
		// TODO Auto-generated method stub
		
		if(text.equals("") || text2.equals("")) {
			
			throw new NullPointerException();
		}
		
		if(!aplikacija.ulogujSe(text,text2)) {
			
			throw new NullPointerException();
		}
	}

	public void azurirajKorisnika(String text, String text2, String text3) throws Exception {
		// TODO Auto-generated method stub
		if(text2.equals("") || text3.equals("")) {
			throw new NullPointerException();
		}
		String[] delovi = text3.split(" ");
		if(delovi.length<2) {
			throw new Exception();
		}
		String ime = delovi[0];
		String prezime = delovi[1];
		aplikacija.azurirajKorisnika(text,text2,ime,prezime);
	}

	public void obrisiRecept(String valueAt, String valueAt2) {
		// TODO Auto-generated method stub
		aplikacija.obrisiRecept(valueAt,valueAt2);
	}

	public ArrayList<Recept> pretragaRecepta(String text, String parseInt, String text2) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Recept> receptiVracaj = new ArrayList<Recept>();
		if(text2.equals("") && text.equals("") ) {
			throw new NullPointerException();
		}
		Integer vreme;
		try {
			vreme = Integer.parseInt(parseInt);
		} catch(Exception e) {
			throw new Exception();
		}
		
		receptiVracaj = aplikacija.pretragaRecepta(text,vreme,text2);
		return receptiVracaj;
	}
}
