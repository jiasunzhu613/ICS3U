import java.awt.Rectangle;
import java.util.*;
/*
 * @date November 2021
 * @author Jonathan Zhu
 */
public class Rect extends Rectangle{
	int x;
	int y;
	int width;
	int height;
	ArrayList<Rect> separators = new ArrayList<Rect>();
	public Rect(int x, int y, int width, int height, ArrayList<Rect> separators) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		separators.add(this);
	}
}
