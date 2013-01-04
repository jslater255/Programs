package GUI;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class OutGrid extends JPanel{
	
	GridDraw gD = new GridDraw();
	
	
	public OutGrid(){
		this.setSize(new Dimension(400, 400));
		//this.setMinimumSize(minSize);
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gD.draw(g);
	}

	public GridDraw getGD(){
		return gD;
	}
}
