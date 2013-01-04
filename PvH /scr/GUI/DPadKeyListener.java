package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Lionheart.level;

public class DPadKeyListener implements KeyListener {
	
	level lev;
	GridDraw gD;
	OutGrid oG;
	
	public DPadKeyListener(level lev, GridDraw gD, OutGrid oG) {
		
		this.lev = lev;
		this.gD = gD;
		this.oG = oG;
		
	}


	@Override
	public void keyPressed(KeyEvent kE) {
		
		int keyP = kE.getKeyCode();
		System.out.println(keyP);
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
