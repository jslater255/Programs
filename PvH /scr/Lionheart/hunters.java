package Lionheart;

public class hunters {

	private int score = 0;
	private int[] p = { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };

	public void path1() {
		int r = (int) (Math.random() * 2);

		if ((r == 0 && p[0] != 0) || ((r == 1 && p[1] == 0))) {
			p[0] = p[0] - 1;
		}

		else if ((r == 1 && p[1] != 0) || (r == 0 && p[0] == 0)) {
			p[1] = p[1] - 1;
		}
	}

	// restart() will test to see if any of the hunters are at top left p[r]
	// equals 0 and p[r+1] is equal to 1, then it will reset the two values back
	// to the bottom right of the grid 11,12 also it will add 1 onto score
	public void restart() {
		int r = 0;
		while (r != 9) {
			if (p[r + 1] == 0 && p[r] == 0) {
				p[r + 1] = 8;
				p[r] = 8;
				score++;
			}
			r++;
		}
	}

	// this is the same as path 1 but im using p[2] and p[3]
	public void path2() {
		int r = (int) (Math.random() * 2);

		if ((r == 0 && p[2] != 0) || ((r == 1 && p[3] == 0))) {
			p[2] = p[2] - 1;

		}

		else if ((r == 1 && p[3] != 0) || (r == 0 && p[2] == 0)) {
			p[3] = p[3] - 1;
		}
	}

	// this is the same as path 1 but im using p[4] and p[5]
	public void path3() {
		int r = (int) (Math.random() * 2);

		if ((r == 0 && p[4] != 0) || ((r == 1 && p[5] == 0))) {
			p[4] = p[4] - 1;
		}

		else if ((r == 1 && p[5] != 0) || (r == 0 && p[4] == 0)) {
			p[5] = p[5] - 1;
		}
	}

	// this is the same as path 1 but im using p[6] and p[7]
	public void path4() {
		int r = (int) (Math.random() * 2);

		if ((r == 0 && p[6] != 0) || ((r == 1 && p[7] == 0))) {
			p[6] = p[6] - 1;
		}

		else if ((r == 1 && p[7] != 0) || (r == 0 && p[6] == 0)) {
			p[7] = p[7] - 1;
		}
	}

	// this is the same as path 1 but im using p[8] and p[9]
	public void path5() {
		int r = (int) (Math.random() * 2);

		if ((r == 0 && p[8] != 0) || ((r == 1 && p[9] == 0))) {
			p[8] = p[8] - 1;
		}

		else if ((r == 1 && p[9] != 0) || (r == 0 && p[8] == 0)) {
			p[9] = p[9] - 1;
		}
	}

	// this method location() has an int input which depending on what it gets
	// in will depend on what part of the p[] is returned
	public int[] location(int h) {
		int[] z = new int[2];
		int[] l = { 0, 1 };
		if (h == 1) {
			z[0] = p[0];
			z[1] = p[1];
			return z;
		} else if (h == 2) {
			z[0] = p[2];
			z[1] = p[3];
			return z;
		} else if (h == 3) {
			z[0] = p[4];
			z[1] = p[5];
			return z;
		} else if (h == 4) {
			z[0] = p[6];
			z[1] = p[7];
			return z;
		} else if (h == 5) {
			z[0] = p[8];
			z[1] = p[9];
			return z;
		} else {
			return l;
		}
	}

	// this method returns the array p which has all the hunters positions in
	public int[] getH() {
		return p;
	}

	// this method returns the score
	public int score() {
		return score;
	}

	public void resetHun(int count) {
		p[count] = 8;
		p[count + 1] = 8;
	}

}
