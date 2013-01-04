import java.awt.*;
import java.util.ArrayList;

public class Box {

	private int x = 0;
	private int y = 0;
	private String className;
	private int width, height;
	private ArrayList<String> methods = new ArrayList<String>();
	private ArrayList<String> variables = new ArrayList<String>();

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ArrayList<String> getMethods() {
		return methods;
	}

	public ArrayList<String> getVariables() {
		return variables;
	}

	public Box(int a, int b, String name) {
		x = a;
		y = b;
		className = name;
	}

	public void draw(Graphics g) {

		setWidth();
		setHeight();

		
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		
		g.drawString(className, (x + 5), (y + 15));
		g.drawLine(x, y + 20, x + width, y + 20);
		g.drawLine(x, y + 25 + (variables.size() * 15), x + width, y + 25
				+ (variables.size() * 15));

		for (int i = 0; i < variables.size(); i++) {
			g.drawString(variables.get(i), (x + 5), (y + 35 + (i * 15)));

		}
		for (int i = 0; i < methods.size(); i++) {
			g.drawString(methods.get(i), (x + 5), (y + 40
					+ (variables.size() * 15) + (i * 15)));
		}

	}

	public void update(int a, int b) {
		this.x = a;
		this.y = b;
	}

	private int getLength() {
		int l = className.length();
		for (int i = 0; i < methods.size(); i++) {
			if (l < methods.get(i).length()) {
				l = methods.get(i).length();
			}
		}
		for (int i = 0; i < variables.size(); i++) {
			if (l < variables.get(i).length()) {
				l = variables.get(i).length();
			}
		}
		return l;
	}

	private void setWidth() {
		width = getLength() * 9;
		if (width <= 100) {
			width = 110;
		}

	}

	private void setHeight() {
		height = 35 + methods.size() * 15 + variables.size() * 15;
		if (height < 100) {
			height = 100;
		}

	}

	public int distanceTo(int x, int y) {
		return (Math.abs(this.x - x) + Math.abs(this.y - y));
	}

	public void addMethods(String m) {
		methods.add(m);
	}

	public void addVariables(String v) {
		variables.add(v);
	}

	public void removeMethod(String m) {
		for (int i = 0; i < methods.size(); i++) {
			if (methods.get(i).equalsIgnoreCase(m)) {
				System.out.println("Removed");
				methods.remove(i);

			}
		}
	}

	public void removeVariable(String v) {

		for (int i = 0; i < variables.size(); i++) {

			if (variables.get(i).equalsIgnoreCase(v)) {
				variables.remove(i);
			}
		}

	}
}
