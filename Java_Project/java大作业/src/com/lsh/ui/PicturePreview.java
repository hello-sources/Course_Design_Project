package com.lsh.ui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

@SuppressWarnings("serial")
public class PicturePreview extends JPanel {

	/**
	 * Create the panel.
	 */
	public PicturePreview() {
		

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		String path=String.format("picture/p%d.jpg",PictureCanvas.pictureID);
		Image img=new ImageIcon(path).getImage();
		g.drawImage(img, 10, 5, 330,440,this);
		
	}
}
