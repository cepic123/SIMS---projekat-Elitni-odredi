package view;

import java.awt.BorderLayout;
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
	private int current;
	private JScrollPane scroll;
	
	public AppWindow() {
		
		setSize(1000,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		scroll = new JScrollPane(newsFeed);
		scroll.getVerticalScrollBar().setUnitIncrement(14);
		
		current = 0; //0 je newsfeed
		add(navigationBar, BorderLayout.WEST);
		add(scroll, BorderLayout.CENTER);

		navigationBar.getProfileButton().addActionListener(this);
	}
	
	private JScrollPane getCurrentComponent() {
		if(current == 0) {
			
			return scroll;
		} else if(current == 1) {
			return new JScrollPane();
		} else {
			return new JScrollPane();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton)e.getSource();
		if(clicked == navigationBar.getProfileButton()) {
			System.out.println("sd");
			//JScrollPane curr = getCurrentComponent();
			remove(scroll);
			//removeComponent(curr);
			//remove(getCurrentComponent());
//			add(userProfile, BorderLayout.CENTER);
			current = 1;
		}
	}
	
	private void removeComponent(JScrollPane current) {
		remove(current);
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	
}
