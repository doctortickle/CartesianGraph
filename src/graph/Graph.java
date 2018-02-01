package graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph<T> {
    
    final private HashMap<T, Set<T>> adjacencyMap;
    
    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }
    
    public void addVertex(T vertex) {
        if (this.adjacencyMap.containsKey(vertex)) {
            throw new IllegalArgumentException("Node already exists.");
        }
        this.adjacencyMap.put(vertex, new HashSet<T>());
    }

    public void removeVertex(T vertex) {
        if (!this.adjacencyMap.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex doesn't exist.");
        }
        
        this.adjacencyMap.remove(vertex);
        
        for (T u: this.getAllVertices()) {
            this.adjacencyMap.get(u).remove(vertex);
        }
    }
    
    public void connectVertices(T startVertex, T endVertex) {
        if (!this.adjacencyMap.containsKey(startVertex) || !this.adjacencyMap.containsKey(endVertex)) {
            throw new IllegalArgumentException();
        }
        
        this.adjacencyMap.get(startVertex).add(endVertex);
        this.adjacencyMap.get(endVertex).add(startVertex);
    }
    
    public void disconnectVertices(T startVertex, T endVertex) {
        if (!this.adjacencyMap.containsKey(startVertex) || !this.adjacencyMap.containsKey(endVertex)) {
            throw new IllegalArgumentException();
        }
        
        this.adjacencyMap.get(startVertex).remove(endVertex);
        this.adjacencyMap.get(endVertex).remove(startVertex);
    }
    
    public boolean containsVertex(T vertex) {
    	return this.adjacencyMap.containsKey(vertex);
    }
    
    public boolean isAdjacent(T vertex, T checkVertex) {
        return this.adjacencyMap.get(vertex).contains(checkVertex);
    }
    
    public Iterable<T> getAdjacentVertices(T vertex) {
        return this.adjacencyMap.get(vertex);
    }
    
    public Iterable<T> getAllVertices() {
        return this.adjacencyMap.keySet();
    }
}