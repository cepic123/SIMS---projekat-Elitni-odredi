package model;

import view.AppWindow;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
//		MainWindow mw = new MainWindow();
//		mw.setVisible(true);
		Korisnik k = new Korisnik("goca", "milosavljevic", "goca", "goca123", "goca@uns.ac.rs", TipKorisnika.Admin);
		AppWindow aw = new AppWindow(k);
		aw.setVisible(true);
	}
}
