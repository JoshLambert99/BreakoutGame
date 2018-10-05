package brickBreaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JPanel;


public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private boolean play = false; //game shouldntstart by itself
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer time; //setting time of how fast ball moves
	private int delay = 8; //speed of timer
	
	private int playerX = 310; //start pos.
	
	private int ballposX = 120; //start pos.
	private int ballposy = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;

	public Gameplay() {
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



		
	
}
