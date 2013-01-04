package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class GreetingWindow extends JFrame implements ActionListener{
	
		private JMenuBar mb = new JMenuBar();;
		private JMenu help, file, admin;
		private JMenuItem quit, New1, save, clear, about, open;
		
		
		private GreetingMessage gM = new GreetingMessage();
		private Choices cho = new Choices(this);
		
	public GreetingWindow(){

		this.setJMenuBar(mb);
		this.add(gM, BorderLayout.NORTH);
		this.add(cho, BorderLayout.SOUTH);

		this.setTitle("Player vs Hunters");
		this.setLocation(100, 150);
		this.setSize(new Dimension(440, 900));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(2, 1));
		setVisible(true);
		
		this.repaint();
		
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	}
	
