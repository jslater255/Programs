import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OptionListener extends JPanel implements ActionListener {

	private PanelOptions panelOption;
	private PanelMouse panelM;

	public OptionListener(PanelOptions pO, PanelMouse pm) {

		panelOption = pO;
		panelM = pm;

	}

	public void actionPerformed(ActionEvent e) {

		String actionCommand = e.getActionCommand();

		if (actionCommand.equals("Link")) {

			panelM.setLink();

		}

		else if (actionCommand.equals("Add Method")) {

			String[] choice = { "public", "private", "protected" };
			String[] type = { "void", "String", "int", "String[]", "int[]" };
			String[] type1 = { "", "String", "int", "String[]", "int[]" };

			JTextField xField = new JTextField(5);
			JTextField yField = new JTextField(5);
			JTextField iField = new JTextField(5);

			JPanel myPanel = new JPanel();
			JComboBox myPanel1 = new JComboBox(choice);
			JComboBox myPanel2 = new JComboBox(type);
			JComboBox inputPara = new JComboBox(type1);
			myPanel.add(new JLabel("Class Name:"));
			myPanel.add(xField);
			myPanel.add(Box.createVerticalStrut(15));
			myPanel.add(myPanel1);
			myPanel.add(new JLabel("Method Name:"));
			myPanel.add(yField);
			myPanel.add(new JLabel("Input Variable"));
			myPanel.add(inputPara);
			myPanel.add(new JLabel("Input Variable's Name"));
			myPanel.add(iField);
			myPanel.add(new JLabel("Return type: "));
			myPanel.add(myPanel2);

			JOptionPane.showConfirmDialog(null, myPanel, "Creating a Method",
					JOptionPane.PLAIN_MESSAGE);

			int g = myPanel1.getSelectedIndex();
			int h = myPanel2.getSelectedIndex();
			int j = inputPara.getSelectedIndex();
			String p = "";
			if (g == 0) {
				p = "+";
			} else if (g == 1) {
				p = "-";
			} else if (g == 2) {
				p = "#";
			}

			String c = xField.getText();
			String m = p + yField.getText() + "(" + type1[j] + iField.getText()
					+ "):" + type[h];

			panelM.addMethod(c, m);

		} else if (actionCommand.equals("Add Variable")) {

			String[] choice = { "public", "private", "protected" };
			String[] type = { "String", "int", "String[]", "int[]" };

			JTextField xField = new JTextField(5);
			JTextField yField = new JTextField(5);

			JPanel myPanel = new JPanel();
			JComboBox myPanel1 = new JComboBox(choice);
			JComboBox myPanel2 = new JComboBox(type);
			myPanel.add(new JLabel("Class Name:"));
			myPanel.add(xField);
			myPanel.add(Box.createVerticalStrut(15)); // a spacer
			myPanel.add(myPanel1);
			myPanel.add(myPanel2);
			myPanel.add(new JLabel("Variable Name:"));
			myPanel.add(yField);

			JOptionPane.showConfirmDialog(null, myPanel, "Creating a Variable",
					JOptionPane.PLAIN_MESSAGE);

			int g = myPanel1.getSelectedIndex();
			int h = myPanel2.getSelectedIndex();
			String p = "";
			if (g == 0) {
				p = "+";
			} else if (g == 1) {
				p = "-";
			} else if (g == 2) {
				p = "#";
			}

			String c = xField.getText();
			String v = p + type[h] + ":" + yField.getText();
			// System.out.println(v);
			panelM.addVariable(c, v);

		} else if (actionCommand.equals("Delete Methods")) {
			System.out.println("deleted Method");

			String[] choice = { "public", "private", "protected" };
			String[] type = { "void", "String", "int", "String[]", "int[]" };

			JTextField xField = new JTextField(5);
			JTextField yField = new JTextField(5);

			JPanel myPanel = new JPanel();
			JComboBox myPanel1 = new JComboBox(choice);
			JComboBox myPanel2 = new JComboBox(type);
			myPanel.add(new JLabel("Class Name:"));
			myPanel.add(xField);
			myPanel.add(Box.createVerticalStrut(15));
			myPanel.add(myPanel1);
			myPanel.add(new JLabel("Method Name:"));
			myPanel.add(yField);
			myPanel.add(new JLabel("Return type: "));
			myPanel.add(myPanel2);

			JOptionPane.showConfirmDialog(null, myPanel, "Delete a Method",
					JOptionPane.PLAIN_MESSAGE);

			int g = myPanel1.getSelectedIndex();
			int h = myPanel2.getSelectedIndex();
			String p = "";
			if (g == 0) {
				p = "+";
			} else if (g == 1) {
				p = "-";
			} else if (g == 2) {
				p = "#";
			}

			String c = xField.getText();
			String m = p + yField.getText() + "():" + type[h];
			panelM.deleteMethod(c, m);
		} else if (actionCommand.equals("Delete Variable")) {
			String[] choice = { "public", "private", "protected" };
			String[] type = { "String", "int", "String[]", "int[]" };

			JTextField xField = new JTextField(5);
			JTextField yField = new JTextField(5);

			JPanel myPanel = new JPanel();
			JComboBox myPanel1 = new JComboBox(choice);
			JComboBox myPanel2 = new JComboBox(type);
			myPanel.add(new JLabel("Class Name:"));
			myPanel.add(xField);
			myPanel.add(Box.createVerticalStrut(15)); // a spacer
			myPanel.add(myPanel1);
			myPanel.add(myPanel2);
			myPanel.add(new JLabel("Variable Name:"));
			myPanel.add(yField);

			JOptionPane.showConfirmDialog(null, myPanel, "Deleting a Variable",
					JOptionPane.PLAIN_MESSAGE);

			int g = myPanel1.getSelectedIndex();
			int h = myPanel2.getSelectedIndex();
			String p = "";

			if (g == 0) {
				p = "+";
			} else if (g == 1) {
				p = "-";
			} else if (g == 2) {
				p = "#";
			}

			String c = xField.getText();
			String v = p + " " + type[h] + " : " + yField.getText();
			System.out.println(v);
			panelM.dVariable(c, v);
		} else if (actionCommand.equals("Delete Class")) {

			JTextField xField = new JTextField(5);
			JPanel myPanel = new JPanel();
			myPanel.add(new JLabel("Class Name:"));
			myPanel.add(xField);

			JOptionPane.showConfirmDialog(null, myPanel, "Deleting a Variable",
					JOptionPane.PLAIN_MESSAGE);

			String c = xField.getText();

			panelM.dClass(c);
			panelM.repaint();
		}

	}
}
