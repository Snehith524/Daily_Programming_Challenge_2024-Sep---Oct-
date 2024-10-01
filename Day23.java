import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        output[0] = arr[dq.peekFirst()];

        for (int i = k; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            output[i - k + 1] = arr[dq.peekFirst()];
        }

        return output;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = solution.maxSlidingWindow(arr, k);

        System.out.println("Input: arr = " + Arrays.toString(arr) + ", k = " + k);
        System.out.println("Output: Maximum elements in each sliding window of size " + k + ":");
        System.out.println("Explanation:");
        System.out.println("The first window is [" + arr[0] + ", " + arr[1] + ", " + arr[2] + "] -> Maximum = " + result[0]);
        System.out.println("The second window is [" + arr[1] + ", " + arr[2] + ", " + arr[3] + "] -> Maximum = " + result[1]);
        System.out.println("The third window is [" + arr[2] + ", " + arr[3] + ", " + arr[4] + "] -> Maximum = " + result[2]);
        System.out.println("The fourth window is [" + arr[3] + ", " + arr[4] + ", " + arr[5] + "] -> Maximum = " + result[3]);
        System.out.println("The fifth window is [" + arr[4] + ", " + arr[5] + ", " + arr[6] + "] -> Maximum = " + result[4]);
        System.out.println("The sixth window is [" + arr[5] + ", " + arr[6] + ", " + arr[7] + "] -> Maximum = " + result[5]);
        System.out.println("Final output: " + Arrays.toString(result));
    }
}
