import java.util.ArrayList;

public class GraphAdjacencyList {
    ArrayList<ArrayList<Integer>> adlist;

    public GraphAdjacencyList(int vertex) {
        adlist = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            adlist.add(new ArrayList<>());
        }
    }

    public void addEdge(int s, int d) {
        adlist.get(s).add(d);
        adlist.get(d).add(s); // for undirected graph
    }

    public void printGraph() {
        for (int i = 0; i < adlist.size(); i++) {
            System.out.println(i + " -> " + adlist.get(i));
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyList graph = new GraphAdjacencyList(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4); // duplicate again

        graph.printGraph();
    }
}