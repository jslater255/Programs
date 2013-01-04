package Lionheart;

public class hunters2 {
	private int[] huntPos = { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };// sets up a new
																// array
	// for my hunters in
	// level 2

	private int score = 0;// set the score to 0 incase the user just wasns to
							// play
							// level 2

	// the method path has 3 inputs an array pP which holds the players position
	// in the 2 ints which will tell the method which part of the p array to
	// look
	// at
	public void path(int[] pP, int c, int r) {

		{
			if ((pP[0] < huntPos[c]) && (pP[1] == huntPos[r])) {
				huntPos[c] = huntPos[c] - 1;

			} else if ((pP[1] < huntPos[r]) && (pP[0] == huntPos[c])) {
				huntPos[r] = huntPos[r] - 1;

			} else {
				moveH(c, r);
			}
		}

	}

	// this is the same type of method as in hunters for level 1 where the
	// hunters will randomly move up the top left of the grid
	public void moveH(int a, int b) {
		int r = (int) (Math.random() * 2);

		if ((r == 0 && huntPos[a] != 0) || ((r == 1 && huntPos[b] == 0))) {
			huntPos[a] = huntPos[a] - 1;

		}

		else if ((r == 1 && huntPos[b] != 0) || (r == 0 && huntPos[a] == 0)) {
			huntPos[b] = huntPos[b] - 1;
		}
	}

	public void restart() {
		int r = 0;
		while (r != 9) {
			if (huntPos[r + 1] == 0 && huntPos[r] == 0) {
				huntPos[r + 1] = 8;
				huntPos[r] = 8;
				score++;
			}
			r++;
		}
	}

	public int score() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	// same method as in hunters one but ive made it again as the array for my
	// hunters positions is in this class
	public int[] checkH2() {
		return huntPos;
	}

	public void resetHun(int count) {
		huntPos[count] = 8;
		huntPos[count + 1] = 8;
	}
}
