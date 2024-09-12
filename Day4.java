public class Main {
    public void mergeArrays(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] arr1 = new int[8]; 
        arr1[0] = 1;
        arr1[1] = 9;
        arr1[2] = 5;
        arr1[3] = 11;
        int m = 4;
        int[] arr2 = {2, 4, 3, 8};
        int n = arr2.length;
        main.mergeArrays(arr1, m, arr2, n);
        for (int i = 0; i < m + n; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}
