package graph;

/**
 * Hexagon2D is a shape implementation that stores edges for vertices considered
 * adjacent in a 2D hexagon-based Cartesian coordinate system. It also stores 
 * @author Dylan Russell
 * @version 1.0
 * @see EdgeMap, Vertex
 */
public class Hexagon2D implements ShapeFactory {

	@Override
	public int[][] getDirs( Vertex vertex ) {
		
		if( ( vertex.getX() & 1 ) == 0) { // if the vertex X-coordinate is even;
		
			return new int[][] { { 1,0,0 }, { 0,1,0 }, { -1,0,0 }, { -1,-1,0 }, { 0,-1,0 }, { 1,-1,0 } }; // return edges for non-offset hexagon.
		
		}
		
		else {
			
			return new int[][] { { 1,1,0 }, { 0,1,0 }, { -1,1,0 }, { -1,0,0 }, { 0,-1,0 }, { 1,0,0 } }; // return edges for offset hexagon.
		
		}
				
	}

	@Override
	public void buildShape( Vertex vertex, int radius ) {
		
		for( int i = 1; i <= 6; i++ ) {
			
			double theta = i * ( Math.PI/3 );
			double x = radius * Math.cos( theta );
			double y = radius * Math.sin( theta );
			vertex.getPoints().addAll( x,y );
			
		}    
       
		double horiz = ( radius * 2 ) * 0.75;
		double vert = ( Math.sqrt( 3 ) / 2 ) * ( radius * 2 );
		double offset = ( vertex.getX() % 2 ) * 0.5 * vert;
		vertex.setLayoutX( vertex.getX() * horiz );
		vertex.setLayoutY( vertex.getY() * vert + Math.abs( offset ) );
		
	}

}
