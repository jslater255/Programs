package Lionheart;

public class player {

	private int strength = 5;
	private int[] pos = { 0, 0 };
	private int count = 0;

	public int[] move(String a) {

		if (a.equals("left") && pos[0] > 0) {
			pos[0]--;
			return pos;
		}

		else if (a.equals("right") && pos[0] < 8) {
			pos[0]++;
			return pos;
		}

		else if (a.equals("up") && pos[1] > 0) {
			pos[1]--;
			return pos;
		}

		else if (a.equals("down") && pos[1] < 8) {
			pos[1]++;
			return pos;
		}
		return pos;
	}

	public int[] checkPH(int[] a, int[] p) {

		return p;
	}

	public int strengthOut() {
		return strength;
	}

	public int[] getPos() {
		return pos;
	}
	
	public void minusStr(){
		strength--;
	}
}
