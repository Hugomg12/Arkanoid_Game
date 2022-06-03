package JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel {
	
	

	ball ball = new ball(this);
	Racquet racquet = new Racquet(this);
	int speed = 1;
	ArrayList<brick> bricks= new ArrayList<brick>();

	private int getScore() {
		return speed - 1;
	}

	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
		Sound.BACK.loop();
		
		
		int X = 5;
		int Y = 43;
		int WITH = 60;
		int HEIGHT = 20;
		int lives = 0;
		
		
		for(int i = 0; i < 5; i++) {
			
			X = 5;
			
			for (int j = 0; j < 7; j++) {	
					
				int opcio = (int) (Math.random()*3);
				
					if (opcio == 0) {
						bricks.add(new brick_green(X, Y, WITH, HEIGHT, 3));
					}
					else if (opcio == 1) {
						bricks.add(new brick_red(X, Y, WITH, HEIGHT, 2));
					}
					else if (opcio == 2) {
						bricks.add(new brick_blue(X, Y, WITH, HEIGHT, 1));
						
					}
					
				X = X + 65;
			}
			Y = Y + 35;
			
		}
		
	}

	private void move() {
		ball.move();
		racquet.move();
		
		for (int i = 0; i < bricks.size(); i++) {
			if (bricks.get(i) instanceof brick_red && bricks.get(i).getLives() == 0) {
				brick_red baixar = (brick_red)bricks.get(i);
				baixar.move();
			}
		}
		
	}



	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		ball.paint(g2d);
		
		
		for (int i = 0; i < bricks.size(); i++) {
			bricks.get(i).paint(g2d);
		}
		racquet.paint(g2d);
		

		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 550);
	}

	public void gameOver() {
		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		boolean joc = true;
		JFrame frame = new JFrame("Arkanoid");
		Game game = new Game();
		frame.add(game);
		frame.setSize(475, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
	
	
	

}