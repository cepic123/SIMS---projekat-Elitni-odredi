package model;
import java.util.ArrayList;

public class Recept {
	String naziv;
	String uputstvo;
	Integer vremePripreme;
	String autor;
	ArrayList<Komentar> komentari;
	ArrayList<Korisnik> lajkovi;
	ArrayList<KuhinjskaOprema> oprema;
	ArrayList<Kolicina> sastojci;
	String urlSlike;
	public Recept(String naziv,String uputstvo, Integer vremePripreme, String autor, ArrayList<Kolicina> sastojci, String url) {
		super();
		this.naziv = naziv;
		this.uputstvo = uputstvo;
		this.vremePripreme = vremePripreme;
		this.autor = autor;
		this.sastojci = sastojci;
		this.urlSlike = url;
	}	
	
	
}
