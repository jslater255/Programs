import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;

public class PanelOptions extends JPanel {

	private JButton link, methods, variable, dMethod, dVariable, dClass;

	public PanelOptions(PanelMouse pm) {

		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(100, 100));

		this.setLayout(new GridLayout(1, 10));

		OptionListener oP = new OptionListener(this, pm);

		link = new JButton("Link");
		this.add(link);
		link.addActionListener(oP);

		methods = new JButton("Add Method");
		this.add(methods);
		methods.addActionListener(oP);

		variable = new JButton("Add Variable");
		this.add(variable);
		variable.addActionListener(oP);

		dMethod = new JButton("Delete Methods");
		this.add(dMethod);
		dMethod.addActionListener(oP);

		dVariable = new JButton("Delete Variable");
		this.add(dVariable);
		dVariable.addActionListener(oP);

		dClass = new JButton("Delete Class");
		this.add(dClass);
		dClass.addActionListener(oP);

	}

}
