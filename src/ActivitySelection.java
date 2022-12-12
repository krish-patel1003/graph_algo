import java.util.Arrays;
import java.util.Comparator;

class Activity{
    int start, finish;

    Activity(int s, int f){
        this.start = s;
        this.finish = f;
    }

}
public class ActivitySelection {

    static void printMaxActivities(Activity[] arr, int n){
        Arrays.sort(arr, (s1, s2) -> s1.finish - s2.finish);
        System.out.println("Output: ");

        int i = 0;
        System.out.println("("+arr[i].start+","+arr[i].finish+")");

        for (int j = 1; j < n; j++) {

            if (arr[j].start > arr[i].finish){
                System.out.println("("+arr[j].start+","+arr[j].finish+")");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        Activity[] arr = new Activity[n];

        arr[0] = new Activity(5, 9);
        arr[1] = new Activity(1, 2);
        arr[2] = new Activity(3, 4);
        arr[3] = new Activity(0, 6);
        arr[4] = new Activity(5, 7);
        arr[5] = new Activity(8, 9);

        printMaxActivities(arr, n);
    }
}
