package model;
import java.util.ArrayList;

public class Korisnik {
	String ime;
	String prezime;
	String username;
	String password;
	String email;
	TipKorisnika tip;
	ArrayList<Recept> mojiRecepti = new ArrayList<Recept>();
	ArrayList<Recept> sacuvaniRecepti = new ArrayList<Recept>();
	ArrayList<Recept> lajkovaniRecepti = new ArrayList<Recept>();
	ArrayList<Korisnik> prati = new ArrayList<Korisnik>();
	ArrayList<Korisnik> pratioci = new ArrayList<Korisnik>();
	ArrayList<Alergen> alergeni = new ArrayList<Alergen>();
	public Korisnik(String ime, String prezime, String username, String password, String email, TipKorisnika tip) {
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
		this.email = email;
		this.tip = tip;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TipKorisnika getTip() {
		return tip;
	}
	public void setTip(TipKorisnika tip) {
		this.tip = tip;
	}
	public ArrayList<Recept> getMojiRecepti() {
		return mojiRecepti;
	}
	public void setMojiRecepti(ArrayList<Recept> mojiRecepti) {
		this.mojiRecepti = mojiRecepti;
	}
	public ArrayList<Recept> getSacuvaniRecepti() {
		return sacuvaniRecepti;
	}
	public void setSacuvaniRecepti(ArrayList<Recept> sacuvaniRecepti) {
		this.sacuvaniRecepti = sacuvaniRecepti;
	}
	public ArrayList<Recept> getLajkovaniRecepti() {
		return lajkovaniRecepti;
	}
	public void setLajkovaniRecepti(ArrayList<Recept> lajkovaniRecepti) {
		this.lajkovaniRecepti = lajkovaniRecepti;
	}
	public ArrayList<Korisnik> getPrati() {
		return prati;
	}
	public void setPrati(ArrayList<Korisnik> prati) {
		this.prati = prati;
	}
	public ArrayList<Korisnik> getPratioci() {
		return pratioci;
	}
	public void setPratioci(ArrayList<Korisnik> pratioci) {
		this.pratioci = pratioci;
	}
	public ArrayList<Alergen> getAlergeni() {
		return alergeni;
	}
	public void setAlergeni(ArrayList<Alergen> alergeni) {
		this.alergeni = alergeni;
	}
	
}
