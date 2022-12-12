public class APSP {
    int V;
    final static int INF = 99999;
    APSP(int v){
        V=v;
    }

    void floydWarshall(int dist[][]){

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSol(dist);
    }

    void printSol(int[][] dist){
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF){
                    System.out.print("INF\t");
                }
                else{
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = {
                { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
        };
        APSP a = new APSP(4);
        a.floydWarshall(graph);
    }
}
