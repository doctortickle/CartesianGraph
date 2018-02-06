package graph;

/**
 * Square2D is an EdgeMap implementation that stores edges for vertices considered
 * adjacent in a 2D square-based Cartesian coordinate system.
 * @author Dylan Russell
 * @version 1.0
 * @see EdgeMap, Vertex
 */
public class Square2D implements ShapeFactory {

	@Override
	public int[][] getDirs( Vertex vertex ) {
		
		return new int[][] { { 1,0,0 }, { 0,1,0 }, { -1,0,0 }, { 0,-1,0 } }; // return edges for four adjacent squares.
	
	}
	
	@Override
	public void buildShape( Vertex vertex, int radius ) {

		for( int i = 1; i <= 8; i += 2 ) {
			
			double theta = i * ( Math.PI / 4 );
			double x = radius * Math.cos( theta );
			double y = radius * Math.sin( theta );
			vertex.getPoints().addAll( x,y );
			
		}
		
		double offset = radius - (2 * ( radius - (  radius / Math.sqrt( 2 ) ) ) );
		vertex.setLayoutX( vertex.getX() * ( radius + offset ) );
		vertex.setLayoutY( vertex.getY() * ( radius + offset ) );
		
	}
	
}
