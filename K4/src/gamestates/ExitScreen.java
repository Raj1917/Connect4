package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import render.GameCanvas;

public class ExitScreen extends GAstate {

	String msg = "Player " + K4game.who + " wins";
	
	public ExitScreen(GSM gsm) {
		super(gsm);
	}
	
	public void draw(Graphics g) {
		Font font = new Font("Sans Serif", Font.PLAIN, 24); // Set the font for the text
		FontMetrics metrics = g.getFontMetrics(font);
		int strWidth = metrics.stringWidth(msg);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameCanvas.xDIM, GameCanvas.yDIM);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(msg, GameCanvas.xDIM/2 - strWidth/2, GameCanvas.yDIM/2);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
