package gamestates;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import mapping.Map;
import player.Player;

public class K4game extends GAstate{

	Map loadPath;
	Player player, player2;
	
	public K4game(GSM gsm) {
		super(gsm);
		loadPath = new Map();
		player = new Player(0);
		player2 = new Player(1);
	}
	
	public void draw(Graphics g) {
		player.draw(g);
		player2.draw(g);
	}
	
	public void mousePressed(MouseEvent e) {
		//loadPath.mousePressed(e);
		player.mousePressed(e);
		player2.mousePressed(e);
		if ( player.win() ) {
			who = player.getID() + 1;
			gsm.states.push(new ExitScreen(gsm));
		} else if ( player2.win() ) {
			who = player2.getID() + 1;
			gsm.states.push(new ExitScreen(gsm));
		}
	}
}
