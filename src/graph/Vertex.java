package graph;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

/**
 * Vertex is a class that represents vertices in a edge-vertex graph meant to store a Cartesian coordinate system.
 * A vertex may represent a coordinate in both 2D and 3D Cartesian coordinate systems. For a 2D plane, set the
 * z-coordinate to 0. 
 * @author Dylan Russell
 * @version 1.0
 */
public class Vertex extends Polygon {

	private int x;
	private int y;
	private int z;
	private int radius;
	private Paint defaultColor;
	private Group connections;
	
	
	/**
	 * Constructor. x, y, and z are integers representing the x-, y-, and z- coordinates in a Cartesian coordinate system.
	 * @param x - the x-coordinate in a Cartesian coordinate system.
	 * @param y - the y-coordinate in a Cartesian coordinate system.
	 * @param z - the z-coordinate in a Cartesian coordinate system.
	 * @param radius - the radius of the circle into which this vertex is inscribed.
	 */
	public Vertex( int x, int y, int z, int radius ) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.radius = radius;
		
	}
		
	/**
	 * @return the x-coordinate of this vertex.
	 */
	public int getX() {
		
		return x;
		
	}

	/**
	 * @return the y-coordinate of this vertex.
	 */
	public int getY() {
		
		return y;
	
	}
	
	/**
	 * @return the z-coordinate of this vertex.
	 */
	public int getZ() {
		
		return z;
	
	}
	
	/**
	 * @return the radius of the circle into which this vertex is inscribed.
	 */
	public int getRadius() {
		
		return radius;
		
	}
	
	/**
	 * Sets the default color of this vertex.
	 * @param color - color to be set as default.
	 * @see Color
	 */
	public void setDefaultColor( Paint color ) {
		
		defaultColor = color;
		setFill( defaultColor );
		
	}
	
	/**
	 * @return the default color of this vertex.
	 * @see Color
	 */
	public Paint getDefaultColor() {
		
		return defaultColor;
		
	}
	
	/**
	 * Adds all edges emanating from this vertex to other vertices as a Group of Connections.
	 * @param connections
	 * @see Connection, Group
	 */
	public void addConnections( Group connections ) {
		
		this.connections = connections;
		
	}
	
	/**
	 * @return the Group of Connections representing all edges emanating from this vertex to other vertices.
	 */
	public Group getConnections() {
		
		return connections;
		
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ",  " + z + ") ";		
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
		
	}

	@Override
	public boolean equals( Object obj ) {
		
		if ( this == obj )
			return true;
		
		if ( obj == null )
			return false;
		
		if ( getClass() != obj.getClass() )
			return false;
		
		Vertex other = ( Vertex ) obj;
		
		if ( x != other.x )
			return false;
		
		if ( y != other.y )
			return false;
		
		if ( z != other.z )
			return false;
		
		return true;
		
	}

}
