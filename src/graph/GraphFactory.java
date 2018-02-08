package graph;

/**
 * GraphFactory produces a non-directional edge-vertex graph in which each vertex is 
 * connected to the vertices specified by the provided ShapeFactory template and each vertex is
 * represented by an x-, y-, and z-coordinate on a Cartesian grid. For a 2D grid, set z equal
 * to 0.
 * @author Dylan Russell
 * @version 1.0
 * @see Graph, Vertex, ShapeFactory
 */

public class GraphFactory {
	
	private int x;
	private int y;
	private int z;
	private int radius;
	private ShapeFactory shapeFactory;
	private Graph graph;
	
	/**
	 * Constructor. Creates a GraphFactory object that will be used to create the graph.
	 * @param x - the x-limit of the Cartesian coordinate grid. For example, 20 will create a grid
	 * with an X-axis spanning from -20 to 20, including 0.
	 * @param y - the y-limit of the Cartesian coordinate grid. For example, 20 will create a grid
	 * with a Y-axis spanning from -20 to 20, including 0.
	 * @param z - the z-limit of the Cartesian coordinate grid. For example, 20 will create a grid
	 * with a z-axis spanning from -20 to 20, including 0.
	 * @param shapeFactory - the ShapeFactory template that instructs the GraphFactory on how to connect each
	 * vertex to surrounding vertices.
	 */
	public GraphFactory( int x, int y, int z, ShapeFactory shapeFactory ) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.radius = ( 10 );
		this.shapeFactory = shapeFactory;		
		graph = new Graph();
		
	}
	
	/**
	 * Constructs the graph by first building all the individual vertices then connecting them.
	 */
	public void buildGraph() {	
		
		buildAllVertices(); // 1) Build all the vertices individually.
		connectVertices(); // 2) Connect all the vertices based on the ShapeFactory provided.
		createShapes(); // 3) Create a Polygon representation of every vertex according to the shape specified by ShapeFactory.
	}
	
	/**
	 * Returns the graph created by this GraphFactory.
	 * @return Graph representing a Cartesian grid.
	 * @see Graph
	 */
    public Graph getGraph() {
    	
    	return this.graph; // the graph created by the GraphFactory.
    	
    }
	
	/**
	 * Returns a supplied vertex from a graph, if it exists.
	 * @param x - the x-coordinate of the vertex.
	 * @param y - the y-coordinate of the vertex.
	 * @param z - the y-coordinate of the vertex.
	 * @return the vertex, if it exists. Returns null if the vertex does not exist.
	 * @see Vertex
	 */
	private Vertex getVertex( int x, int y, int z ) {
		
		for( Vertex vertex : graph.getAllVertices() ) { // 1) For each vertex in the graph;
			
			if( vertex.getX() == x && vertex.getY() == y && vertex.getZ() == z ) { // 2) check if the vertex x-, y-, and z-coordinates match the supplied coordinates.
				
				return vertex; // return the vertex.
				
			}
			
		}
		
		return null; // return null if the vertex does not exist.
	}

	/**
	 * Builds a number of vertices between -x and x, between -y and y, and between -z and z. 
	 */
	private void buildAllVertices() {

		for( int i = -x; i <= x; i ++ ) { // 1) For each int i between -x and x;
			
			for( int j = -y; j <= y; j++ ) { // 2) for each int j between -y and y;
				
				for( int k = -z; k <= z; k++ ) { // 2) for each int j between -z and z;
					
					graph.addVertex( new Vertex( i, j, k, radius ) ); // 3) construct a new vertex at coordinate i, j, k.
					
				}	
				
			}			
			
		}
		
	}
	
	/**
	 * Connects each vertex to its adjacent vertices as indicated by the supplied EdgeMap template.
	 */
	private void connectVertices() {
				
		for( Vertex i : graph.getAllVertices() ) { // 1) for each vertex, i, in the graph;
			
			for( int[] dir : shapeFactory.getDirs( i ) ) { // 2) for each edge in the supplied EdgeMap;
				
				Vertex j = getVertex( i.getX() + dir[ 0 ], i.getY() + dir[ 1 ], i.getZ() + dir[2] ); // 3) retrieve the vertex, j, at the supplied coordinates;
				
				if( validate( j ) ) { // 4) if that vertex, j, exists;
					
					graph.connectVertices( i, j ); // 5) connect the vertices i and j.
					
				}
				
			}

		}
		
	}
	
	/**
	 * Validates that the given vertex exists and is contained in the graph.
	 * @param vertex - vertex to be validated.
	 * @return true if the vertex is not null and contained in the graph or false if the vertex is null or not contained in the graph.
	 */
    private boolean validate( Vertex vertex ) {
    	
		if( vertex != null && graph.containsVertex( vertex ) ) { // check if the given vertex is not null and that the graph contains it.
			
			return true; // return true if the vertex exists and is contained in the graph.
			
		}
				
		return false; // return false if the vertex is either null or not contained in the graph.
		
	}
    
    /**
     * Creates a visual representation of every vertex in this graph in order to be displayed as a grid.
     */
    private void createShapes() {
    	
		for( Vertex i : graph.getAllVertices() ) { // 1) for each vertex, i, in the graph;
			
			shapeFactory.buildShape(i, radius); // 2) build the shape.

		}
    	
    }
    
}
