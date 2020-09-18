package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddRecipe extends JPanel {
	private JTextField recipeName;
	private JTextArea description;
	private JTextField imageUrl;
	
	public AddRecipe() {
		initComponents();
	}
	
	private void initComponents() {
		recipeName = new JTextField(20);
		description = new JTextArea(10,20);
		imageUrl = new JTextField(20);
		
		description.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(description); 

		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,3,3);
		gbc.ipady = 10;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Naziv:"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(recipeName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("URL slike:"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(imageUrl, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Opis:"), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(scrollPane, gbc);
		
		
		
	}

	public JTextField getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(JTextField recipeName) {
		this.recipeName = recipeName;
	}

	public JTextArea getDescription() {
		return description;
	}

	public void setDescription(JTextArea description) {
		this.description = description;
	}

	public JTextField getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(JTextField imageUrl) {
		this.imageUrl = imageUrl;
	}

	
}
