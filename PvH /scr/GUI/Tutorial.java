package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Tutorial extends JFrame implements ActionListener {

	private int page = 0;
	private JButton pre, nxt;
	private JLabel pg1 = new JLabel("1");
	private JLabel pg2 = new JLabel("2");

	public Tutorial() {

		this.add(pg1, BorderLayout.NORTH);

		pre = new JButton("Previous");
		this.add(pre, BorderLayout.CENTER);
		pre.addActionListener(this);

		nxt = new JButton("Next");
		this.add(nxt, BorderLayout.SOUTH);
		nxt.addActionListener(this);

		this.setTitle("Player vs Hunters");
		this.setLocation(100, 150);
		this.setSize(new Dimension(440, 900));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(2, 1));
		setVisible(true);
		this.setLayout(new BorderLayout());

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String aC = e.getActionCommand();

		if (aC.equals("Next")) {
			pg1 = pg2;
			this.repaint();

		}
	}
}
