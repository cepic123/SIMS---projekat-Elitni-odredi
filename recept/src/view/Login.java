package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {
	private JTextField username;
	private JPasswordField password;
	private JButton submit;
	
	public Login() {
		
		initComponents();
	}
	
	private void initComponents() {
		username = new JTextField(20);
		password = new JPasswordField(20);
		submit = new JButton("Potvrda");
		
		JLabel usernameL = new JLabel("Korisnicko ime:");
		JLabel passwordL = new JLabel("Lozinka:");
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,3,3);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(usernameL, gbc);
		
		gbc.ipady = 10;
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(username, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(passwordL, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(password, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
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

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}
	
	
}
