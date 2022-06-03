package JFrame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class brick {
		
	public int X = 10;
	public int lives = 0;
	public int Y = 40;
	private int WITH = 60;
	private int HEIGHT = 20;
	private Game game;	
	

	public brick(int X,int Y, int WITH,int HEIGHT, int lives) {
		this.X = X;
		this.Y = Y;
		this.WITH = WITH;
		this.HEIGHT = HEIGHT;
		this.lives = lives;
		
	}

	public void paint(Graphics2D g) {
		
		g.fillRect(X, Y, WITH, HEIGHT);
		
		
	}

	
	public Rectangle getBounds() {
		return new Rectangle(X, Y, WITH, HEIGHT);
	}
	
	public int getTopY() {
		return Y - HEIGHT;
	}
	
	public int getLowY() {
		return Y + HEIGHT;
	}
	
	public int getX() {
		
		return X;
	}
	public int getY() {
		
		return Y;
	}
	public int getWith() {
	
		return WITH;
	}
	public int getHeight() {
	
		return HEIGHT;
	}
	
	public int getLives() {
		
		return lives;
	}
	


}


