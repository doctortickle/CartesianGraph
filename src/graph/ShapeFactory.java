package graph;

/**
 * EdgeMap is an interface for classes that store edges for vertices considered
 * adjacent in a Cartesian coordinate system.
 * @author Dylan Russell
 * @version 1.0
 * @see Vertex
 */
public interface ShapeFactory  {
	
	/**
	 * Returns an array of integer arrays that represent unit vectors for vertices considered adjacent to
	 * a given vertex in a Cartesian grid.
	 * @param vertex - the vertex for which edges are being returned.
	 * @return an array of unit vectors representing vertices adjacent to the supplied vertex. 
	 */
	public int[][] getDirs( Vertex vertex );
	
	/**
	 * Contains the mathematical data for calculating the points of the Polygon visually representing the vertex
	 * in a grid.
	 * @param vertex - vertex to be visually represented.
	 * @param radius - the size of the visual vertex representation.
	 */
	public void buildShape( Vertex vertex, int radius );	
}
