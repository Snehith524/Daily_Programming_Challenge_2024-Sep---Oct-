public class DutchNationalFlag 

public static void sort(int[] arr) {
        int low = 0; 
        int mid = 0; 
        int high = arr.length - 1; 

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {0, 1, 2, 1, 0, 2, 1, 0},
                {2, 2, 2, 2},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {2, 0, 1},
                {}
        };

        for (int[] testCase : testCases) {
            System.out.println("Input: " + java.util.Arrays.toString(testCase));
            sort(testCase);
            System.out.println("Output: " + java.util.Arrays.toString(testCase));
            System.out.println();
        }
    }
}
