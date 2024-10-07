import java.util.Scanner;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        int[] sequence = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            sequence[i] = fibonacci(i);
        }

        System.out.print("The Fibonacci sequence up to " + n + " is: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println();
    }
}
