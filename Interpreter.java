package assign4.first1;

import java.util.Stack;

public class Interpreter {
    public static IExpression interpret(String input) {
        String[] tokens = input.trim().split("\\s+");
        Stack<IExpression> stack = new Stack<>();

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(new NumberExpression(Integer.parseInt(token)));
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) { // Check for operators
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Not enough operands in the expression.");
                }
                IExpression right = stack.pop();
                IExpression left = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(new AddExpression(left, right));
                        break;
                    case "-":
                        stack.push(new SubtractExpression(left, right));
                        break;
                    case "*":
                        stack.push(new MultiplicationExpression(left, right));
                        break;
                    case "/":
                        stack.push(new DivisionExpression(left, right));
                        break;
                }
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("ERROR.");
        }

        return stack.pop();
    }
}
