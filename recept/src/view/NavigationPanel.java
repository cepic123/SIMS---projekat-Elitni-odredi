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
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton;
	private JButton fourthButton;
	
	public NavigationPanel(String first_buttonS, String second_buttonS, String third_buttonS, 
			String fourth_buttonS) {
		
		firstButton = new JButton(first_buttonS); //newsf
		secondButton = new JButton(second_buttonS); //searc
		thirdButton = new JButton(third_buttonS); //profile
		fourthButton = new JButton(fourth_buttonS); //logout
		
		setPreferredSize(new Dimension(200,500));
		initComponents();
		
	}
	
	private void initComponents() {
		
		
		
		firstButton.setMaximumSize(new Dimension(200,50));
		secondButton.setMaximumSize(new Dimension(200,50));
		thirdButton.setMaximumSize(new Dimension(200,50));
		fourthButton.setMaximumSize(new Dimension(200,50));
		
		Color lighterOrange = new Color(252, 223, 202);
		Color lightOrange   = new Color(255, 166, 111);
		
		Border buttonBorder = BorderFactory.createLineBorder(lightOrange);
		
		
		setBackground(lighterOrange);
		
		firstButton.setBackground(Color.WHITE);
//		newsFeedButton.setForeground(lightOrange);
		
		secondButton.setBackground(Color.WHITE);
		secondButton.setBorder(buttonBorder);
		thirdButton.setBackground(Color.WHITE);
		thirdButton.setBorder(buttonBorder);
		fourthButton.setBackground(Color.WHITE);
		fourthButton.setBorder(buttonBorder);
		
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		
		add(firstButton);
		add(secondButton);
		add(thirdButton);
		add(Box.createRigidArea(new Dimension(0, 360)));
		add(fourthButton);
		
	}

	public JButton getFirstButton() {
		return firstButton;
	}

	public void setFirstButton(JButton firstButton) {
		this.firstButton = firstButton;
	}

	public JButton getSecondButton() {
		return secondButton;
	}

	public void setSecondButton(JButton secondButton) {
		this.secondButton = secondButton;
	}

	public JButton getThirdButton() {
		return thirdButton;
	}

	public void setThirdButton(JButton thirdButton) {
		this.thirdButton = thirdButton;
	}

	public JButton getFourthButton() {
		return fourthButton;
	}

	public void setFourthButton(JButton fourthButton) {
		this.fourthButton = fourthButton;
	}

	
}
