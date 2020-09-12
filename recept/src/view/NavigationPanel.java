package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class NavigationPanel extends JPanel {
	private JButton newsFeedButton;
	private JButton searchButton;
	private JButton profileButton;
	private JButton logOutButton;
	
	public NavigationPanel() {
		
		setPreferredSize(new Dimension(200,500));
		initComponents();
		
	}
	
	private void initComponents() {
		
		newsFeedButton = new JButton("Pocetna strana");
		searchButton = new JButton("Pretraga");
		profileButton = new JButton("Moj profil");
		logOutButton = new JButton("Odjavi se");
		
		newsFeedButton.setMaximumSize(new Dimension(200,50));
		searchButton.setMaximumSize(new Dimension(200,50));
		profileButton.setMaximumSize(new Dimension(200,50));
		logOutButton.setMaximumSize(new Dimension(200,50));
		
		Color lighterOrange = new Color(252, 223, 202);
		Color lightOrange   = new Color(255, 166, 111);
		
		Border buttonBorder = BorderFactory.createLineBorder(lightOrange);
		
		
		setBackground(lighterOrange);
		
		newsFeedButton.setBackground(Color.WHITE);
		newsFeedButton.setForeground(lightOrange);
		
		searchButton.setBackground(Color.WHITE);
		searchButton.setBorder(buttonBorder);
		profileButton.setBackground(Color.WHITE);
		profileButton.setBorder(buttonBorder);
		logOutButton.setBackground(Color.WHITE);
		logOutButton.setBorder(buttonBorder);
		
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		
		add(newsFeedButton);
		add(searchButton);
		add(profileButton);
		add(Box.createRigidArea(new Dimension(0, 360)));
		add(logOutButton);
		
	}

	public JButton getNewsFeedButton() {
		return newsFeedButton;
	}

	public void setNewsFeedButton(JButton newsFeedButton) {
		this.newsFeedButton = newsFeedButton;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public JButton getProfileButton() {
		return profileButton;
	}

	public void setProfileButton(JButton profileButton) {
		this.profileButton = profileButton;
	}

	public JButton getLogOutButton() {
		return logOutButton;
	}

	public void setLogOutButton(JButton logOutButton) {
		this.logOutButton = logOutButton;
	}
}
