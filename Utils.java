public class Utils {
    public static void printDistances(int[] distances, int source) {
        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + " -> " + distances[i]);
        }
    }
}
