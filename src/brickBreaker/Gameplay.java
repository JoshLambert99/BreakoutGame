package brickBreaker;

import java.awt.Color;
import java.awt.Graphics;
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
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;

	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//timer = new Timer(delay, this); //object for timer
		//timer.start(); //ignore errors for moment
	}
	
	public void paint(Graphics g)
	{
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		//borders
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 3, 592); //three rectangles for border
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		
		//the ball
		g.setColor(Color.YELLOW);
		g.fillRect(ballposX, ballposY, 20, 20);
		
		

		
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			
			if(playerX >= 600)
				playerX = 600;
		} else {
			moveRight(); //gonna incremnt x
		}
		
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
				if(playerX <10)
					playerX = 10;
			} else {
				moveLeft(); 
			}	
		
	}
	
	

	public void moveRight() {
		
		play = true; //set to false at top
		playerX+= 20; //move
	
	}

	public void moveLeft() {
			
			play = true; //set to false at top
			playerX-= 20; //move
		
	}
		
	
}
