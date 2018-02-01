package graph;

public class GraphFactory {
	
	private int x;
	private int y;
	private EdgeMap edgeMap;
	private Graph graph;

	public GraphFactory(int x, int y, EdgeMap edgeMap) {
		this.x = x;
		this.y = y;
		this.edgeMap = edgeMap;
	}
	
	public Graph buildGraph() {
		graph = new Graph();
		buildAllVertices(graph);
		connectVertices(graph);
		return graph;
	}
	
	private Vertex getVertex(int x, int y) {
		Vertex testVertex = new Vertex(x, y, edgeMap);
		for(Vertex vertex : graph.getAllVertices()) {
			if(testVertex.equals(vertex)) {
				return vertex;
			}
		}
		return null;
	}
	
	private void buildAllVertices(Graph graph) {

		for(int i = -x; i <= x; i ++) {
			for(int j = -y; j <= y; j++) {
				graph.addVertex(new Vertex(i,j, edgeMap));
			}			
		}
	}
	
	private void connectVertices(Graph graph) {
				
		for(Vertex i : graph.getAllVertices()) {
			
			for(int[] dir : i.getDirs()) {
				Vertex j = getVertex(i.getX() + dir[0], i.getY() + dir[1]);
				if(validate(graph, j)) {
					graph.connectVertices(i, j);
				}
			}
			System.out.println(i.toString() + "is connected to: ");
			for(Vertex j : graph.getAdjacentVertices(i)) {
				System.out.print(j.toString());
			}
			System.out.println();
		}
	}
	
    private boolean validate(Graph graph, Vertex vertex) {
		if(vertex != null && graph.containsVertex(vertex))
			return true;
		return false;
	}
	
}
