package GUI;

import java.awt.Graphics;

public class GridDraw {

	int w = 40;
	int h = 40;
	int tall = 400;
	int wide = 400;
	int scr = 0;
	int str = 5;
	int levNum = 1;
	int count = 0;
	String player = "P";
	String hunter = "H";
	String score = "Score: ";
	String strength = "Strength: ";
	String lvl = "Level: ";
	int[] hunPos = { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };

	int[] plyPos = { 0, 0 };

	public void draw(Graphics g) {

		// the verticals
		for (int i = 1; i < 11; i++) {
			g.drawLine(i * w, 40, i * w, tall);
		}
		// the horizontal
		for (int i = 1; i < 11; i++) {
			g.drawLine(40, i * h, wide, i * h);
		}

		g.drawString(player, 55 + (plyPos[0] * 40), 65 + (plyPos[1] * 40));
		while (count <= 8) {
			g.drawString(hunter, 55 + (hunPos[count] * 40),
					65 + (hunPos[count + 1] * 40));
			count = count + 2;
		}
		count=0;
		g.drawString(score + Integer.toString(scr), 45, 35);
		g.drawString(strength + Integer.toString(str), 150, 35);
		g.drawString(lvl + Integer.toString(levNum), 250, 35);

	}

	public void setLevNum(int levNum) {
		this.levNum = levNum;
	}

	public void updateH(int[] h) {
		this.hunPos = h;

	}

	public void updateP(int[] p) {
		this.plyPos[0] = p[0];
		this.plyPos[1] = p[1];
	}

	public void updateScr(int score2) {
		scr = score2;

	}

	public void updateStrength(int strengthOut) {
		this.str = strengthOut;
	}
}
