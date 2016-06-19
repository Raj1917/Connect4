package render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import gamestates.GSM;
import mapping.Map;
import player.Player;

public class GameCanvas extends JPanel implements Runnable, MouseListener{

	private static final long serialVersionUID = 1L;
	//Set the dimension for the GUI
	public static final int xDIM = 700;
	public static final int yDIM = 600;
	
	private static final Dimension SIZE = new Dimension(xDIM, yDIM);
	
	//The Game loop
	int FPS = 60;
	long interval = 1000/FPS; // Convert into milliseconds
	boolean ini = false;
	Thread begin;			// Begin the thread to start the game
	
	//The gamestatemanager
	GSM gsm;
	Player player, player2;
	
	public GameCanvas() {
		setPreferredSize(SIZE);
		start();
		addMouseListener(this);
	}
	
	private void start() {
		// TODO Auto-generated method stub
		ini = true;
		begin = new Thread(this);
		begin.start();
	}
	private void tick() {
		// TODO Auto-generated method stub
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gsm.draw(g);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long ready, elapsed, wait;
		gsm = new GSM();
		while ( ini ) {
			ready = System.nanoTime();
			
			tick();
			repaint();
			
			elapsed = System.nanoTime() - ready;
			wait = interval - elapsed/1000000;
			
			if ( wait <= 0 ) {	//Needed to ensure the game loop is constant
				wait = 5;		//Create a buffer
			}
			
			try {
				Thread.sleep(wait);
			} catch ( Exception e ) {
				e.printStackTrace();
			}
			
		}
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		gsm.mousePressed(e);
	}
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
