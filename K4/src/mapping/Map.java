package mapping;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import render.GameCanvas;

public class Map {

	Block block[][];
	int width = 7;
	int height = 6;
	
	int xpos, ypos;
	
	public int turnNumber = 0;
	
	public Map() {
		render();
	}
	
	public void render() {
		
		block = new Block[width][height];
		
		for ( int x = 0; x < width; x++ ) {
			for ( int y = 0; y < height; y++ ) {
				block[x][y] = new Block(-1, x*(GameCanvas.xDIM/7), y*(GameCanvas.yDIM/6));
			}
		}
	}
	
	public void draw(Graphics g) {
		for ( int x = 0; x < width; x++ ) {
			for ( int y = 0; y < height; y++ ) {
				block[x][y].draw(g);
			}
		}
	}
	
	public int getBlockID(int a, int b) {
		return block[a][b].getID();
	}
	
	public int getTurn() {
		return turnNumber;
	}
	
	public void mousePressed(MouseEvent e) {
		int x=e.getX();
	    int y=e.getY();
	    int xt = 0;
	    for ( int i = 0; i < width; i++ ) {
			for ( int j = 0; j < height; j++ ) {
				if ( Findbounds.intersection(new Point(x, y), block[i][j]) ) {
					if ( block[i][height-1].getID() == -1 ) {
						block[i][height-1].setID(turnNumber%2);
					    turnNumber++;
					} else {
						xt = height - 1;
						while ( block[i][xt].getID() != -1 ) {
							xt--;
							if ( xt < 0 ) {
								return;
							}
						}
						block[i][xt].setID(turnNumber%2);
					    turnNumber++;
					}
				}
			}
		}
	}
}
