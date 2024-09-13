import java.util.ArrayList;
import java.util.List;

public class LeaderElements {
    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int maxRight = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxRight) {
                leaders.add(arr[i]);
                maxRight = arr[i];
            }
        }
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders = findLeaders(arr);
        System.out.println("Leader elements: " + leaders);
    }
}
