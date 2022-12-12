public class Prim {
    private int V;

    Prim(int v){
        V = v;
    }

    int minKey(int[] key, boolean[] mstSet){
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < V; i++) {
            if (!mstSet[i] && key[i] < min){
                min = key[i];
                min_index = i;
            }
        }

        return min_index;
    }

    void primMST(int graph[][]){
        int[] parent = new int[V];

        int[] key = new int[V];

        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < V - 1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int j = 0; j < V; j++) {

                if(graph[u][j] != 0 && !mstSet[j] && graph[u][j] < key[j]){
                    parent[j] = u;
                    key[j] = graph[u][j];
                }
            }
        }

        printMST(parent, graph);
    }

    void printMST(int[] parent, int[][] graph){
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t"+ graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        Prim t = new Prim(5);
        int graph[][] = new int[][]
            {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
            };

        // Print the solution
        t.primMST(graph);
    }
}
