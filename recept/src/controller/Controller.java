package controller;

import model.Aplikacija;

public class Controller {
	private Aplikacija aplikacija;

	public Controller(Aplikacija aplikacija) {
		this.aplikacija = aplikacija;
	}
	
	public void registracija(String name, String surname, String username, String password, String email) throws Exception {
		if(name == "" || username == "" || surname == "" || password == "" || email == "" ) {
			throw new NullPointerException();
		} 
		//dodati jos provera
		//kontroler proverava da li je email dobro unet
		if(!aplikacija.registracija(name, surname, username, password, email)) {
			throw new Exception();
		}
			
	}
	
	public void dodajRecept(String naziv,String opis,String urlSlike,String autor) {
		//if pr
		if(naziv == "" || opis == "" || urlSlike == "") {
			throw new NullPointerException();
		}else {
			aplikacija.dodajRecept(naziv,opis,urlSlike,autor);
		}
		
//		throw new Exception();
//		aplikacija.dodajRecept();
	}

	public void updateRecept(String naziv, String opis, String imgUrl, String autor) {
		// TODO Auto-generated method stub
		if(naziv == "" || opis == "" || imgUrl == "") {
			throw new NullPointerException();
		}else {
			aplikacija.updateRecept(naziv,opis,imgUrl,autor);
		}
	}
}
