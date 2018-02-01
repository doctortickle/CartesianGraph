package graph;

public class GraphFactory {
	
	private int x;
	private int y;
	private EdgeMap edgeMap;

	public GraphFactory(int x, int y, EdgeMap edgeMap) {
		this.x = x;
		this.y = y;
		this.edgeMap = edgeMap;
	}
	
	public Graph<Vertex> buildGraph() {
		Graph<Vertex> graph = new Graph<Vertex>();
		buildAllVertices(graph);
		connectVertices(graph);
		return graph;
	}
	
	private void buildAllVertices(Graph<Vertex> graph) {

		for(int i = -x; i <= x; i ++) {
			for(int j = -y; j <= y; j++) {
				graph.addVertex(new Vertex(i,j, edgeMap));
			}			
		}
	}
	
	private void connectVertices(Graph<Vertex> graph) {
				
		for(Vertex i : graph.getAllVertices()) {
			
			for(int[] dir : i.getDirs()) {
				Vertex j = new Vertex(i.getX() + dir[0], i.getY() + dir[1], edgeMap);
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
	
    private boolean validate(Graph<Vertex> graph, Vertex vertex) {
		if( graph.containsVertex(vertex))
			return true;
		return false;
	}
	
}
