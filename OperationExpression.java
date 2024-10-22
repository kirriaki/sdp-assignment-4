package assign4.first1;

public class OperationExpression implements IExpression {
    private final IExpression leftExpression;
    private final IExpression rightExpression;
    private final String operator;

    public OperationExpression(IExpression leftExpression, String operator, IExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int interpret() {
        switch (operator) {
            case "+":
                return leftExpression.interpret() + rightExpression.interpret();
            case "-":
                return leftExpression.interpret() - rightExpression.interpret();
            default:
                throw new UnsupportedOperationException("Operator " + operator + " is not supported");
        }
    }
}
