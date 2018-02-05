package graph;

/**
 * EdgeMap is an interface for classes that store edges for vertices considered
 * adjacent in a Cartesian coordinate system.
 * @author Dylan Russell
 * @version 1.0
 * @see Vertex
 */
public interface EdgeMap {
	
	/**
	 * Returns an array of integer arrays that represent unit vectors for vertices considered adjacent to
	 * a given vertex in a Cartesian grid.
	 * @param vertex - the vertex for which edges are being returned.
	 * @return an array of unit vectors representing vertices adjacent to the supplied vertex. 
	 */
	public int[][] getDirs( Vertex vertex );
	
}
