import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()";
        boolean result = solution.isValid(s);
        if (result) {
            System.out.println("The string is valid.");
            System.out.println("Explanation: The string contains a matching pair of parentheses."); // Closed the string literal
        } else {
            System.out.println("The string is not valid.");
            System.out.println("Explanation: The string does not contain a matching pair of parentheses or the brackets are not closed in the correct order.");
        }
    }
}
