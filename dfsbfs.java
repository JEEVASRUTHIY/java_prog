import java.util.*;

class Codechef {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    // ---------------- DFS ----------------
    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour);
            }
        }
    }

    // ---------------- BFS ----------------
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbour : graph.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // number of vertices
        int m = sc.nextInt();  // number of edges

        // Initialize graph
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);   // remove this line if graph is directed
        }

        // -------- DFS Traversal --------
        visited = new boolean[n + 1];
        System.out.println("DFS Traversal:");
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        System.out.println();

        // -------- BFS Traversal --------
        visited = new boolean[n + 1];
        System.out.println("BFS Traversal:");
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }

        sc.close();
    }
}

