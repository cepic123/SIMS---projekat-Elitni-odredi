package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class AppWindow extends JFrame implements ActionListener {
	
	private NavigationPanel navigationBar = new NavigationPanel();
	private NewsFeed newsFeed = new NewsFeed();
	private UserProfile userProfile = new UserProfile();
	private Search search = new Search();
	private int current;
	private JScrollPane scroll;
	private Color lightOrange   = new Color(255, 166, 111);
	
	public AppWindow() {
		
		setSize(1000,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		scroll = new JScrollPane(newsFeed);
		scroll.getVerticalScrollBar().setUnitIncrement(14);
		
		current = 0; //0 je newsfeed
		
		
		navigationBar.getNewsFeedButton().setForeground(lightOrange);
		add(navigationBar, BorderLayout.WEST);
		add(scroll, BorderLayout.CENTER);

		navigationBar.getProfileButton().addActionListener(this);
		navigationBar.getNewsFeedButton().addActionListener(this);
		navigationBar.getSearchButton().addActionListener(this);
	}
	
	private JPanel getCurrentComponent() {
		if(current == 0) {
			navigationBar.getNewsFeedButton().setForeground(Color.black);
			return newsFeed;
		} else if(current == 1) {
			navigationBar.getProfileButton().setForeground(Color.black);
			return userProfile;
		} else if(current == 2){
			navigationBar.getSearchButton().setForeground(Color.black);
			return search;
		} else  {
			return new JPanel();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton)e.getSource();
		JPanel currentPanel = getCurrentComponent();
		
		if(clicked == navigationBar.getProfileButton()) {
			changePanel(currentPanel, userProfile);
			navigationBar.getProfileButton().setForeground(lightOrange);
			current = 1;
		} else if(clicked == navigationBar.getNewsFeedButton()) {
			changePanel(currentPanel, newsFeed);
			navigationBar.getNewsFeedButton().setForeground(lightOrange);
			current = 0;
		} else if(clicked == navigationBar.getSearchButton()) {
			changePanel(currentPanel, search);
			navigationBar.getSearchButton().setForeground(lightOrange);
			current = 2;
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
