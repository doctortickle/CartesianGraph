package graph;

public class Hexagon implements EdgeMap {

	@Override
	public int[][] getDirs(int x, int y) {
		if( (x & 1) == 0) {
			return new int[][] { {1,0}, {0,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1} };
		}
		else {
			return new int[][] { {1,1}, {0,1}, {-1,1}, {-1,0}, {0,-1}, {1, 0} };
		}
				
	}

}
