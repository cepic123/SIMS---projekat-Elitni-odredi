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
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getUputstvo() {
		return uputstvo;
	}
	public void setUputstvo(String uputstvo) {
		this.uputstvo = uputstvo;
	}
	public Integer getVremePripreme() {
		return vremePripreme;
	}
	public void setVremePripreme(Integer vremePripreme) {
		this.vremePripreme = vremePripreme;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public ArrayList<Komentar> getKomentari() {
		return komentari;
	}
	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}
	public ArrayList<Korisnik> getLajkovi() {
		return lajkovi;
	}
	public void setLajkovi(ArrayList<Korisnik> lajkovi) {
		this.lajkovi = lajkovi;
	}
	public ArrayList<KuhinjskaOprema> getOprema() {
		return oprema;
	}
	public void setOprema(ArrayList<KuhinjskaOprema> oprema) {
		this.oprema = oprema;
	}
	public ArrayList<Kolicina> getSastojci() {
		return sastojci;
	}
	public void setSastojci(ArrayList<Kolicina> sastojci) {
		this.sastojci = sastojci;
	}
	public String getUrlSlike() {
		return urlSlike;
	}
	public void setUrlSlike(String urlSlike) {
		this.urlSlike = urlSlike;
	}	
	
	
}
