package graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Graph is an object that stores a Cartesian coordinate system as a vertex-edge graph. Adjacent coordinates
 * in a Cartesian coordinate system, such as (0,0,0) and (0,1,0) are represented as adjacent in a graph by a 
 * connecting edge with an edge weight of 1. This class also contains the functionality to connect
 * any two vertices that would traditionally not be considered adjacent in a Cartesian coordinate system, such as
 * (0,0,0) and (10,10,10). This allows developers using a 2D or 3D Cartesian coordinate system to allow two
 * vertices to be connected that otherwise would not normally be, such as including "worm-hole"
 * travel in a video game set in space or for the purposes of allowing movement off one end of the grid 
 * to wrap around to the other side, like in Pac-Man. This class also contains the functionality to
 * remove edges between vertices.  This allows developers using a 2D or 3D Cartesian coordinate system to 
 * restrict movement between two vertices that would normally be considered adjacent, such as placing
 * obstacles on a map or creating restricted areas.
 * @author Dylan Russell
 * @version 1.0
 *
 */
public class Graph {
    
    final private HashMap< Vertex, Set< Vertex > > adjacencyMap;
    
    /**
     * Constructor. Creates a new vertex-edge graph representing a Cartesian coordinate system.
     * The graph and edges are stored in a HashMap, called adjacencyMap. The key is a vertex and
     * the value is a Set of Vertex objects adjacent to the key vertex.
     */
    public Graph() {
    	
        this.adjacencyMap = new HashMap<>();
    
    }
    
    /**
     * Adds a vertex to the graph.
     * @param vertex - the vertex to be added to the graph.
     * @throws IllegalArgumentException if the vertex has already been added to the graph.
     * @see Vertex
     */
    public void addVertex( Vertex vertex ) {
    	
        if ( this.adjacencyMap.containsKey( vertex ) ) { // if this vertex has already been added;
        	
            throw new IllegalArgumentException( "Vertex " + vertex.toString() + " already exists in this graph." ); // throw an illegal argument exception.
            
        }
        
        this.adjacencyMap.put( vertex, new HashSet< Vertex >() ); // add this vertex as the key to the HashMap with a new HashSet value.
        
    }
    
	/**
	 * Removes a vertex and all of its edges from the graph.
	 * @param vertex - the vertex to be removed from the graph.
     * @throws IllegalArgumentException if the vertex does not exist in the graph.
     * @see Vertex
     */ 
    public void removeVertex( Vertex vertex ) {
    	
        if ( !this.adjacencyMap.containsKey( vertex ) ) { // if this vertex does not exist in the graph;
        	
            throw new IllegalArgumentException( "Vertex " + vertex.toString() + " does not exist in this graph." ); // throw an illegal argument exception.
        
        }
        
        this.adjacencyMap.remove( vertex ); // remove this vertex from the HashMap.
        
        for ( Vertex u: this.getAllVertices() ) { // for each vertex in this graph;
        	
            this.adjacencyMap.get( u ).remove( vertex ); // remove the edge with the supplied vertex.
        
        }
        
    }
    
    /**
     * Connect two vertices (a and b) with an edge, thus making them adjacent vertices.
     * @param a - a vertex to be connected.
     * @param b - a vertex to be connected.
     * @throws IllegalArgumentException if either vertex does not exist in the graph.
     * @see Vertex
     */
    public void connectVertices( Vertex a, Vertex b ) {
    	
        if ( !this.adjacencyMap.containsKey( a ) || !this.adjacencyMap.containsKey( b ) ) { // if either vertex a or vertex b do not exist in the graph;
        	
            throw new IllegalArgumentException( "Either vertex " + a.toString() + " or " + b.toString() + " do not exist in this graph."  ); // throw an illegal argument exception.
        
        }
        
        this.adjacencyMap.get( a ).add( b ); // add edge to vertex b to vertex a's set of edges.
        this.adjacencyMap.get( b ).add( a ); // add edge to vertex a to vertex b's set of edges.
        
    }
    
    /**
     * Disconnect two vertices (a and b) by removing the edge between them, thus making them non-adjacent vertices.
     * @param a - a vertex to be disconnected.
     * @param b - a vertex to be disconnected.
     * @throws IllegalArgumentException if either vertex does not exist in the graph.
     * @see Vertex
     */
    public void disconnectVertices( Vertex a, Vertex b ) {
    	
        if ( !this.adjacencyMap.containsKey( a ) || !this.adjacencyMap.containsKey( b ) ) { // if either vertex a or vertex b do not exist in the graph;
        	
            throw new IllegalArgumentException(); // throw an illegal argument exception.
        
        }
        
        this.adjacencyMap.get( a ).remove( b ); // remove edge to vertex b from vertex a's set of edges.
        this.adjacencyMap.get( b ).remove( a ); // remove edge to vertex a from vertex b's set of edges.
    
    }
    
    /**
     * Determines if a vertex exists in this graph.
     * @param vertex - vertex to be checked for existence.
     * @return <tt>true</tt> if vertex exists in this graph or <tt>false</tt> if it does not.
     * @see Vertex
     */
    public boolean containsVertex( Vertex vertex ) {
    	
    	return this.adjacencyMap.containsKey( vertex );
    
    }
    
    /**
     * Determines if a vertex is adjacent to another vertex in this graph.
     * @param a - vertex to be checked for adjacency.
     * @param b - vertex to be checked for adjacency.
     * @return <tt>true</tt> if vertices a and b are adjacent to one another in this graph or <tt>false</tt> if they are not.
     * @see Vertex
     */
    public boolean isAdjacent( Vertex a, Vertex b ) {
    	
        return this.adjacencyMap.get( a ).contains( b );
    
    }
    
    /**
     * Returns an iterable list of vertices adjacent to the supplied vertex.
     * @param vertex - the vertex for which all adjacent vertices will be returned.
     * @return Iterable<Vertex> of all adjacent vertices to the supplied vertex.
     * @see Iterable, Vertex
     */
    public Iterable< Vertex > getAdjacentVertices( Vertex vertex ) {
    	
        return this.adjacencyMap.get( vertex );
    
    }
    
    /**
     * Returns an iterable list of vertices in this graph.
     * @return Iterable<Vertex> of all vertices in this graph.
     * @see Iterable, Vertex
     */
    public Iterable< Vertex > getAllVertices() {
    	
        return this.adjacencyMap.keySet();
    
    }
}