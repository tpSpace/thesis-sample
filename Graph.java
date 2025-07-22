import java.util.*;

public class Graph {
    private final int vertices;
    private final List<List<Node>> adjList;

    public Graph(int v) {
        this.vertices = v;
        adjList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
        adjList.get(v).add(new Node(u, weight)); // For undirected graph
    }

    public List<List<Node>> getAdjList() {
        return adjList;
    }

    public int getVertices() {
        return vertices;
    }
}
