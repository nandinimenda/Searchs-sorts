import java.util.*;

class BFT {
    static void bfs(List<List<Integer>> adj, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    static void breadthFirstTraversal(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(adj, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter edges (format: u v for each edge):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // Since it's an undirected graph
        }

        System.out.println("BFS Traversal:");
        breadthFirstTraversal(adj);

        sc.close();
    }
}