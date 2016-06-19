package gamestates;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class GSM {

	public Stack<GAstate> states;
	public GSM() {
		states = new Stack<GAstate>();
		states.push(new K4game(this)); // push the menustate onto the stack
	}
	
	public void draw(Graphics g) {
		states.peek().draw(g);
	}
	
	public void mousePressed(MouseEvent e) {
		states.peek().mousePressed(e);
	}
	
}
