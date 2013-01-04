import java.awt.Graphics;

public class Links {

	private int startA, startB, endA, endB;

	private String className, className1, rel, rel1;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName1() {
		return className1;
	}

	public void setClassName1(String className1) {
		this.className1 = className1;
	}

	public Links(String className, String className1, int a, int b, int c,
			int d, String p, String lName) {

		this.className = className;
		startA = a;
		startB = b;

		this.className1 = className1;
		endA = c;
		endB = d;

		rel = p;
		rel1 = lName;
	}

	public void draw(Graphics g) {
		linkPos();
		if ((startA < endA) && (startB < endB)) {
			g.drawString(rel, endA + 10, endB + 10);
			g.drawString(rel1, endA - 10, endB + 25);
		} else if ((startA > endA) && (startB > endB)) {
			g.drawString(rel, endA - 10, endB - 10);
			g.drawString(rel1, endA - 10, endB + 25);
		} else if ((startA > endA) && (startB < endB)) {
			g.drawString(rel, endA + 10, endB + 25);
			g.drawString(rel1, endA - 10, endB + 25);
		} else if ((startA < endA) && (startB > endB)) {
			g.drawString(rel, endA - 10, endB - 10);
			g.drawString(rel1, endA - 10, endB + 25);
		}

		g.drawLine(startA, startB, endA, endB);
	}

	public void updateCord1(int x, int y) {
		startA = x;
		startB = y;

	}

	public void updateCord2(int x, int y) {
		endA = x;
		endB = y;

	}

	public void linkPos() {

		if ((startA < endA) && (startB < endB)) {
			startA = startA + 100;
			startB = startB + 100;

		} else if ((startA > endA) && (startB < endB)) {
			endA = endA + 100;
			startB = startB + 100;

		} else if ((startA > endA) && (startB > endB)) {
			endA = endA + 100;
			endB = endB + 100;

		} else if ((startA < endA) && (startB > endB)) {

			endB = endB + 100;
			startA = startA + 100;

		}
	}
}
