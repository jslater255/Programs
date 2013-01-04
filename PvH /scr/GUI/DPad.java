package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Lionheart.level;

public class DPad extends JPanel implements ActionListener {

	private JButton up, down, left, right, dum, pause;
	private level l1;
	private GridDraw gD;
	private OutGrid oG;
	private DPadKeyListener dPK;

	private Timer timer;

	public DPad(level l1, OutGrid oG) {

		this.oG = oG;
		this.gD = oG.getGD();
		dPK = new DPadKeyListener(l1, oG.getGD(), oG);
		this.l1 = l1;

		this.setPreferredSize(new Dimension(100, 100));
		this.setLayout(new GridLayout(3, 3));

		
		
		this.addKeyListener(dPK);
		this.requestFocusInWindow();
		
		dum = new JButton("");
		this.add(dum);

		up = new JButton("Up");
		this.add(up);
		up.addActionListener(this);

		dum = new JButton("");
		this.add(dum);

		left = new JButton("Left");
		this.add(left);
		left.addActionListener(this);

		pause = new JButton("Pause");
		this.add(pause);
		pause.addActionListener(this);

		right = new JButton("Right");
		this.add(right);
		right.addActionListener(this);

		dum = new JButton("");
		this.add(dum);

		down = new JButton("Down");
		this.add(down);
		down.addActionListener(this);

		dum = new JButton("");
		this.add(dum);
		timer = new Timer();
		timer.schedule(l1, 1000, 1 * 500);
		

	}

	public void actionPerformed(ActionEvent e) {

		String aC = e.getActionCommand();

		if (aC.equals("Up")) {
			gD.updateP(l1.movePly("up"));
			l1.checkStrength();
			oG.repaint();

		} else if (aC.equals("Down")) {
			gD.updateP(l1.movePly("down"));
			l1.checkStrength();
			oG.repaint();

		} else if (aC.equals("Left")) {
			gD.updateP(l1.movePly("left"));
			l1.checkStrength();
			oG.repaint();

		} else if (aC.equals("Right")) {
			gD.updateP(l1.movePly("right"));
			l1.checkStrength();
			oG.repaint();

		} else if (aC.equals("Pause")) {
			l1.pauseGame();

		}
	}
}
