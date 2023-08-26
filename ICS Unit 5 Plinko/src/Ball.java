import java.awt.Point;
import java.awt.Rectangle;
import java.util.*;
/*
 * @date November 2021
 * @author Jonathan Zhu
 */
public class Ball extends Rectangle{
	int x;
	int y;
	ArrayList<Ball> balls;
	int height;
	int width;
	String name;
	boolean moneyEarned;
	int velX;
	int velY;
	ArrayList<Point> pointsContacted;
	public Ball(String name, int x, int y, int height, int width, int velX, int velY, boolean moneyEarned, ArrayList<Point> pointsContacted, ArrayList<Ball> balls) {
		this.name = name;
		this.x = x;
		this.y=y;
		this.velX = velX;
		this.velY = velY;
		this.height=height;
		this.width = width;
		this.moneyEarned = moneyEarned;
		this.pointsContacted = pointsContacted;
		balls.add(this);
	}
	public boolean checkCollision(Point point) {		
		int tw = this.width+4; 
		int th = this.height+4;
		int cw = 3;  //changed from 1 and 2
		int ch = 3;
		if (cw <= 0 || ch <= 0 || tw <= 0 || th <= 0) {
			return false;
		}
		int tx = this.x-2;
		int ty = this.y-2;
		int cx = (int) point.getX();
		int cy = (int) point.getY();
		cw += cx;
		ch += cy;
		tw += tx;
		th += ty;
		return ((cw < cx || cw > tx) &&
				(ch < cy || ch > ty) &&
				(tw < tx || tw > cx) &&
				(th < ty || th > cy));
	}
}
