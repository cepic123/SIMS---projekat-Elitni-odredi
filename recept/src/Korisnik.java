import java.util.ArrayList;

public class Korisnik {
	String ime;
	String prezime;
	String username;
	String password;
	String email;
	TipKorisnika tip;
	ArrayList<Recept> mojiRecepti;
	ArrayList<Recept> sacuvaniRecepti;
	ArrayList<Recept> lajkovaniRecepti;
	ArrayList<Korisnik> prati;
	ArrayList<Korisnik> pratioci;
	ArrayList<Alergen> alergeni;
	public Korisnik(String ime, String prezime, String username, String password, String email, TipKorisnika tip) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
		this.email = email;
		this.tip = tip;
	}
}
