import java.awt.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelMouse extends JPanel {

	private VectorBox vB;

	public PanelMouse() {
		vB = new VectorBox();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(1000, 500));

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		vB.drawAll(g);
	}

	public void addBox(int x, int y) {
		try {
			vB.addBox(x, y);
		} catch (Exception e) {
			System.out.println("Error");
		}
		repaint();

	}

	public Box findNearest(int a, int b) {
		return vB.findNearest(a, b);
	}

	public void setLink() {
		vB.setLink();
		repaint();
	}

	public void addMethod(String c, String m) {

		vB.addMethod(c, m);
		repaint();

	}

	public void addVariable(String c, String v) {

		vB.addVariable(c, v);
		repaint();

	}

	public void save() {
		vB.getClassInfo();
	}

	public void deleteMethod(String c, String m) {
		vB.deleteMethod(c, m);
		repaint();
	}

	public void dVariable(String c, String v) {
		vB.dVariable(c, v);
		repaint();

	}

	public void dClass(String c) {
		vB.dClass(c);

	}

	public void updateLink(Box thisOne) {
		vB.updateLinkName(thisOne);

	}

	public void removeAllData() {
		vB.removeAllData();
		repaint();

	}

	
	public void open() {
		vB.open();
		repaint();
	}
}
