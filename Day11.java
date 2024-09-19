import java.util.*;

public class Permutations {
    public List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", s);
        return result;
    }

    private void backtrack(List<String> result, String current, String remaining) {
        if (remaining.isEmpty()) {
            result.add(current);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                String newCurrent = current + remaining.charAt(i);
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                backtrack(result, newCurrent, newRemaining);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        String s = "abc";
        List<String> result = permutations.permute(s);
        for (String permutation : result) {
            System.out.println(permutation);
        }
    }
}
