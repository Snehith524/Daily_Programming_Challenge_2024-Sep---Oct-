import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int cumulativeSum = 0;

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if (cumulativeSum == 0) {
                result.add(new int[] {0, i});
            }

            if (sumIndexMap.containsKey(cumulativeSum)) {
                int startIndex = sumIndexMap.get(cumulativeSum);
                result.add(new int[] {startIndex + 1, i});
            }

            if (!sumIndexMap.containsKey(cumulativeSum)) {
                sumIndexMap.put(cumulativeSum, i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> result = findZeroSumSubarrays(arr);

        for (int[] indices : result) {
            System.out.println("Subarray with sum 0: [" + indices[0] + ", " + indices[1] + "]");
        }
    }
}
