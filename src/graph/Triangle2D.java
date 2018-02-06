package graph;

/**
 * Triangle2D is an EdgeMap implementation that stores edges for vertices considered
 * adjacent in a 2D triangle-based Cartesian coordinate system.
 * @author Dylan Russell
 * @version 1.0
 * @see EdgeMap, Vertex
 */
public class Triangle2D implements ShapeFactory {
	
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
	
	@Override
	public void buildShape( Vertex vertex, int radius ) {
		
		double offsetX = 0;
		double offsetY = 0;
		
		if( ( vertex.getX() & 1 ) == 0 && ( vertex.getY() & 1 ) == 0 || 
			( vertex.getX() & 1 ) != 0 && ( vertex.getY() & 1 ) != 0 ) {
			for( int i = 0; i <= 2; i++ ) {
				
				double theta = i * ( 2 * Math.PI / 3 );
				double x = radius * Math.cos( theta + ( Math.PI / 6 ) );
				double y = radius * Math.sin( theta + ( Math.PI / 6 ) );
				vertex.getPoints().addAll( x,y );
				offsetY = 0.25 * radius;
			
			}
			
		}
		
		else {
			
			for( int i = 0; i <= 2; i++ ) {
				
				double theta = i * ( 2 * Math.PI / 3 );
				double x = radius * Math.cos( theta - ( Math.PI / 6 ) );
				double y = radius * Math.sin( theta - ( Math.PI / 6 ) );
				vertex.getPoints().addAll( x,y );
				offsetY = -0.25 * radius;
				
			}
			
		}
		
		offsetX = -vertex.getX() * ( ( ( Math.sqrt( 3 ) - 1 ) * radius ) / ( 2 * ( 1 + Math.sqrt( 3 ) ) ) );
		offsetY = offsetY + ( vertex.getY() * 0.5 * radius );
		
		vertex.setLayoutX( vertex.getX() * radius + offsetX );
		vertex.setLayoutY( vertex.getY() * radius + offsetY );
		
	}	

}
