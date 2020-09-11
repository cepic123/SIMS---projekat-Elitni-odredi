package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class AppWindow extends JFrame{
	private NavigationPanel navigationBar = new NavigationPanel();
	private NewsFeed newsFeed = new NewsFeed();
	
	public AppWindow() {
		
		setSize(1000,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JScrollPane scroll = new JScrollPane(newsFeed);
		scroll.getVerticalScrollBar().setUnitIncrement(14);
		
		add(navigationBar, BorderLayout.WEST);
		add(scroll, BorderLayout.CENTER);
		
	}
}
