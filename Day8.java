public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

    
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

    
        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "the sky is blue";
        String output = solution.reverseWords(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
