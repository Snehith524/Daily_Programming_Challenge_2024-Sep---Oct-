public class LCM {
    public static int findGCD(int N, int M) {
        if (M == 0) {
            return N;
        } else {
            return findGCD(M, N % M);
        }
    }

    public static int findLCM(int N, int M) {
        int gcd = findGCD(N, M);
        return (N * M) / gcd;
    }

    public static void main(String[] args) {
        int N = 12; 
        int M = 15; 
        int lcm = findLCM(N, M);
        System.out.println("LCM of " + N + " and " + M + " is " + lcm);
    }
}
