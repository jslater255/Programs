import java.awt.event.*;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuListener implements ActionListener {

	private PanelMouse panelM;

	public MenuListener(PanelOptions pO, PanelMouse pm) {
		panelM = pm;
	}

	public void actionPerformed(ActionEvent e) {

		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Quit")){
			Object[] options = { "Yes", "No"};
			int n = JOptionPane.showOptionDialog(null,
					"Do you want to save before you quit?", "Save?",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			
			if(n==0){
			panelM.save();
			}
			System.exit(0);
		}
		else if (actionCommand.equals("About")) {
			JLabel title, who, date, copyRight;

			JPanel myPanel = new JPanel();
			myPanel.setLayout(new GridLayout(5, 1));
			title = new JLabel("Group Project - Version 1.1");
			who = new JLabel(
					"Created by- James Slater, Stoyko Kodzhabashev and Vicky Haxness");
			date = new JLabel("Created on the 9th March 2012");
			copyRight = new JLabel("Copyright © 2012. All Rights Reserved");
			myPanel.add(title);
			myPanel.add(who);
			myPanel.add(copyRight);
			myPanel.add(date);

			JOptionPane.showMessageDialog(null, myPanel, "About",
					JOptionPane.CLOSED_OPTION);

		} else if (actionCommand.equals("Save")) {
			panelM.save();

		} else if (actionCommand.equals("New")) {
			Frame f = new Frame();
			f.setLocation(200, 200);
			
		} else if (actionCommand.equals("Clear")) {
			Object[] options = { "Yes", "No"};
			int n = JOptionPane.showOptionDialog(null,
					"Are you sure you want to clear?", "Clear",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			
			if(n==0){
			panelM.removeAllData();
			}
		
		} else if (actionCommand.equals("Open")) {
			panelM.open();

		}
	}

}
