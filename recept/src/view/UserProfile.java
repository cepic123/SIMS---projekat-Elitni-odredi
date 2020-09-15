package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controler.Azuriranje;
import model.*;

public class UserProfile extends JPanel implements ActionListener{
	private ImageHolder image;
	private JTextField username;
	private JTextField fullName;
	private JPasswordField password;
	private JButton changePhoto;
	private JButton changeInfo;
	private JButton applyChange;
	RecipesTable tableOfRecipes;
	private JButton createRecipe;
	private JButton updateRecipe;
	private JButton deleteRecipe;
	private Azuriranje az = new Azuriranje(new ArrayList<Korisnik>());
	
	
	public UserProfile() {
		
		initComponents();
	}
	
	
	private void initComponents() {
		
		image = new ImageHolder();
		image.setImage("images/markuza.png");
	    
	    
	    username = new JTextField(20);
	    username.setEditable(false);
	    
	    fullName = new JTextField(20);
	    fullName.setEditable(false);
	    
	    password = new JPasswordField(20);
	    password.setEditable(false);
	    
	    createRecipe = new JButton("Dodaj recept");
		updateRecipe = new JButton("Izmeni recept");
		deleteRecipe = new JButton("Obrisi recept");
	    
	    changePhoto = new JButton("Promeni profilnu fotografiju");
	    changeInfo = new JButton("Promeni podatke");
	    applyChange = new JButton("Sacuvaj promene");
	    
	    tableOfRecipes = new RecipesTable();
	    
	    manageLayout();
	    
	    setActionListeners();
	}
	
	private void setActionListeners() {
		changeInfo.addActionListener(this);
		applyChange.addActionListener(this);
	}
	
	private void manageLayout() {
		JLabel usernameL = new JLabel("Korisnicko ime:");
		JLabel fullNameL = new JLabel("Puno ime:");
		JLabel passwordL = new JLabel("Lozinka:");
		JLabel userRecipesL = new JLabel("Moji recepti");
	    userRecipesL.setFont(new Font("Serif", Font.PLAIN, 24));
	    
	    JScrollPane scrollPane = new JScrollPane(tableOfRecipes);
	    scrollPane.setPreferredSize(new Dimension(700,200));
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.ipady = 10;
		gbc.insets = new Insets(10,3,3,3);
		gbc.weightx = 1.0;
		
		gbc.gridwidth = 5;
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    add(image, gbc);
	    
	    gbc.gridwidth = 1;
		gbc.gridx = 2;
	    gbc.gridy = 1;
	    add(changePhoto, gbc);
	    
	    gbc.insets = new Insets(10,0,0,0);
	    
	    gbc.gridwidth = 1;
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    add(usernameL, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 2;
	    add(username, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    add(fullNameL, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 3;
	    add(fullName, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    add(passwordL, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 4;
	    add(password, gbc);
	    
	    gbc.insets = new Insets(20,0,0,0);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    add(changeInfo, gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridy = 5;
	    add(applyChange, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 6;
	    add(userRecipesL, gbc);
	    
	    gbc.gridwidth = 5;
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    add(scrollPane, gbc);
	    
	    gbc.gridwidth = 1;
	    gbc.gridx = 1;
	    gbc.gridy = 8;
	    add(createRecipe, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 8;
	    add(updateRecipe, gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridy = 8;
	    add(deleteRecipe, gbc);
	    
//		updateRecipe = new JButton("Izmeni recept");
//		deleteRecipe = new JButton("Obrisi recept");
	}
	
	void setData(Korisnik korisnik) {
		//prosledjivanje strukture podataka tipa Korisnik i uzimanje podataka 
		username.setText(korisnik.getUsername());
		fullName.setText(korisnik.getIme()+" "+korisnik.getPrezime());
		password.setText(korisnik.getPassword());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton)e.getSource();
		if(clicked == changeInfo) {
			username.setEditable(false);
		    fullName.setEditable(true);
		    password.setEditable(true);
		} else if(clicked == applyChange) {
			username.setEditable(false);
		    fullName.setEditable(false);
		    password.setEditable(false);
		    az.napuniKorisnike();
		    az.izmeniKorisnika(username.getText(), password.getText(), fullName.getText());
		    
		}
		
	}
	
	// TO DO 
	//Dodati action listener kad klikne na promeni podatke da setEditable bude true
}
