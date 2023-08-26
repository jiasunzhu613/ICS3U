import java.awt.*;         
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
/* 
 * @date November 2021
 * @author Jonathan Zhu
 */
public class GamePanel extends JPanel implements Runnable{
	//Initiate variables
	private Thread panelThread;
	private int curBall, allFallen;
	public int numBall;
	private boolean isEntered;
	private int[] lockX = {0+5, 48+5, 48*2+5, 48*3+5, 48*4+5, 48*5+5, 48*6+5, 48*7+5, 48*8+5};
	private int[] moneyAmount = {500, 100, 1000, 0,5000,0,1000,100,500};
	private ArrayList<Point> collisionPoints = new ArrayList<Point>();
	private ArrayList<Point> pointsContacted = new ArrayList<Point>();
	private boolean running = true;
	ArrayList<Ball> balls = new ArrayList<Ball>();
	//Create ball objects which are instances of the Ball class
	Ball ball1 = new Ball("ball1",-500, -500, 40, 40, 0, 5, false, (ArrayList<Point>)pointsContacted.clone(),balls);
	Ball ball2 = new Ball("ball2",-500, -500, 40, 40,0, 5, false,(ArrayList<Point>)pointsContacted.clone(),balls);
	Ball ball3 = new Ball("ball3",-500, -500, 40, 40,0, 5, false,(ArrayList<Point>)pointsContacted.clone(),balls);
	Ball ball4 = new Ball("ball4",-500, -500, 40, 40,0, 5, false,(ArrayList<Point>)pointsContacted.clone(),balls);
	Ball ball5 = new Ball("ball5",-500, -500, 40, 40,0, 5, false,(ArrayList<Point>)pointsContacted.clone(),balls);
	
	ArrayList<Rect> separators = new ArrayList<Rect>();
	//Creates separator objects (seen as white rectangles at the bottom of the GamePanel) which are instances of the Rect class
	Rect separator1 = new Rect(48*1, 440, 5, 40, separators);
	Rect separator2 = new Rect(48*2, 440, 5, 40, separators);
	Rect separator3 = new Rect(48*3, 440, 5, 40, separators);
	Rect separator4 = new Rect(48*4, 440, 5, 40, separators);
	Rect separator5 = new Rect(48*5, 440, 5, 40, separators);
	Rect separator6 = new Rect(48*6, 440, 5, 40, separators);
	Rect separator7 = new Rect(48*7, 440, 5, 40, separators);
	Rect separator8 = new Rect(48*8, 440, 5, 40, separators);
	
	//Constructor
	public GamePanel() {
		//numBall = Integer.parseInt(GameFrame.chipCounter.getText());
		numBall = 5;
		curBall = 0;
		
		//Retrieved from https://www.youtube.com/watch?v=oLirZqJFKPE at 28:06
		panelThread = new Thread(this);
		panelThread.start();
		
		this.setBounds(180, 30, 432, 480);
		ClickListener clickListener = new ClickListener();
		this.addMouseListener(clickListener);
	}
	//Method that continuously runs to update graphics
	public void run() {
		//Retrieved from https://www.youtube.com/watch?v=oLirZqJFKPE at 28:06
		long lastTime = System.nanoTime();
		//Change this value to make the ball fall slower
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	//Creates the graphics 
	public void paintComponent(Graphics g) {
		g.setColor(Color.decode("#959595"));
		g.fillRect(0, 0, 432, 480);
		for (int i=40; i<400;i+=80) {
			for (int j=48; j<432;j+=48) {
				g.setColor(Color.decode("#ffffff"));
				g.fillOval(j, i, 5, 5);
				
				//Adds the dots created as instances of the Point class into the collisionPoints ArrayList
				Point collision = new Point(j, i);
				collisionPoints.add(collision);
			}
		}
		for (int i=80; i<480;i+=80) {
			for (int j=24; j<432;j+=48) {
				g.setColor(Color.decode("#ffffff"));
				g.fillOval(j, i, 5, 5);
				
				//Adds the dots created as instances of the Point class into the collisionPoints ArrayList
				Point collision = new Point(j, i);
				collisionPoints.add(collision);
			}
		}
		for (int i=0;i<8;i++) {
			g.setColor(Color.decode("#ffffff"));
			g.fillRect(separators.get(i).x, separators.get(i).y, separators.get(i).width, separators.get(i).height);
			
			//Adds the top left point of the separators as an instance of the Point class into the collisionPoints ArrayList
			Point collision = new Point(separators.get(i).x, separators.get(i).y);
			collisionPoints.add(collision);
		}
		//Paints the ball objects
		for (int i=0;i<5;i++) {
			g.setColor(Color.decode("#ffffff"));
			g.fillOval(balls.get(i).x, balls.get(i).y, 40, 40);
			g.setColor(Color.decode("#000000"));
		}
	}
	
	//Collision detection for when the balls hit the smaller dots on the board and the separators
	public void checkCollision() {
		//Checks if all balls are fallen
		allFallen = 0;
		for (int i=0; i<5;i++) {
			if (balls.get(i).moneyEarned) {
				allFallen++;
			}
		}
		//Enables the exit and play again buttons if allFallen is equal to the total number of balls the user is able to create
		if (allFallen == numBall) {
			System.out.println("In collison - equal");
			running = false;
			//Timer to delay the end screen change
			Timer timer = new Timer();
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					GameFrame.setUpEndScreen();
				}
			};
			timer.schedule(timerTask, 1000);
			
		}
		for (int i =0; i<5; i++) {
			//Checks if balls make contact with a pin on the board
			for (int j= 0;j<collisionPoints.size();j++) {
				if (balls.get(i).checkCollision(collisionPoints.get(j)) && !balls.get(i).pointsContacted.contains(collisionPoints.get(j))) {
					balls.get(i).pointsContacted.add(collisionPoints.get(j));
					//System.out.println("CONTACT");
					chooseDirection(balls.get(i));
				}
			}
			//Checks if balls needs to be locked into a slot
			if (balls.get(i).y > 480-40) {
				balls.get(i).y = 480-40;
				balls.get(i).x = lockX[closest((int)((balls.get(i).x+20)/51) * 51, lockX)];
			}
			//Checks if balls are able to earn winnings
			if (balls.get(i).y >= 480-40 && balls.get(i).moneyEarned == false) {
				GameFrame.money.setText(String.valueOf(Integer.parseInt(GameFrame.money.getText())+moneyAmount[closest((int)(balls.get(i).x), lockX)]));
				balls.get(i).moneyEarned = true;
			}
		}
	}
	
	//Moves the ball objects by adding x and y values to their x and y coordinates
	public void move() {
		for (int i=0; i<5;i++) {
			if (balls.get(i).x != -500 && balls.get(i).y != -500) {
				balls.get(i).y += balls.get(i).velY;
				balls.get(i).x += balls.get(i).velX;
			}
		}
	}
	
	//Chooses a random direction for the ball objects to go when they come into contact with a separator or a pin on the board
	public void chooseDirection(Ball ball) {
		//Chooses random number between 0 and 1 (inclusive)
		//if it returns 1, the ball will turn right, if it returns 0, the ball will turn left
		int direction = randomNumber(0, 1);
		
		//Forces the ball to turn right when it is too far left
		if (ball.x <= 24) {
			ball.velX = 3;
			ball.velY = 5;
		}
		//Forces the ball to turn left when it is too far right
		else if (ball.x+40 >= 408) {
			ball.velX = -3;
			ball.velY = 5;
		}
		//When the ball isn't too far left or right, it is chosen to go in a random direction (left or right)
		else{
			//Right turn
			if (direction == 1) {
			ball.velX = 3;
			ball.velY = 5;
			}
			//Left turn
			else {
			ball.velX = -3;
			ball.velY = 5;
			}
		}
	}
	//Random number method, same as the one in the Menu class
	public int randomNumber(int min, int max) {
		return (int)Math.floor((max+1-min)*Math.random()+min);
	}
	//Returns the closest x value index for a ball to lock onto
	public int closest(int value, int[] array) {
		int closestIndex = 0;
		for (int i=1; i<array.length;i++) {
			if (Math.abs(value - array[i]) < Math.abs(value - array[closestIndex])){
				closestIndex = i;
			}	
		}
		return closestIndex;
	}
	//MouseListener (only added the needed portion of the methods included in the module)
	private class ClickListener extends MouseAdapter {
		@Override
		//When the user clicks their mouse they will create a ball as long as they still have enough chips to use. A total of 5 balls can be created at most
		public void mousePressed(MouseEvent e) {
			//makes drop always happen at y = 5 and x equals the closest number in lockX
			if(isEntered && curBall < numBall) {
				balls.get(curBall).x = lockX[closest((int)((e.getX())/51) * 51, lockX)]+1;
				balls.get(curBall).y = 5;
				curBall+=1;
				GameFrame.chipCounter.setText(String.valueOf(Integer.parseInt(GameFrame.chipCounter.getText())-1));
			}	
		}
		@Override
		//Checks if the user's mouse is inside the GamePanel or not. This prevents the user from creating ball objects if they didn't intend to.
		public void mouseEntered(MouseEvent e) {
			isEntered = true;
		}
		@Override
		public void mouseExited(MouseEvent e) {
			isEntered = false;
		}
	}
}
