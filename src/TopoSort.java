import java.util.LinkedList;
import java.util.Stack;

public class TopoSort {
//    Topological sort in not possible if the graph is not a DAG

    private int V;
    private LinkedList<Integer>[] adj;

    TopoSort(int v){
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void insertEdge(int u, int v){
        adj[u].add(v);
    }

    void dfsUtil(int n, boolean[] visited, Stack<Integer> s){
        int a;
        visited[n] = true;
        for (int i = 0; i < adj[n].size(); i++) {
            a = adj[n].get(i);
            if(!visited[a]){
                dfsUtil(a, visited, s);
            }
        }
        s.push(n);
    }

    void sort(int n){
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                dfsUtil(i, visited, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopoSort graph = new TopoSort(6);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 1);
        graph.insertEdge(4, 1);
        graph.insertEdge(4, 0);
        graph.insertEdge(5, 0);
        graph.insertEdge(5, 2);

        System.out.print("topo sort is : ");
        graph.sort(0);
    }

}
