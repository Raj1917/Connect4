package mapping;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import render.GameCanvas;

public class Block extends Rectangle{
	private static final long serialVersionUID = 1L;

	//Set the width and the height
	int width = GameCanvas.xDIM/7;
	int height = GameCanvas.yDIM/6;
	int x, y, ID;
	
	public Block(int ID, int x, int y) {
		setBounds(x, y, width, height);
		this.x = x;
		this.y = y;
		this.ID = ID;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		if ( ID == 0 ) {
			g.setColor(Color.MAGENTA);
			g.fillRect(x, y, width, height);
		} else if ( ID == 1 ) {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void setID( int ID ) {
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}
	
}
