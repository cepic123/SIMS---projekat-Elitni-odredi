package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageHolder extends JPanel {
	private BufferedImage image;
	
	public ImageHolder() {
		
		setPreferredSize(new Dimension(400,250));
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,420, 300, this);      
    }
	
	public void setImage(String imgName) {
		try {                
	          image = ImageIO.read(new File(imgName));
	       } catch (IOException ex) {
	            
	    }
	}
}
