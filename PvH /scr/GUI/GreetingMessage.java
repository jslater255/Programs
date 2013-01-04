package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GreetingMessage extends JPanel {

	OutGM oGM = new OutGM();

	public GreetingMessage() {
		this.setSize(new Dimension(440, 900));
		this.setVisible(true);
		this.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		oGM.draw(g);
	}
}
