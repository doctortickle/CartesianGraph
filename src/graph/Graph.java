package graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    
    final private HashMap<Vertex, Set<Vertex>> adjacencyMap;
    
    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }
    
    public void addVertex(Vertex vertex) {
        if (this.adjacencyMap.containsKey(vertex)) {
            throw new IllegalArgumentException("Node already exists.");
        }
        this.adjacencyMap.put(vertex, new HashSet<Vertex>());
    }

    public void removeVertex(Vertex vertex) {
        if (!this.adjacencyMap.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex doesn't exist.");
        }
        
        this.adjacencyMap.remove(vertex);
        
        for (Vertex u: this.getAllVertices()) {
            this.adjacencyMap.get(u).remove(vertex);
        }
    }
    
    public void connectVertices(Vertex startVertex, Vertex endVertex) {
        if (!this.adjacencyMap.containsKey(startVertex) || !this.adjacencyMap.containsKey(endVertex)) {
            throw new IllegalArgumentException();
        }
        
        this.adjacencyMap.get(startVertex).add(endVertex);
        this.adjacencyMap.get(endVertex).add(startVertex);
    }
    
    public void disconnectVertices(Vertex startVertex, Vertex endVertex) {
        if (!this.adjacencyMap.containsKey(startVertex) || !this.adjacencyMap.containsKey(endVertex)) {
            throw new IllegalArgumentException();
        }
        
        this.adjacencyMap.get(startVertex).remove(endVertex);
        this.adjacencyMap.get(endVertex).remove(startVertex);
    }
    
    public boolean containsVertex(Vertex vertex) {
    	return this.adjacencyMap.containsKey(vertex);
    }
    
    public boolean isAdjacent(Vertex vertex, Vertex checkVertex) {
        return this.adjacencyMap.get(vertex).contains(checkVertex);
    }
    
    public Iterable<Vertex> getAdjacentVertices(Vertex vertex) {
        return this.adjacencyMap.get(vertex);
    }
    
    public Iterable<Vertex> getAllVertices() {
        return this.adjacencyMap.keySet();
    }
}