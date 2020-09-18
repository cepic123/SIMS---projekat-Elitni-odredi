package model;

public class Sastojak {
	String ime;
	TipSastojka tip;
	public Sastojak(String ime, TipSastojka tip) {
		super();
		this.ime = ime;
		this.tip = tip;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public TipSastojka getTip() {
		return tip;
	}
	public void setTip(TipSastojka tip) {
		this.tip = tip;
	}
	
}
