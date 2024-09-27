import java.util.Stack;

public class PostfixEvaluator {
    public int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        System.out.println("Evaluating postfix expression: " + expression);

        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token, operand1, operand2);
                stack.push(result);
                System.out.println("Performed operation: " + operand1 + " " + token + " " + operand2 + " = " + result);
            } else {
                stack.push(Integer.parseInt(token));
                System.out.println("Pushed operand: " + token);
            }
        }

        int result = stack.pop();
        System.out.println("Final result: " + result);
        return result;
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2; 
            default:
                throw new RuntimeException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String expression = "2 1 + 3 *";
        int result = evaluator.evaluate(expression);
        System.out.println("Final output: " + result);
    }
}
