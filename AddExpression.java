
package assign4.first1;

public class AddExpression implements IExpression {
    private final IExpression leftExpression;
    private final IExpression rightExpression;

    public AddExpression(IExpression leftExpression, IExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

