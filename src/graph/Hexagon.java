package graph;

public class Hexagon implements EdgeMap {

	@Override
	public int[][] getDirs(int x, int y) {
		return new int[][] { {1,0}, {0,1}, {-1,1}, {-1,0}, {0,-1}, {1,-1} };		
	}

}
