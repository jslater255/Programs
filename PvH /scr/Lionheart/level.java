package Lionheart;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.TimerTask;

import GUI.DPad;
import GUI.GridDraw;
import GUI.OutGrid;

public class level extends TimerTask {

	player p = new player();
	hunters h = new hunters();
	hunters2 h2 = new hunters2();
	highScore hS = new highScore();
	GridDraw gD;
	OutGrid oG;
	DPad dP;
	Toolkit toolkit;

	int strength = p.strengthOut();
	int score = h.score();
	int moves = 0;
	int moves2 = 0;

	public level(OutGrid oG, DPad dP) {
		this.dP = dP;
		gD = oG.getGD();
		this.oG = oG;
		toolkit = Toolkit.getDefaultToolkit();
	}

	public int[] movePly(String move) {
		return p.move(move);
	}

	@Override
	public void run() {
		gD.updateH(h.getH());

		if (strength > 1) {
			strength = p.strengthOut();
			toolkit.beep();
			if (score < 50) {
				moves++;
				h.path1();
				if (moves > 32) {
					gD.setLevNum(2);
					h.path2();
				}
				if (moves > 64) {
					gD.setLevNum(3);
					h.path3();
				}
				if (moves > 128) {
					gD.setLevNum(4);
					h.path4();
				}
				if (moves > 256) {
					gD.setLevNum(5);
					h.path5();
				}

				gD.updateH(h.getH());
				oG.repaint();
				checkStrength();
				gD.updateStrength(p.strengthOut());
				gD.updateScr(h.score());
				score = h.score();
				h.restart();
				h2.setScore(h.score());
				moves2 = moves;

			} else {
				gD.setLevNum(6);
				h2.path(p.getPos(), 0, 1);
				if ((moves - moves2) > 2) {
					h2.path(p.getPos(), 2, 3);
				}
				if ((moves - moves2) > 4) {
					h2.path(p.getPos(), 4, 5);
				}
				if ((moves - moves2) > 6) {
					h2.path(p.getPos(), 6, 7);
				}
				if ((moves - moves2) > 8) {
					h2.path(p.getPos(), 8, 9);

				}
				gD.updateH(h2.checkH2());
				oG.repaint();
				checkStrength();
				gD.updateScr(h2.score());
				score = h2.score();
				h2.restart();

			}
			moves++;
			gD.updateStrength(p.strengthOut());
			oG.repaint();
		} else {
			try {
				hS.checkHS(score);

				System.exit(0);
				this.cancel();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void checkStrength() {
		int[] plyPos = p.getPos();
		int[] hunPos = h.getH();
		int[] hunPos2 = h2.checkH2();
		int count = 0;
		int count2 = 0;

		while (count < 8) {
			if ((hunPos[count + 1] == plyPos[1])
					&& (hunPos[count] == plyPos[0])) {
				p.minusStr();
				h.resetHun(count);
			}
			count = count + 2;
		}
		while (count2 < 8) {
			if ((hunPos2[count2 + 1] == plyPos[1])
					&& (hunPos2[count2] == plyPos[0])) {
				p.minusStr();
				h2.resetHun(count2);
			}
			count2 = count2 + 2;
		}

	}

	public void pauseGame() {
		
	}

	public void resumeGame() {
		
	}
}
