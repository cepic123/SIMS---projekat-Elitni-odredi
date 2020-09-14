package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registration extends JPanel{
	private JTextField username;
	private JPasswordField password;
	private JTextField name;
	private JTextField surname;
	private JTextField email;
	private JButton submit;
	
	public Registration() {
		
		initComponents();
	}
	
	private void initComponents() {

		username = new JTextField(20);
		password = new JPasswordField(20);
		name = new JTextField(20);
		surname = new JTextField(20);
		email = new JTextField(20);
		submit = new JButton("Potvrda");
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,3,3);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Ime:"), gbc);
		
		gbc.ipady = 10;
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(name, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Prezime:"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(surname, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Korisnicko ime:"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(username, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(new JLabel("Lozinka:"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(password, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(new JLabel("Email:"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(email, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		add(submit, gbc);
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JTextField getUName() { //morala sam promeniti u getUName jer getName vec postoji
		return name;
	}

	public void setUName(JTextField name) {
		this.name = name;
	}

	public JTextField getSurname() {
		return surname;
	}

	public void setSurname(JTextField surname) {
		this.surname = surname;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}
	
	
}
