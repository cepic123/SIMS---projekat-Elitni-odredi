package model;

import java.util.ArrayList;

import controller.Controller;
import view.AppWindow;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		Aplikacija aplikacija = new Aplikacija("Naziv","domen",new ArrayList<Korisnik>(), new ArrayList<Recept>());
		Controller controller = new Controller(aplikacija);
		MainWindow mw = new MainWindow(controller, aplikacija);
		mw.setVisible(true);
		
		//ovo dole je test
//		Korisnik k = new Korisnik("goca", "milosavljevic", "goca", "goca123", "goca@uns.ac.rs", TipKorisnika.Admin);
//		AppWindow aw = new AppWindow(aplikacija,controller);
//		aw.setVisible(true);
	}
}
