public class DivisorCounter {
    public static void countDivisors(int N) {
        int count = 0;
        System.out.print("Divisors of " + N + " are: ");
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                System.out.print(i + " ");
                count++;
                if (i * i != N) {
                    System.out.print(N / i + " ");
                    count++;
                }
            }
        }
        System.out.println("\nNumber of divisors of " + N + " is " + count);
    }

    public static void main(String[] args) {
        int N = 12;
        countDivisors(N);
    }
}
