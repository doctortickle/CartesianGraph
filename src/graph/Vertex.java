package graph;

public class Vertex {

	private int x;
	private int y;
	private EdgeMap edgeMap;
	private Object guiComponent;

	public Vertex(int x, int y, EdgeMap edgeMap) {
		this.x = x;
		this.y = y;
		this.edgeMap = edgeMap;
	}
		
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	public int[][] getDirs() {
		
		return edgeMap.getDirs(x, y);

	}
	
	public void setGUIComponent(Object obj) {
		this.guiComponent = obj;
	}
	
	public Object getGUIComponenet() {
		return guiComponent;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ") ";		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	

}
