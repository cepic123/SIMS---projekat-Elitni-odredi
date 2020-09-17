package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.AddRecipec;
import controller.Controller;
import model.Aplikacija;
import model.Korisnik;
import model.Recept;

public class AppWindow extends JFrame implements ActionListener {
	
	private NavigationPanel navigationBar = new NavigationPanel("Pocetna strana",
			"Pretraga","Moj profil","Odjavi se");
	private NewsFeed newsFeed;
	private UserProfile userProfile;
	private Search search;
	private int current;
	private JScrollPane scroll;
	private Color lightOrange   = new Color(255, 166, 111);
	private AddRecipe addRecipe;
	private Controller controller;
	private Aplikacija aplikacija;

	public AppWindow(Aplikacija aplikacija, Controller controller) {
		this.aplikacija = aplikacija;
		this.controller = controller;
//		 rc.napuniRecepte();
		userProfile = new UserProfile(aplikacija);
		search = new Search(aplikacija);
		newsFeed = new NewsFeed(aplikacija);
		setSize(1000,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		scroll = new JScrollPane(newsFeed);
		scroll.getVerticalScrollBar().setUnitIncrement(14);
		userProfile.setData();
		userProfile.getTableOfRecipes().setUserRecipes();
		current = 0; //0 je newsfeed
		
		addRecipe = new AddRecipe();
		
		navigationBar.getFirstButton().setForeground(lightOrange);
		add(navigationBar, BorderLayout.WEST);
		add(scroll, BorderLayout.CENTER);

		navigationBar.getFirstButton().addActionListener(this);
		navigationBar.getSecondButton().addActionListener(this);
		navigationBar.getThirdButton().addActionListener(this);
		navigationBar.getFourthButton().addActionListener(this);
		newsFeed.getAddRecipe().addActionListener(this);
		userProfile.getCreateRecipe().addActionListener(this);
		userProfile.getUpdateRecipe().addActionListener(this);
	}
	
	private JPanel getCurrentComponent() {
		if(current == 0) {
			navigationBar.getFirstButton().setForeground(Color.black);
			return newsFeed;
		} else if(current == 1) {
			navigationBar.getThirdButton().setForeground(Color.black);
			return userProfile;
		} else if(current == 2){
			navigationBar.getSecondButton().setForeground(Color.black);
			return search;
		} else  {
			//odloguj se
			return new JPanel();
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton)e.getSource();
		JPanel currentPanel = getCurrentComponent();
		
		if(clicked == navigationBar.getThirdButton()) {
			changePanel(currentPanel, userProfile);
			navigationBar.getThirdButton().setForeground(lightOrange);
			current = 1;
		} else if(clicked == navigationBar.getFirstButton()) {
			changePanel(currentPanel, newsFeed);
			navigationBar.getFirstButton().setForeground(lightOrange);
			current = 0;
		} else if(clicked == navigationBar.getSecondButton()) {
			changePanel(currentPanel, search);
			navigationBar.getSecondButton().setForeground(lightOrange);
			current = 2;
		}else if(clicked == navigationBar.getFourthButton()) {
			//e ovde nisam sig da li se stavlja new Controller() i new Aplikacija ili ne
			Aplikacija newAplikacija = new Aplikacija("Naziv","domen",new ArrayList<Korisnik>(), new ArrayList<Recept>());
			MainWindow mw = new MainWindow(new Controller(newAplikacija), newAplikacija);
     		mw.setVisible(true);
     		dispose();
		} else if(clicked == newsFeed.getAddRecipe()) {
			//iskoci dijalog
			 JOptionPane.showMessageDialog(this,addRecipe,"Dodaj recept",JOptionPane.INFORMATION_MESSAGE);
//			 rc.dodajRecept(addRecipe.getRecipeName().getText(), addRecipe.getDescription().getText(), addRecipe.getImageUrl().getText(), korisnik.getUsername());
//			 userProfile.tableOfRecipes.setData(korisnik.getMojiRecepti());
			 
			 // TO DO
			 
			 
			 addRecipe(addRecipe.getRecipeName().getText(), addRecipe.getDescription().getText(), addRecipe.getImageUrl().getText(), aplikacija.getUlogovan().getUsername());
			 
		} else if(clicked == userProfile.getCreateRecipe()) {
			JOptionPane.showMessageDialog(this,addRecipe,"Dodaj recept",JOptionPane.INFORMATION_MESSAGE);
//			 rc.dodajRecept(addRecipe.getRecipeName().getText(), addRecipe.getDescription().getText(), addRecipe.getImageUrl().getText(), korisnik.getUsername());
//			 userProfile.tableOfRecipes.setData(korisnik.getMojiRecepti());
			
			addRecipe(addRecipe.getRecipeName().getText(), addRecipe.getDescription().getText(), addRecipe.getImageUrl().getText(), aplikacija.getUlogovan().getUsername());
			 
		} else if(clicked == userProfile.getUpdateRecipe()) {
			//check if row is selected
			if(userProfile.getTableOfRecipes().getSelectionModel().isSelectionEmpty()) {
			return;
		} else {
			JOptionPane.showMessageDialog(this,addRecipe,"Dodaj recept",JOptionPane.INFORMATION_MESSAGE);
			updateRecipe(addRecipe.getRecipeName().getText(), addRecipe.getDescription().getText(), addRecipe.getImageUrl().getText(), aplikacija.getUlogovan().getUsername());
		}
			
		}
	}
	
	private void addRecipe(String naziv, String opis, String imgUrl, String autor) {
		
		//try catch
		//ovde proveriti da li su uneti podaci u dijalog...
		 //u kontroleru dodati metodu za add recipe
		// ja cu srediti refreshovanje viewa
		
		try {
			controller.dodajRecept(naziv, opis, imgUrl, autor); 
		} catch(Exception e) {
			//izbaci dijalog il sta god...
			JOptionPane.showMessageDialog(this, "Nevalidan unos za novi recept");
			
		}
	}
	
	private void updateRecipe(String naziv, String opis, String imgUrl, String autor) {
		try {
			//controller 
			controller.updateRecept(naziv,opis,imgUrl,autor);
		} catch(Exception e) {
			//izbaci dijalog il sta god...
			JOptionPane.showMessageDialog(this, "Nevalidan unos za updatovani recept");
		}
//		if(userProfile.getTableOfRecipes().getSelectionModel().isSelectionEmpty()) {
//			return;
//		} else {
//			//TO DO - staviti info
//			addRecipe.getRecipeName().setText("naziv");
//			addRecipe.getDescription().setText("kuvaj levo kuvaj desno");
//			addRecipe.getImageUrl().setText("slika.jpg");
//			JOptionPane.showMessageDialog(this,addRecipe,"Dodaj recept",JOptionPane.INFORMATION_MESSAGE);
//		}
	}
	
	private void changePanel(JPanel current, JPanel panelToSet) {
		scroll.getViewport().remove(current);
		scroll.getViewport().add(panelToSet);
		
		scroll.revalidate();
		scroll.repaint();
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	
}
