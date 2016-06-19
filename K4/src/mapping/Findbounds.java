package mapping;

import java.awt.Point;

public class Findbounds {

	public static boolean intersection(Point p, Block b) {
		return b.contains(p);
	}
	
}
