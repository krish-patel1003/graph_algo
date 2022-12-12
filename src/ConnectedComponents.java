import java.util.LinkedList;
import java.util.Stack;

public class ConnectedComponents {
    private int V;
    private LinkedList<Integer>[] adj;

    ConnectedComponents(int v){
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void insertEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    void dfsUtil(int n, boolean[] visited){
        int a;
        visited[n] = true;
        System.out.print(n+" ");
        for (int i = 0; i < adj[n].size(); i++) {
            a = adj[n].get(i);
            if(!visited[a]){
                dfsUtil(a, visited);
            }
        }
    }

    void connectedComp(){
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                dfsUtil(i, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ConnectedComponents g = new ConnectedComponents(5);

        g.insertEdge(1, 0);
        g.insertEdge(2, 1);
        g.insertEdge(3, 4);
        System.out.println("Following are connected components");
        g.connectedComp();
    }
}
