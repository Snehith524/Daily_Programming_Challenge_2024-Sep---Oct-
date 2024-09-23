public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0; 
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }
        int start = 0;
        for (int end = 0; end < n; end++) {
            start = Math.max(start, lastIndex[s.charAt(end)] + 1);
            res = Math.max(res, end - start + 1);
            lastIndex[s.charAt(end)] = end;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + solution.lengthOfLongestSubstring(s));
    }
}
