package model;

public class Kolicina {
	Integer gramaza;
	Sastojak sastojak;
	public Integer getGramaza() {
		return gramaza;
	}
	public void setGramaza(Integer gramaza) {
		this.gramaza = gramaza;
	}
	public Sastojak getSastojak() {
		return sastojak;
	}
	public void setSastojak(Sastojak sastojak) {
		this.sastojak = sastojak;
	}
	public Kolicina(Integer gramaza, Sastojak sastojak) {
		super();
		this.gramaza = gramaza;
		this.sastojak = sastojak;
	}
}
