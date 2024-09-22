import java.util.HashMap;
import java.util.Map;

public class SubstringCounter {
    public int countSubstringsWithExactlyKDistinctChars(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);

            while (charCount.size() > k) {
                charCount.put(s.charAt(left), charCount.get(s.charAt(left)) - 1);
                if (charCount.get(s.charAt(left)) == 0) {
                    charCount.remove(s.charAt(left));
                }
                left++;
            }

            count += i - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        SubstringCounter counter = new SubstringCounter();
        String s = "pqpqs";
        int k = 2;

        int count = counter.countSubstringsWithExactlyKDistinctChars(s, k);
        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + count);

        System.out.println("All substrings with exactly " + k + " distinct characters:");
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                Map<Character, Integer> charCount = new HashMap<>();
                for (char c : substring.toCharArray()) {
                    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                }
                if (charCount.size() == k) {
                    System.out.println(substring);
                }
            }
        }
    }
}
