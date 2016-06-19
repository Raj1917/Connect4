package gamestates;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public abstract class GAstate {

	GSM gsm;
	public static int who = 0;
	public GAstate(GSM gsm) {
		this.gsm = gsm;
	}
	
	public abstract void draw ( Graphics g );
	public abstract void mousePressed(MouseEvent e);
	
}
