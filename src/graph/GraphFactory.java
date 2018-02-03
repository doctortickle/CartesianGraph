package graph;

import java.util.ArrayList;

public class GraphFactory {
	
	private int x;
	private int y;
	private EdgeMap edgeMap;
	private Graph graph;

	public GraphFactory(int x, int y, EdgeMap edgeMap) {
		this.x = x;
		this.y = y;
		this.edgeMap = edgeMap;
		this.graph = new Graph();
	}
	
	public Graph buildGraph() {
		buildAllVertices();
		connectVertices();
		return graph;
	}
	
	private Vertex getVertex(int x, int y) {
		for(Vertex vertex : graph.getAllVertices()) {
			if(vertex.getX() == x && vertex.getY() == y) {
				return vertex;
			}
		}
		return null;
	}
	
	private void buildAllVertices() {

		for(int i = -x; i <= x; i ++) {
			for(int j = -y; j <= y; j++) {
				graph.addVertex(new Vertex(i,j, edgeMap));
			}			
		}
	}
	
	private void connectVertices() {
		
		ArrayList<Vertex> vertexBuffer = new ArrayList<>();
				
		for(Vertex i : graph.getAllVertices()) {
			
			for(int[] dir : i.getDirs()) {
				Vertex j = getVertex(i.getX() + dir[0], i.getY() + dir[1]);
				if(validate(graph, j)) {
					graph.connectVertices(i, j);
					vertexBuffer.add(j);
				}
			}
			i.setConnectedVertices(vertexBuffer);
		}
	}
	
    private boolean validate(Graph graph, Vertex vertex) {
		if(vertex != null && graph.containsVertex(vertex))
			return true;
		return false;
	}
	
}
