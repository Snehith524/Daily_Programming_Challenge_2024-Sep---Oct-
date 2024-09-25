import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static List<Integer> primeFactorization(int N) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                primeFactors.add(i);
                N /= i;
            }
        }
        if (N > 1) {
            primeFactors.add(N);
        }
        return primeFactors;
    }

    public static void main(String[] args) {
        int N = 18;
        List<Integer> primeFactors = primeFactorization(N);
        System.out.println("Prime factors of " + N + ": " + primeFactors);
    }
}
