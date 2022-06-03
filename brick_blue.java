package JFrame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class brick_blue extends brick {

	public brick_blue(int X, int Y, int WITH, int HEIGHT, int lives) {
		super(X, Y, WITH, HEIGHT, lives);
	}
	
	public void paint(Graphics2D g) {
		super.paint(g);
		g.setColor(Color.blue);
		g.fillRect(getX(), getY(), getWith(), getHeight());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), getWith(), getHeight());
	}

	
	
}