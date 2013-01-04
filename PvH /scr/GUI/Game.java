package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import Lionheart.level;

public class Game extends JFrame implements ActionListener {

	private JMenuBar mb;
	private JMenu help, file, admin;
	private JMenuItem quit, New1, save, clear, about, open;

	private DPad dP;
	private OutGrid oG;
	private level l1;
	private DPadKeyListener dPK;

	public Game(String sel) {

		oG = new OutGrid();
		l1 = new level(oG, dP);

		if (sel.equals("Level 1")) {
			
			dP = new DPad(l1, oG);
			this.add(oG);
			this.add(dP);
			
		}
		l1 = new level(oG, dP);

		mb = new JMenuBar();
		this.setJMenuBar(mb);

		file = new JMenu("File");
		mb.add(file);

		admin = new JMenu("Admin");
		mb.add(admin);

		help = new JMenu("Help");
		mb.add(help);

		quit = new JMenuItem("Quit");
		KeyStroke kS = KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask());
		quit.setAccelerator(kS);
		help.add(quit);
		quit.addActionListener(this);

		New1 = new JMenuItem("New");
		kS = KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask());
		file.add(New1);
		New1.setAccelerator(kS);
		New1.addActionListener(this);

		open = new JMenuItem("Open");
		file.add(open);
		open.addActionListener(this);

		save = new JMenuItem("Save");
		kS = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask());
		save.setAccelerator(kS);
		file.add(save);
		save.addActionListener(this);

		clear = new JMenuItem("Clear Receipt");
		kS = KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask());
		clear.setAccelerator(kS);
		admin.add(clear);
		clear.addActionListener(this);

		about = new JMenuItem("About");
		kS = KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask());
		about.setAccelerator(kS);
		file.add(about);
		about.addActionListener(this);

		this.setTitle("Player vs Hunters");
		this.setLocation(100, 150);
		this.setSize(new Dimension(440, 900));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(2, 1));
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		String actionCommand = e.getActionCommand();

		if (actionCommand.equals("Quit")) {
			System.exit(0);
		} else if (actionCommand.equals("About")) {
			JLabel title, who, date, copyRight;

			JPanel myPanel = new JPanel();
			myPanel.setLayout(new GridLayout(5, 1));
			title = new JLabel("Player Vs Hunters - Version 1.1");
			who = new JLabel("Created by- James Slater");
			date = new JLabel("Created on the Holiday");
			copyRight = new JLabel("Copyright © 2012. All Rights Reserved");
			myPanel.add(title);
			myPanel.add(who);
			myPanel.add(copyRight);
			myPanel.add(date);

			JOptionPane.showMessageDialog(null, myPanel, "About",
					JOptionPane.CLOSED_OPTION);

		} else if (actionCommand.equals("Save")) {

		} else if (actionCommand.equals("New")) {

		} else if (actionCommand.equals("Clear Receipt")) {

		} else if (actionCommand.equals("Open")) {

		}
	}
}
