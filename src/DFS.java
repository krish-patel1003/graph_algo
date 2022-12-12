import java.util.LinkedList;

public class DFS {
    private int V;
    private LinkedList<Integer>[] adj;
    private boolean[] visited;

    DFS(int v){
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }

        visited = new boolean[V];
    }

    void insertEdge(int u, int v){
        adj[u].add(v);
    }

    void dfsTraversal(int n){
//        System.out.println(Arrays.toString(visited));
        int a = 0;
        visited[n] = true;
        System.out.print(n+" ");
        for (int i = 0; i < adj[n].size(); i++) {
            a = adj[n].get(i);
            if(!visited[a]){
                dfsTraversal(a);
            }
        }

    }

    public static void main(String[] args) {

        DFS graph = new DFS(10);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(4, 7);
        graph.insertEdge(4, 5);
        graph.insertEdge(5, 2);

        System.out.print("DFS is : ");
        graph.dfsTraversal(0);

    }

}
