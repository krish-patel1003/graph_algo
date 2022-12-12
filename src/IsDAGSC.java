import java.util.LinkedList;

class Graph0{
    int V;
    LinkedList<Integer>[] adj;

    Graph0(int v){
        V=v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v){
        adj[u].add(v);
    }

    void dfsUtil(int v, boolean[] visited){
        visited[v] = true;
        int a;
        for (int i = 0; i < adj[v].size(); i++) {
            a = adj[v].get(i);
            if (!visited[a]){
                dfsUtil(a, visited);
            }
        }
    }

    Graph0 transpose(){
        Graph0 g = new Graph0(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                g.adj[j].add(i);
            }
        }

        return g;
    }
}

public class IsDAGSC {

    static boolean isSC(Graph0 graph, int V){
        boolean[] visited = new boolean[V];

        graph.dfsUtil(0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                return false;
            }
        }

        Graph0 tg = graph.transpose();

        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        tg.dfsUtil(0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Graph0 g1 = new Graph0(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);

        if (isSC(g1, 5)){
            System.out.println("Graph is Strongly connected");
        }
        else{
            System.out.println("Graph is not strongly connected");
        }

        Graph0 g2 = new Graph0(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        if (isSC(g2, 4)){
            System.out.println("Graph is Strongly connected");
        }
        else{
            System.out.println("Graph is not strongly connected");
        }
    }
}
