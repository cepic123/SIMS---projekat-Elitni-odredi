package model;

public class Komentar {
	String tekst;
	Korisnik autor;
	public Komentar(String tekst, Korisnik autor) {
		super();
		this.tekst = tekst;
		this.autor = autor;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public Korisnik getAutor() {
		return autor;
	}
	public void setAutor(Korisnik autor) {
		this.autor = autor;
	}
}
