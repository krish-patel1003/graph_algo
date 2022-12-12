import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int V;
    private LinkedList<Integer>[] adj;
    private Queue<Integer> Q;

    BFS(int v){
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }

        Q = new LinkedList<>();
    }

    void insertEdge(int u, int v){
        adj[u].add(v);
    }

    void bfsTraversal(int n){
        boolean[] nodes = new boolean[V];
        int a = 0;
        nodes[n] = true;
        Q.add(n);

        while(Q.size() != 0){
            n = Q.poll();

            System.out.print(n+" ");

            for (int i = 0; i < adj[n].size(); i++) {
                a = adj[n].get(i);
                if(!nodes[a]){
                    nodes[a] = true;
                    Q.add(a);
                }
            }
        }

    }

    public static void main(String[] args) {

        BFS graph = new BFS(10);
        graph.insertEdge(0,1);
        graph.insertEdge(0,2);
        graph.insertEdge(0,3);
        graph.insertEdge(1,3);
        graph.insertEdge(2,4);
        graph.insertEdge(3,5);
        graph.insertEdge(3,6);
        graph.insertEdge(4,7);
        graph.insertEdge(4,5);
        graph.insertEdge(5,2);
        graph.insertEdge(6,5);
        graph.insertEdge(7,5);
        graph.insertEdge(7,8);
        System.out.print("BFS is : ");
        graph.bfsTraversal(0);

    }

}
