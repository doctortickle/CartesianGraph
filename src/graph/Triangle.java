package graph;

public class Triangle implements EdgeMap {
	
	@Override
	public int[][] getDirs(int x, int y) {
		if( (x & 1) == 0 && (y & 1) == 0 || (x & 1) != 0 && (y & 1) != 0 ) {
			return new int[][] { {1,0}, {-1,0}, {0,-1} };
		}
		else {
			return new int[][] { {1,0}, {-1,0}, {0,1} };
		}
	}

}
