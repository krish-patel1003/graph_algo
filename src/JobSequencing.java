import java.util.Arrays;

class Job{
    char id;
    int deadline, profit;

    Job(char id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

}

public class JobSequencing {

    static void printJobSeq(Job[] arr, int t){
        int n = arr.length;
        Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);

        boolean[] occupied = new boolean[t];
        char[] job = new char[t];

        for (int i = 0; i < n; i++) {
            int min_index = Math.min(t-1, arr[i].deadline-1);
            for (int j = min_index; j >= 0; j--) {
                if (!occupied[j]){
                    occupied[j] = true;
                    job[j] = arr[i].id;
                    break;
                }
            }
        }

        for (char id : job) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        Job[] arr = new Job[n];
        arr[0] = new Job('a', 2, 100);
        arr[1] = new Job('b', 1, 19);
        arr[2] = new Job('c', 2, 27);
        arr[3] = new Job('d', 1, 25);
        arr[4] = new Job('e', 3, 15);

        System.out.println("Output: ");
        printJobSeq(arr, 3);


    }
}
