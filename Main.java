package assign4.first1;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = JOptionPane.showInputDialog("Enter the first number:");
        int number1 = Integer.parseInt(input1);
        String operator = JOptionPane.showInputDialog("Enter the operator (+, -, *, /):");
        String input2 = JOptionPane.showInputDialog("Enter the second number:");
        int number2 = Integer.parseInt(input2);
        IExpression expression = null;
        switch (operator) {
            case "+":
                expression = new AddExpression(new NumberExpression(number1), new NumberExpression(number2));
                break;
            case "-":
                expression = new SubtractExpression(new NumberExpression(number1), new NumberExpression(number2));
                break;
            case "*":
                expression = new MultiplicationExpression(new NumberExpression(number1), new NumberExpression(number2));
                break;
            case "/":
                expression = new DivisionExpression(new NumberExpression(number1), new NumberExpression(number2));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid operator entered.");
                System.exit(0);
        }
        int result = expression.interpret();
        JOptionPane.showMessageDialog(null, "Result: " + result);
        scanner.close();
    }
}
