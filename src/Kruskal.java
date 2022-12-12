import java.util.Arrays;

public class Kruskal {
    static int V;
    static int E;
    static int[][] graph;
    static int[] parent;
    static int[] rank;

    Kruskal(int v, int e){
        V = v;
        E = e;
        graph = new int[E][3];
        parent = new int[V];
        rank = new int[V];
    }

    void addEdge(int u, int v, int w, int i){
        graph[i][0] = u;
        graph[i][1] = v;
        graph[i][2] = w;
    }

    int find(int i){
        if (parent[i] == -1){
            return i;
        }
        return find(parent[i]);
    }

    void union(int x, int y){
        int xroot = find(x);
        int yroot = find(y);

        if (rank[xroot] < rank[yroot]){
            parent[xroot] = yroot;
        } else if (rank[xroot] > rank[yroot]){
            parent[yroot] = xroot;
        } else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    void kruskal(){
        int i = 0;
        int e = 0;
        int minCost = 0;

        for (i = 0; i < V; i++) {
            parent[i] = -1;
            rank[i] = 0;
        }

        Arrays.sort(graph, (a, b) -> a[2] - b[2]);

        while (e < V - 1){
            int[] next_edge = graph[i++];

            int x = find(next_edge[0]);
            int y = find(next_edge[1]);

            if (x != y){
                e++;
                minCost += next_edge[2];
                union(x, y);
            }
        }

        System.out.println("Minimum cost: " + minCost);
    }

    public static void main(String[] args) {
//        Kruskal k = new Kruskal(4, 5);
//        k.addEdge(0, 1, 10, 0);
//        k.addEdge(0, 2, 6, 1);
//        k.addEdge(0, 3, 5, 2);
    }
}
