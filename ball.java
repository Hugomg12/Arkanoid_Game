package JFrame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;


public class ball {
	private static final int DIAMETER = 20;
	int RADI = DIAMETER/2;
	int x = 200;
	int y = 300;
	int xa = 1;
	int ya = 1;
	private Game game;

	public ball(Game game) {
		this.game = game;
	}

	void move() {
		
		boolean changeDirection = true;
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		else if (y + ya < 0)
			ya = game.speed;
		else if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		else if (collision()){
			ya = -game.speed;
			y = game.racquet.getTopY() - DIAMETER;
			
			if (game.speed < 7) {
				game.speed++;
			}
			
		}
		else if(game.bricks.size()>0) {
			for (int i=0; i<game.bricks.size();i++) {
		
				if (collisionbrick(i) && ya > 0 && xa > 0){ //abaix dreta
					
					game.bricks.get(i).lives = game.bricks.get(i).getLives() - 1;
					
					if (x + RADI > game.bricks.get(i).X && x + RADI < game.bricks.get(i).X + game.bricks.get(i).getWith()) {
						ya = -ya;
					}
					else if (x + RADI < game.bricks.get(i).X + DIAMETER) {
						xa = -xa;
					}
					
					if (game.bricks.get(i) instanceof brick_red && game.bricks.get(i).getLives() == 0) {
						if (game.bricks.get(i).getY() > 620) {
							game.bricks.remove(i);
						}
						
						
					}
					
					else if (game.bricks.get(i).getLives() == 0) {
						game.bricks.remove(i);
						
					}
					
					
					/*
					y = game.bricks.get(i).getTopY() - DIAMETER;
					
					
					game.bricks.get(i).lives = game.bricks.get(i).getLives() - 1;
					
					if (game.bricks.get(i).getLives() == 0) {
						game.bricks.remove(i);
					}*/

				}
				else if (collisionbrick(i) && ya < 0 && xa > 0){ // amunt dreta
					
					game.bricks.get(i).lives = game.bricks.get(i).getLives() - 1;
					
					if (x + RADI > game.bricks.get(i).X && x + RADI < game.bricks.get(i).X + game.bricks.get(i).getWith()) {
						ya = -ya;
					}
					else if (x + RADI < game.bricks.get(i).X + DIAMETER){
						xa = -xa;
					}
					
					
					if (game.bricks.get(i) instanceof brick_red && game.bricks.get(i).getLives() == 0) {
						if (game.bricks.get(i).getY() > 620) {
							game.bricks.remove(i);
						}
						
						
					}
					else if (game.bricks.get(i).getLives() == 0) {
						game.bricks.remove(i);
						
					}
					
					
					
					/*y = game.bricks.get(i).getLowY();
					ya = - ya;

					game.bricks.get(i).lives = game.bricks.get(i).getLives() - 1;
					
					if (game.bricks.get(i).getLives() == 0) {
						
						game.bricks.remove(i);
						
					}*/

				}
				else if (collisionbrick(i) && ya < 0 && xa < 0) { //amunt esquerra
					game.bricks.get(i).lives = game.bricks.get(i).getLives() - 1;
					
					if (x + RADI > game.bricks.get(i).X && x + RADI < game.bricks.get(i).X + game.bricks.get(i).getWith()) {
						ya = -ya;
					}
					else if (x + RADI < game.bricks.get(i).X + game.bricks.get(i).getWith() - DIAMETER){
						xa = -xa;
					}
					
					if (game.bricks.get(i) instanceof brick_red && game.bricks.get(i).getLives() == 0) {
						if (game.bricks.get(i).getY() > 620) {
							game.bricks.remove(i);
						}
						
						
					}
					
					else if (game.bricks.get(i).getLives() == 0) {
						game.bricks.remove(i);
						
					}
					
					
					/*y = game.bricks.get(i).getLowY();
					ya = - ya;

					*/

				}
				else if (collisionbrick(i) && ya > 0 && xa < 0){ //abaix esquerra
					game.bricks.get(i).lives = game.bricks.get(i).getLives() - 1;
					
					if (x + RADI > game.bricks.get(i).X && x + RADI < game.bricks.get(i).X + game.bricks.get(i).getWith()) {
						ya = -ya;
					}
					else if (x + RADI < game.bricks.get(i).X + game.bricks.get(i).getWith() - DIAMETER){
						xa = -xa;
					}
					
					if (game.bricks.get(i) instanceof brick_red && game.bricks.get(i).getLives() == 0) {
						if (game.bricks.get(i).getY() > 620) {
							game.bricks.remove(i);
						}
						
						
					}
					else if (game.bricks.get(i).getLives() == 0) {
						game.bricks.remove(i);
						
					}
					
					
					/*y = game.bricks.get(i).getLowY();
					ya = - ya;

					game.bricks.get(i).lives = game.bricks.get(i).getLives() - 1;
					
					if (game.bricks.get(i).getLives() == 0) {
						game.bricks.remove(i);
						
					}*/

				}
				
				else {
					changeDirection = false;
				}
			}
		}
		/*else if (collisionbrick() && ya > 0){
			y = game.bricks.get(x).getTopY() - DIAMETER;
		}
		else if (collisionbrick() && ya < 0){
			y = game.bricks.get(x).getLowY();
		}*/else 
			game.gameOver();
		
		if (changeDirection) 
			Sound.BALL.play();
		x = x + xa;
		y = y + ya;
	}
	
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	private boolean collisionbrick(int i) {
		return game.bricks.get(i).getBounds().intersects(getBounds());
	}
	


	public void paint(Graphics2D g) {
		g.setColor(Color.red);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}

}