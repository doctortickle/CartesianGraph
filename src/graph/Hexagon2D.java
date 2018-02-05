package graph;


/**
 * Hexagon2D is an EdgeMap implementation that stores edges for vertices considered
 * adjacent in a 2D hexagon-based Cartesian coordinate system.
 * @author Dylan Russell
 * @version 1.0
 * @see EdgeMap, Vertex
 */
public class Hexagon2D implements EdgeMap {

	@Override
	public int[][] getDirs( Vertex vertex ) {
		
		if( ( vertex.getX() & 1 ) == 0) { // if the vertex X-coordinate is even;
		
			return new int[][] { { 1,0,0 }, { 0,1,0 }, { -1,0,0 }, { -1,-1,0 }, { 0,-1,0 }, { 1,-1,0 } }; // return edges for non-offset hexagon.
		
		}
		
		else {
			
			return new int[][] { { 1,1,0 }, { 0,1,0 }, { -1,1,0 }, { -1,0,0 }, { 0,-1,0 }, { 1,0,0 } }; // return edges for offset hexagon.
		
		}
				
	}

}
