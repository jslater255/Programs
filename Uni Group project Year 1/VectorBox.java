import java.awt.*;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class VectorBox extends JPanel {

	FileSaver fS = new FileSaver();
	FileDecriptor fD = new FileDecriptor();
	private Vector<Box> boxes;
	private Vector<Links> linkNames;

	int a = 0, b = 0, c = 0, d = 0, w1 = 0, h1 = 0, w2 = 0, h2 = 0;

	// sets up the vectors
	public VectorBox() {
		boxes = new Vector<Box>();
		linkNames = new Vector<Links>();
	}

	// adds a box to the vector <Box>
	public void addBox(int a, int b) {
		// puts into the String name the name of the class that is returned from
		// the method getName()
		String name = getName();
		if (name != null) {
			boxes.add(new Box(a, b, name));
		}
	}

	// draws all
	public void drawAll(Graphics g) {

		Box currentBox;
		Links lin;

		for (int i = 0; i < boxes.size(); i++) {
			currentBox = (Box) (boxes.get(i));

			currentBox.draw(g);
		}
		for (int i = 0; i < linkNames.size(); i++) {
			lin = (Links) (linkNames.get(i));

			lin.draw(g);
		}
	}

	// returns the name of the class
	public String getName() {

		Box c;
		String name = JOptionPane.showInputDialog(null, "Enter Class Name: ",
				"Create a class", JOptionPane.PLAIN_MESSAGE);

		for (int i = 0; i < boxes.size(); i++) {
			c = (Box) (boxes.get(i));
			String n = c.getClassName();
			while (name.equalsIgnoreCase(n) || (name.isEmpty())) {
				name = JOptionPane.showInputDialog(null, "Enter Class Name: ",
						"Create a class", JOptionPane.PLAIN_MESSAGE);
			}
		}
		return name;
	}

	// finds nearest class/box
	public Box findNearest(int a, int b) {

		Box c;
		double minDist = Double.MAX_VALUE;
		int minDistIndex = -1;

		for (int i = 0; i < boxes.size(); i++) {
			c = (Box) (boxes.get(i));
			if (c.distanceTo(a, b) < minDist) {
				minDist = c.distanceTo(a, b);
				minDistIndex = i;
			}
		}
		if ((minDistIndex >= 0) && (minDist < 30)) {
			return boxes.get(minDistIndex);
		}
		return null;
	}

	// gets info to set a link
	public void setLink() {

		JTextField xField = new JTextField(5);
		JTextField yField = new JTextField(5);
		JTextField tField = new JTextField(5);

		String[] type = { "Zero to one", "Zero to Many", "One to Many" };

		JPanel myPanel = new JPanel();

		this.setLayout(new GridLayout(1, 2));

		JComboBox rType = new JComboBox(type);
		myPanel.add(new JLabel("Enter Class Name:"));
		myPanel.add(xField);

		myPanel.add(rType);
		myPanel.add(new JLabel("Link Name:"));
		myPanel.add(tField);

		myPanel.add(new JLabel("Link to:"));
		myPanel.add(yField);

		JOptionPane.showConfirmDialog(null, myPanel, "Creating a Method",
				JOptionPane.PLAIN_MESSAGE);

		String name1 = xField.getText();
		String name2 = yField.getText();
		String lName = "-" + tField.getText();
		int option = rType.getSelectedIndex();
		String p = "";

		if (option == 0) {
			p = "0..1";

		} else if (option == 1) {
			p = "0..*";
		} else if (option == 2) {
			p = "1..*";
		}

		linkNames(name1, name2, p, lName);
	}

	// makes a new link in the vector
	public void linkNames(String className, String className2, String p,
			String lName) {

		Box bo;

		String box1;
		Box box11 = null;
		Box box22 = null;
		// int a = 0, b = 0, c = 0, d = 0,w1=0,h1=0,w2=0,h2=0;

		for (int i = 0; i < boxes.size(); i++) {

			bo = (Box) (boxes.get(i));

			box1 = bo.getClassName();

			if (className.equalsIgnoreCase(box1)) {
				box11 = boxes.get(i);
			}
			if (className2.equalsIgnoreCase(box1)) {
				box22 = boxes.get(i);
			}
		}
		bo = box11;
		a = bo.getX();
		b = bo.getY();
		w1 = bo.getWidth();
		h1 = bo.getHeight();
		bo = box22;
		w2 = bo.getWidth();
		h2 = bo.getHeight();
		c = bo.getX();
		d = bo.getY();

		//linkPos();
		linkNames.add(new Links(className, className2, a, b, c, d, p, lName));

	}

	// find the positions of the class and sets which corner the class will
	// attach to
	public void linkPos() {

		if ((a < c) && (b < d)) {
			a = a + w1;
			b = b + h1;

		} 
		else if ((a > c) && (b < d)) {
			c = c + w2;
			b = b + h1;

		} 
		else if ((a > c) && (b > d)) {
			c = c + w2;
			d = d + h2;

		} 
		else if ((a < c) && (b > d)) {

			d = d + h2;
			a = a + w1;

		}
	}

	// problem here!!
	public void updateLinkName(Box box) {
		Links links;
		Box bo;
		
		for (int i = 0; i < linkNames.size(); i++) {
			links = (Links) (linkNames.get(i));
			String n2 = links.getClassName1();
			String n1 = links.getClassName();
			for (int o = 0; o < boxes.size(); o++) {

				bo = box;

				if (n1.equalsIgnoreCase(bo.getClassName())) {
					a = bo.getX();
					b = bo.getY();
					
					//linkPos();
					links.updateCord1(a, b);
					links.updateCord2(c, d);

				}
				if (n2.equalsIgnoreCase(bo.getClassName())) {

					c = bo.getX();
					d = bo.getY();
					//linkPos();
					links.updateCord2(c, d);
					links.updateCord1(a, b);
				
				}
			}

		}
	}

	// add a method
	public void addMethod(String c, String m) {
		Box bo;
		for (int i = 0; i < boxes.size(); i++) {
			bo = (Box) (boxes.get(i));
			if (bo.getClassName().equalsIgnoreCase(c)) {
				bo.addMethods(m);
			}
		}
	}

	// add a variable
	public void addVariable(String c, String v) {
		Box bo;
		for (int i = 0; i < boxes.size(); i++) {
			bo = (Box) (boxes.get(i));
			if (bo.getClassName().equalsIgnoreCase(c)) {
				bo.addVariables(v);
			}
		}
	}

	// save the images
	public void getClassInfo() {
		Box bo;
		ArrayList<String> infoM = new ArrayList<String>();
		ArrayList<String> infoV = new ArrayList<String>();
		String stri = "";
		for (int i = 0; i < boxes.size(); i++) {
			bo = (Box) (boxes.get(i));
			infoM = bo.getMethods();
			infoV = bo.getVariables();
			stri = bo.getClassName();

			for (int y = 0; y < infoV.size(); y++) {
				stri = stri + " 1" + infoV.get(y);
			}
			for (int z = 0; z < infoM.size(); z++) {
				stri = stri + " 2" + infoM.get(z);
			}
			System.out.println(stri);
			fS.stringSpliter(stri);

		}
	}

	// delete a method
	public void deleteMethod(String c, String m) {
		Box bo;
		for (int i = 0; i < boxes.size(); i++) {
			bo = (Box) (boxes.get(i));
			if (bo.getClassName().equalsIgnoreCase(c)) {
				bo.removeMethod(m);
			} else {
				JPanel myPanel = new JPanel();
				myPanel.setLayout(new GridLayout(5, 1));
				JLabel title = new JLabel("Error- class not found");
				myPanel.add(title);
				JOptionPane.showConfirmDialog(null, myPanel, "About",
						JOptionPane.PLAIN_MESSAGE);

			}
		}
	}

	// delete a variable
	public void dVariable(String c, String v) {
		Box bo;
		for (int i = 0; i < boxes.size(); i++) {
			bo = (Box) (boxes.get(i));
			if (bo.getClassName().equalsIgnoreCase(c)) {
				bo.removeVariable(v);
			} else {
				JPanel myPanel = new JPanel();
				myPanel.setLayout(new GridLayout(5, 1));
				JLabel title = new JLabel("Error- class not found");
				myPanel.add(title);
				JOptionPane.showConfirmDialog(null, myPanel, "About",
						JOptionPane.PLAIN_MESSAGE);

			}
		}
	}

	// delete a class
	public void dClass(String c) {

		Box bo;
		Links lin;
		for (int i = 0; i < boxes.size(); i++) {
			bo = (Box) (boxes.get(i));
			if (bo.getClassName().equalsIgnoreCase(c)) {
				boxes.remove(i);
			}

		}
		for (int i = 0; i < linkNames.size(); i++) {
			lin = (Links) (linkNames.get(i));
			if (lin.getClassName().equalsIgnoreCase(c)
					|| (lin.getClassName().equalsIgnoreCase(c))) {
				linkNames.remove(i);
			}

		}

	}

	public void removeAllData() {
		boxes.removeAllElements();
		linkNames.removeAllElements();

	}

	public void open() {

		String name = getName();

		try {
			fD.readFile(name);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No Class Called - " + name,
					"ERROR", JOptionPane.PLAIN_MESSAGE);
		}
		System.out.println(fD.getInfo());
		reload(fD.getInfo());
	}

	public void reload(String s) {
		Box bo;
		String delims = " ";
		String[] tokens = s.split(delims);
		boxes.add(new Box(100, 100, tokens[0]));

		for (int i = 0; i < boxes.size(); i++) {
			bo = (Box) (boxes.get(i));

			if (bo.getClassName().equalsIgnoreCase(tokens[0])) {

				for (int a = 1; a < tokens.length; a++) {

					if (tokens[a].charAt(0) == '1') {
						System.out.println(tokens[i]);
						bo.addVariables(tokens[a].substring(a));
					} 
					else if (tokens[a].charAt(0) == '2') {
						System.out.println(tokens[a]);
						bo.addMethods(tokens[a].substring(2));
					}
				}
			}
		}
	}

}
