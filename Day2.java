public class MissingInteger {
    public static int findMissingInteger(int[] arr) {
        int n = arr.length + 1; 
        int expectedSum = n * (n + 1) / 2; 
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        System.out.println("Missing number: " + findMissingInteger(arr)); 

        int[] arr2 = {2, 3, 4, 5};
        System.out.println("Missing number: " + findMissingInteger(arr2)); 

        int[] arr3 = {1, 2, 3, 4};
        System.out.println("Missing number: " + findMissingInteger(arr3)); 

        int[] arr4 = {1};
        System.out.println("Missing number: " + findMissingInteger(arr4)); 

        int[] arr5 = new int[9];
        for (int i = 0; i < 9; i++) {
            arr5[i] = i + 1;
        }
        System.out.println("Missing number: " + findMissingInteger(arr5)); 
    }
}
