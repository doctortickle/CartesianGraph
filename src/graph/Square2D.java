package graph;

/**
 * Square2D is an EdgeMap implementation that stores edges for vertices considered
 * adjacent in a 2D square-based Cartesian coordinate system.
 * @author Dylan Russell
 * @version 1.0
 * @see EdgeMap, Vertex
 */
public class Square2D implements EdgeMap {

	@Override
	public int[][] getDirs( Vertex vertex ) {
		
		return new int[][] { { 1,0,0 }, { 0,1,0 }, { -1,0,0 }, { 0,-1,0 } }; // return edges for four adjacent squares.
	
	}
	
}
