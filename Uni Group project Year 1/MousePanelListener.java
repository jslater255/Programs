import java.awt.event.*;

import javax.swing.*;

public class MousePanelListener implements MouseListener {

	PanelMouse panelM;
	PanelOptions panelO;

	public MousePanelListener(PanelMouse pM, PanelOptions pO) {
		panelM = pM;
		panelO = pO;
	}

	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isLeftMouseButton(e)) {
			panelM.addBox(e.getX(), e.getY());
		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}
