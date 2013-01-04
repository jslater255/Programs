import java.awt.event.*;

public class MousePostionsListener implements MouseMotionListener {

	PanelMouse panelM;
	PanelOptions panelO;

	public MousePostionsListener(PanelMouse pM, PanelOptions pO) {
		panelM = pM;
		panelO = pO;
	}

	public void mouseDragged(MouseEvent e) {
		
		Box thisOne = panelM.findNearest(e.getX(), e.getY());

		if (thisOne != null) {
			thisOne.update(e.getX(), e.getY());
			panelM.updateLink(thisOne);
		}
		panelM.repaint();
	}

	public void mouseMoved(MouseEvent e) {
		//panelM.repaint();
	}
}