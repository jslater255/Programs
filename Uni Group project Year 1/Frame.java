import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	PanelMouse pm = new PanelMouse();
	PanelOptions pO = new PanelOptions(pm);

	private JMenuBar mb = new JMenuBar();

	private JMenu optionMenu, file, edit;

	private JMenuItem quit, New1, save, clear, about, open;

	public Frame() {

		MenuListener mL = new MenuListener(pO, pm);
		// OptionListener oL=new OptionListener(pO);
		// pm.addActionListener(oL);

		MousePanelListener mPL = new MousePanelListener(pm, pO);
		pm.addMouseListener(mPL);

		MousePostionsListener mousePos = new MousePostionsListener(pm, pO);
		pm.addMouseMotionListener(mousePos);

		this.setJMenuBar(mb);
		add(pm, BorderLayout.CENTER);
		add(pO, BorderLayout.SOUTH);

		file = new JMenu("File");
		mb.add(file);

		edit = new JMenu("Edit");
		mb.add(edit);

		optionMenu = new JMenu("Options");
		mb.add(optionMenu);

		quit = new JMenuItem("Quit");
		KeyStroke kS = KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit
				.getDefaultToolkit().getMenuShortcutKeyMask());
		quit.setAccelerator(kS);
		optionMenu.add(quit);
		quit.addActionListener(mL);

		New1 = new JMenuItem("New");
		kS = KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask());
		file.add(New1);
		New1.setAccelerator(kS);
		New1.addActionListener(mL);

		open = new JMenuItem("Open");
		file.add(open);
		open.addActionListener(mL);

		save = new JMenuItem("Save");
		kS = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask());
		save.setAccelerator(kS);
		file.add(save);
		save.addActionListener(mL);

		clear = new JMenuItem("Clear");
		kS = KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask());
		clear.setAccelerator(kS);
		edit.add(clear);
		clear.addActionListener(mL);

		about = new JMenuItem("About");
		kS = KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit()
				.getMenuShortcutKeyMask());
		about.setAccelerator(kS);
		file.add(about);
		about.addActionListener(mL);

		// setSize(200,200);
		pack();
		setLocation(150, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Group Project");
		setVisible(true);

	}

}
