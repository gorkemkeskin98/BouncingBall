package demogame;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;



public class GamePlay extends JPanel implements ActionListener, KeyListener {
	
	
	private boolean play = false;
	private Timer timer;
	private int score=0;
	private int delay =8;
	private int ballposX=120;
	private int ballposY=350;	
	private int ballXdir=-1;
	private int ballYdir=-2;
	private int player=350;
	
	
	public GamePlay() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		
		timer = new Timer(delay, this);
		timer.start();
	
	}
	

	public void paint(Graphics g) {
		
		//black canvas
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
	  
		//border
		g.setColor(Color.blue);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(0, 3, 3, 592);
		g.fillRect(681, 3, 3, 592);
		
		//paddle
		g.setColor(Color.green);
		g.fillRect(player, 510,100,8);
		
		//ball
		g.setColor(Color.red);
		g.fillOval(ballposX,ballposY,20,20);
		
		//score
		g.setColor(Color.yellow);	
		g.setFont(new Font("serif", Font.BOLD, 20));
		g.drawString("Score: "+score,580,30);
		
		//game over
		if (ballposY>=580) {
			play=false;
			ballXdir=0;
			ballYdir=0;
			
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("GameOver!!, Score: "+score,250,300);
			
		}
		
		
	  
	}
	private void moveLeft() {
		play=true;
		player-=20;
		
	}
	private void moveRight() {
		play=true;
		player+=20;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(player<=5) {
				player=5;
			}
			else {
				moveLeft();
			}
			
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(player>=580) {
				player=580;
			}
			else {
				moveRight();
			}
		}
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if (play) {
			if (ballposX<=0) {
				ballXdir=-ballXdir;
			}
			if (ballposX>=670) {
				ballXdir=-ballXdir;
			}
			if (ballposY<=0) {
				ballYdir=-ballYdir;
			}
			
			Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
			Rectangle paddleRect = new Rectangle(player,510,100,8);
			
			if (ballRect.intersects(paddleRect)) {
				ballYdir=-ballYdir;
				score+=1;
			}
			
			ballposX+=ballXdir;
			ballposY+=ballYdir;
		}
		
		repaint();
	}
	
	
}