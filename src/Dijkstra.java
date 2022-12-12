public class Dijkstra {
    private int V;

    Dijkstra(int v){ // Time complexity : O(V^2)
        V=v;
    }

    int minDist(int[] dist, boolean[] sptSet){

        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < V; i++) {
            if(!sptSet[i] && dist[i] <= min){
                min = dist[i];
                min_index = i;
            }
        }

        return min_index;
    }

    void dijkstra(int[][] graph, int src){
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {

            int u = minDist(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {

                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }

        }

        printSol(dist);
    }

    void printSol(int[] dist){
        System.out.println("Solution: ");
        System.out.println("Vertex \t\t Distance");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Dijkstra g = new Dijkstra(9);

        int graph[][]
                = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };

        g.dijkstra(graph, 0);
    }

}
