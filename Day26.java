import java.util.*;

class Graph {
    int V;
    List<List<Integer>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
        if (visited[v] == false) {
            visited[v] = true;
            recStack[v] = true;

            List<Integer> children = adj.get(v);

            for (Integer c : children) {
                if (!visited[c] && isCyclicUtil(c, visited, recStack))
                    return true;
                else if (recStack[c])
                    return true;
            }
        }
        recStack[v] = false;
        return false;
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        boolean result = graph.isCyclic();
        System.out.println("Output: " + result); 
    }
}
