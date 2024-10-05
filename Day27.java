import java.util.*;

class Graph {
    private int V;
    private List<List<Integer>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void BFS(int src, int dest) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    parent[v] = u;
                }
            }
        }
        printPath(parent, dest, src);
    }

    private void printPath(int[] parent, int dest, int src) {
        if (dest == src) {
            System.out.print(dest + " ");
            return;
        }

        printPath(parent, parent[dest], src);
        System.out.print(dest + " ");
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        int start = 0;
        int end = 4;

        System.out.println("Shortest path from " + start + " to " + end + ":");
        graph.BFS(start, end);
    }
}
