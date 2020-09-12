package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserProfile extends JPanel {
	private ImageHolder image;
	private JTextField username;
	private JTextField fullName;
	private JPasswordField password;
	private JButton changePhoto;
	private JButton changeInfo;
	private JButton applyChange;
	
	public UserProfile() {
		
		initComponents();
	}
	
	private void initComponents() {
		
		image = new ImageHolder();
		image.setImage("images/markuza.png");
	    
	    JLabel usernameL = new JLabel("Korisnicko ime:");
	    username = new JTextField(20);
	    username.setEditable(false);
	    JLabel fullNameL = new JLabel("Puno ime:");
	    fullName = new JTextField(20);
	    fullName.setEditable(false);
	    JLabel passwordL = new JLabel("Lozinka:");
	    password = new JPasswordField(20);
	    password.setEditable(false);
	    
	    changePhoto = new JButton("Promeni profilnu fotografiju");
	    changeInfo = new JButton("Promeni podatke");
	    applyChange = new JButton("Sacuvaj promene");
	    
	    setData();
	    
	    GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.ipady = 10;
		gbc.insets = new Insets(10,3,3,3);
		
		
		gbc.gridwidth = 2;
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    add(image, gbc);
	    
	    gbc.gridwidth = 1;
		gbc.gridx = 1;
	    gbc.gridy = 1;
	    add(changePhoto, gbc);
	    
	    gbc.insets = new Insets(10,0,0,0);
	    
	    gbc.gridwidth = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    add(usernameL, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    add(username, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    add(fullNameL, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    add(fullName, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    add(passwordL, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    add(password, gbc);
	    
	    gbc.insets = new Insets(20,0,0,0);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    add(changeInfo, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    add(applyChange, gbc);
	}
	
	private void setData() {
		//prosledjivanje strukture podataka tipa Korisnik i uzimanje podataka 
		username.setText("Peki");
		fullName.setText("Zokijev Tigar");
		password.setText("tanjasavicjeekstra");
	}
	
	// TO DO 
	//Dodati action listener kad klikne na promeni podatke da setEditable bude true
}
