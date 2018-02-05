package graph;

/**
 * Triangle2D is an EdgeMap implementation that stores edges for vertices considered
 * adjacent in a 2D triangle-based Cartesian coordinate system.
 * @author Dylan Russell
 * @version 1.0
 * @see EdgeMap, Vertex
 */
public class Triangle2D implements EdgeMap {
	
	@Override
	public int[][] getDirs( Vertex vertex ) {
		
		if( ( vertex.getX() & 1 ) == 0 && ( vertex.getY() & 1 ) == 0 // if the x- and y- coordinates are even;
				
			|| ( vertex.getX() & 1 ) != 0 && ( vertex.getY() & 1 ) != 0 ) { // or if the x- and y- coordinates are odd;
			
				return new int[][] { { 1,0,0 }, { -1,0,0 }, { 0,1,0 } }; // return edges for a triangle pointed up.
		}
		
		else {
			
			return new int[][] { { 1,0,0 }, { -1,0,0 }, { 0,-1,0 } }; // return edges for a triangle pointed down.
		
		}
		
	}

}
