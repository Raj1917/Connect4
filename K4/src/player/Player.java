package player;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import gamestates.GSM;
import mapping.Map;

public class Player {

	private int ID;
	Map toCheck;
	
	int width = 7, height = 6;
	int mapMove[][] = new int[width][height];
	
	public boolean win = false;
	
	public Player ( int ID ) {
		this.ID = ID;
		toCheck = new Map();
	}
	
	public void draw ( Graphics g ) {
		toCheck.draw(g);
	}
	
	public int getID() {
		return ID;
	}
	
	public boolean win() {
		return win;
	}
	
	public void checkforVertWin() {
		for ( int j = 0; j < width; j++ ) {
			for ( int i = 0; i < height; i++ ) {
				if ( mapMove[j][i] == 1 ) {
					int ex = i;
					int counter = 0;
					while ( mapMove[j][ex] == 1 ) {
						if ( mapMove[j][ex] == 1 ) {
							counter++;
						} if ( ex < height - 1 ) {
							ex++;
						} else {
							break;
						}
					}
					if ( counter == 4 ) {
						win = true;
					}
				}
			}
		}
	}
	public void checkforHorzWin() {
		for ( int i = 0; i < height; i++ ) {
			for ( int j = 0; j < width; j++ ) {
				if ( mapMove[j][i] == 1 ) {
					int a = j;
					int counter = 0;
					while ( mapMove[j][i] == 1 ) {
						if ( mapMove[a][i] == 1 ) {
							counter++;
						} if ( a < width - 1 ) {
							a++;
						} else {
							break;
						}
					} if ( counter == 4 ) {
						win = true;
					}
				}
			}
		}
	}
	
	public void checkforRightDiagWin() {
		for ( int j = width - 1; j >= 0; j-- ) {
			for ( int i = 0; i < height; i++ ) {
				if ( mapMove[j][i] == 1 ) {
					int ex = i;
					int ey = j;
					int counter = 0;
					while ( mapMove[ey][ex] == 1 ) {
						if ( mapMove[ey][ex] == 1 ) {
							counter++;
						} if ( ex < height - 1 && ey > 0 ) {
							ex++;
							ey--;
						} else {
							break;
						}
					}
					if ( counter == 4 ) {
						win = true;
					}
				}
			}
		}
	}
	
	public void checkforLeftDiagWin() {
		for ( int j = 0; j < width; j++ ) {
			for ( int i = 0; i < height; i++ ) {
				if ( mapMove[j][i] == 1 ) {
					int ex = i;
					int ey = j;
					int counter = 0;
					while ( mapMove[ey][ex] == 1 ) {
						if ( mapMove[ey][ex] == 1 ) {
							counter++;
						} if ( ex < height - 1 && ey < width - 1 ) {
							ex++;
							ey++;
						} else {
							break;
						}
					}
					if ( counter == 4 ) {
						win = true;
					}
				}
			}
		}
	}
	
	public void checkNwin() {
		checkforVertWin();
		checkforHorzWin();
		checkforRightDiagWin();
		checkforLeftDiagWin();
	}
	
	public void mousePressed(MouseEvent e) {
		toCheck.mousePressed(e);
		for ( int i = 0; i < width; i++ ) {
			for ( int j = 0; j < height; j++ ) {
				if ( toCheck.getBlockID(i, j) == ID ) {
					mapMove[i][j] = 1;
				}
			}
		}
		checkNwin();
	}
}
