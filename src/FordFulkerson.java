import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    static int V;
    FordFulkerson(int v){
        V = v;
    }

    boolean bfsUtil(int[][] residualNet, int s, int t, int[] parent){
        boolean[] visited = new boolean[V];

        LinkedList<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while(q.size() != 0){
            int u = q.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && residualNet[u][v] > 0){
                    if(v == t){
                        parent[v] = u;
                        return true;
                    }
                    q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return false;
    }

    void fordFulkerson(int[][] graph, int s, int t){

        int u, v;
        int[][] residualNet = new int[V][V];

        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                residualNet[u][v] = graph[u][v];
            }
        }

        int[] parent = new int[V];
        int max_flow = 0;

        while(bfsUtil(residualNet, s, t, parent)){
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s ; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, residualNet[u][v]);
                
            }
        }
    }
}
