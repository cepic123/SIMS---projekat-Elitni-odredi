import java.util.ArrayList;

public class Aplikacija {
	String imeAplikacije;
	String domenAplikacije;
	ArrayList<Recept> recepti;
	ArrayList<Korisnik> korisnici;
	
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
	public void napuniKorisnike() {
		// TODO Auto-generated method stub
		
	}
	public void napuniRecepte() {
		// TODO Auto-generated method stub
		
	}
	
}
