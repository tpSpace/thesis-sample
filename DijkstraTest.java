public class DijkstraTest {
    public static void main(String[] args) {
        testSmallGraph();
        testDisconnectedGraph();
        testSingleNode();
        testTwoNodesNoEdge();
    }

    public static void testSmallGraph() {
        System.out.println("=== Test 1: Small Connected Graph ===");
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 3, 3);

        printEdges(graph);
        int[] expected = { 0, 1, 3, 6 };
        runTest(graph, 0, expected);
    }

    public static void testDisconnectedGraph() {
        System.out.println("=== Test 2: Disconnected Graph ===");
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 3);
        // Nodes 3 and 4 are disconnected

        printEdges(graph);
        int[] expected = { 0, 2, 5, Integer.MAX_VALUE, Integer.MAX_VALUE };
        runTest(graph, 0, expected);
    }

    public static void testSingleNode() {
        System.out.println("=== Test 3: Single Node Graph ===");
        Graph graph = new Graph(1);
        // No edges

        printEdges(graph);
        int[] expected = { 0 };
        runTest(graph, 0, expected);
    }

    public static void testTwoNodesNoEdge() {
        System.out.println("=== Test 4: Two Nodes, No Edge ===");
        Graph graph = new Graph(2);
        // No edge between 0 and 1

        printEdges(graph);
        int[] expected = { 0, Integer.MAX_VALUE };
        runTest(graph, 0, expected);
    }

    private static void runTest(Graph graph, int source, int[] expected) {
        System.out.print("Expected distances from node " + source + ": ");
        printArray(expected);

        int[] result = Dijkstra.shortestPath(graph, source);
        System.out.print("Actual distances from node " + source + ":   ");
        printArray(result);

        boolean pass = true;
        for (int i = 0; i < expected.length; i++) {
            if (result[i] != expected[i]) {
                pass = false;
                System.out.println("❌ Mismatch at node " + i + ": expected " + expected[i] + ", got " + result[i]);
            }
        }

        if (pass) {
            System.out.println("✅ Test passed.\n");
        } else {
            System.out.println("❌ Test failed.\n");
        }
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            if (value == Integer.MAX_VALUE)
                System.out.print("∞ ");
            else
                System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void printEdges(Graph graph) {
        System.out.println("Graph edges:");
        for (int u = 0; u < graph.getVertices(); u++) {
            for (Node n : graph.getAdjList().get(u)) {
                if (u < n.vertex) {
                    System.out.println(u + " - " + n.vertex + " (" + n.weight + ")");
                }
            }
        }
    }
}
