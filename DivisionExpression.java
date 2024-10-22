package assign4.first1;

public class DivisionExpression implements IExpression {
    private final IExpression leftExpression;
    private final IExpression rightExpression;

    public DivisionExpression(IExpression leftExpression, IExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        int right = rightExpression.interpret();
        if (right == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return leftExpression.interpret() / right;
    }
}
