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
import model.Korisnik;
import model.Recept;

public class AppWindow extends JFrame implements ActionListener {
	
	Korisnik korisnik;
	private NavigationPanel navigationBar = new NavigationPanel("Pocetna strana",
			"Pretraga","Moj profil","Odjavi se");
	private NewsFeed newsFeed = new NewsFeed();
	private UserProfile userProfile = new UserProfile();
	private Search search = new Search();
	private int current;
	private JScrollPane scroll;
	private Color lightOrange   = new Color(255, 166, 111);
	private AddRecipe addRecipe;
	ArrayList<Recept> recepti = new ArrayList<Recept>();

	AddRecipec rc = new AddRecipec(recepti); 

	
	public AppWindow(Korisnik korisnik) {
		this.korisnik = korisnik;
		 rc.napuniRecepte();

		setSize(1000,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		scroll = new JScrollPane(newsFeed);
		scroll.getVerticalScrollBar().setUnitIncrement(14);
		userProfile.setData(korisnik);
		userProfile.tableOfRecipes.setData(korisnik.getMojiRecepti());
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
			MainWindow mw = new MainWindow();
     		mw.setVisible(true);
     		dispose();
		} else if(clicked == newsFeed.getAddRecipe()) {
			//iskoci dijalog
			 JOptionPane.showMessageDialog(this,addRecipe,"Dodaj recept",JOptionPane.INFORMATION_MESSAGE);
			 rc.dodajRecept(addRecipe.getRecipeName().getText(), addRecipe.getDescription().getText(), addRecipe.getImageUrl().getText(), korisnik.getUsername());
			 userProfile.tableOfRecipes.setData(korisnik.getMojiRecepti());
		} else if(clicked == userProfile.getCreateRecipe()) {
			JOptionPane.showMessageDialog(this,addRecipe,"Dodaj recept",JOptionPane.INFORMATION_MESSAGE);
			 rc.dodajRecept(addRecipe.getRecipeName().getText(), addRecipe.getDescription().getText(), addRecipe.getImageUrl().getText(), korisnik.getUsername());
			 userProfile.tableOfRecipes.setData(korisnik.getMojiRecepti());
		} else if(clicked == userProfile.getUpdateRecipe()) {
			//check if row is selected
			updateRecipe();
		}
	}
	
	private void updateRecipe() {
		if(userProfile.getTableOfRecipes().getSelectionModel().isSelectionEmpty()) {
			return;
		} else {
			//TO DO - staviti info
			addRecipe.getRecipeName().setText("naziv");
			addRecipe.getDescription().setText("kuvaj levo kuvaj desno");
			addRecipe.getImageUrl().setText("slika.jpg");
			JOptionPane.showMessageDialog(this,addRecipe,"Dodaj recept",JOptionPane.INFORMATION_MESSAGE);
		}
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
