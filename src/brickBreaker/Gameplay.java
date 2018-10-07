package brickBreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;


public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private boolean play = false; //game shouldntstart by itself
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer; //setting time of how fast ball moves
	private int delay = 8; //speed of timer
	
	private int playerX = 310; //start pos.
	
	private int ballposX = 120; //start pos.
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private MapGenerator map;

	public Gameplay() {
		map = new MapGenerator(3,7); //object of map generator being created
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this); //object for timer
		timer.start(); 
	}
	
	public void paint(Graphics g)
	{
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		//drawing map
		map.draw((Graphics2D)g);
		
		//borders
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 3, 592); //three rectangles for border
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//scores
		g.setColor(Color.white);
		g.setFont(new Font ("serif", Font.BOLD, 25));
		g.drawString(""+score,  590,  30);
		
		//the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		
		//the ball
		g.setColor(Color.YELLOW);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		
		g.dispose();
		
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(play) { //if arrow key is pressed
			
			if(new Rectangle(ballposX,ballposY, 20,20).intersects(new Rectangle(playerX, 550,100,8)))
			{
				ballYdir = -ballYdir;
			}
			
			A: for(int i = 0; i< map.map.length; i++) //first map is variable in gameplay class second map is in map generator
			{
				for(int j = 0; j < map.map[0].length; j++)
				{
					if(map.map[i][j] > 0) //detect intersection
					{
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						//create rectangle around ball to detect intersection
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20,20); 
						Rectangle brickRect = rect; //passing reference of rect above (line 96)
						
						if(ballRect.intersects(brickRect)) { //checking intersect
							map.setBrickValue(0, i, j); //calling function to set value to 0
							totalBricks--;
							score+= 5;
							
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width)
							{
								ballXdir = -ballXdir; //need to move the ball to opposite dir
							} else {
								ballYdir = -ballYdir;
							}
							
							break A; //exit this outer loop
						}
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			if(ballposX < 0) {
				ballXdir = - ballXdir; //left border
			}
			
			if(ballposY < 0) {
				ballYdir = - ballYdir; //top border
			}
			
			if(ballposX > 670) {
				ballXdir = - ballXdir; //right border
			}
		}
		
		repaint(); //draws everything again, calls paint method again
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(playerX >= 600)
				playerX = 600;
		} else {
			moveLeft(); //gonna incremnt x
		}
		
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
				if(playerX < 10)
					playerX = 10;
			} else {
				moveRight(); 
			}
		
		
	}
	
	

	public void moveRight() {
		
		play = true; //set to false at top
		playerX += 20; //move
	
	}

	public void moveLeft() {
			
			play = true; //set to false at top
			playerX -= 20; //move
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	
}
