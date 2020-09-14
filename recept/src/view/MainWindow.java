package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Aplikacija;
import model.Korisnik;
import model.Recept;

public class MainWindow extends JFrame implements ActionListener {
	private NavigationPanel navigationBar = new NavigationPanel("Pregled",
			"Registracija","Prijava","Exit");
	private JScrollPane scroll;
	private NewsFeed newsFeed = new NewsFeed();
	private Login loginPanel = new Login();
	private Registration registrationPanel = new Registration();
	private int current;
	private Color lightOrange   = new Color(255, 166, 111);
	
	static Aplikacija aplikacija = new Aplikacija("Naziv","domen",new ArrayList<Korisnik>(), new ArrayList<Recept>());
	
	public MainWindow() {
		
		initComponents();
		
	}
	
	private void initComponents() {
		setSize(1000,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		scroll = new JScrollPane(newsFeed);
		scroll.getVerticalScrollBar().setUnitIncrement(14);
		
		add(navigationBar, BorderLayout.WEST);
		add(scroll, BorderLayout.CENTER);
		
		current = 0;
		
		navigationBar.getFirstButton().addActionListener(this);
		navigationBar.getSecondButton().addActionListener(this);
		navigationBar.getThirdButton().addActionListener(this);
		navigationBar.getFourthButton().addActionListener(this);
		
	}
	
	private JPanel getCurrentComponent() {
		if(current == 0) {
			navigationBar.getFirstButton().setForeground(Color.black);
			return newsFeed;
		} else if(current == 1) {
			navigationBar.getSecondButton().setForeground(Color.black);
			return registrationPanel;
		} else if(current == 2){
			navigationBar.getThirdButton().setForeground(Color.black);
			return loginPanel;
		} 
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		JPanel currentPanel = getCurrentComponent();
		
		if(clicked == navigationBar.getFirstButton()) {
			navigationBar.getFirstButton().setForeground(lightOrange);
			changePanel(currentPanel, newsFeed);
			current = 0;
		} else if(clicked == navigationBar.getSecondButton()) {
			navigationBar.getSecondButton().setForeground(lightOrange);
			changePanel(currentPanel, registrationPanel);
			current = 1;
		} else if(clicked == navigationBar.getThirdButton()) {
			navigationBar.getThirdButton().setForeground(lightOrange);
			changePanel(currentPanel, loginPanel);
			current = 2;
		} else if(clicked == loginPanel.getSubmit()) {
			if(aplikacija.ulogujSe(loginPanel.getUsername().getText(),loginPanel.getPassword().getText()) == true) {
		    	//	JOptionPane.showInternalMessageDialog(,"Uspesno ste se ulogovali u ");
		    		 AppWindow mw = new AppWindow(aplikacija.getUlogovan());
		      		 mw.setVisible(true);
		      		 dispose();
		    	}
		} else if(clicked == registrationPanel.getSubmit()) {
			aplikacija.registrujKorisnika(registrationPanel.getSurname().getText(),registrationPanel.getUName().getText(),registrationPanel.getUsername().getText(),registrationPanel.getPassword().getText(),registrationPanel.getEmail().getText());
			changePanel(currentPanel, loginPanel);
			current = 2;
		}
		
		else {
			System.exit(0);
		}
	}
	
	private void changePanel(JPanel current, JPanel panelToSet) {
		scroll.getViewport().remove(current);
		scroll.getViewport().add(panelToSet);
		
		scroll.revalidate();
		scroll.repaint();
	}
}