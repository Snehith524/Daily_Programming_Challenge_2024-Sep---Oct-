import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstElementToRepeatKTimes {
    public static int findFirstElement(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freqMap.get(num) == k) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        int result = findFirstElement(arr, k);
        if (result != -1) {
            System.out.println("First element to repeat " + k + " times: " + result);
        } else {
            System.out.println("No element repeats " + k + " times.");
        }
    }
}
