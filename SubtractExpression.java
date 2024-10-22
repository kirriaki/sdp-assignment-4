package assign4.first1;

import assign4.first1.IExpression;

public class SubtractExpression implements IExpression {
    private final IExpression leftExpression;
    private final IExpression rightExpression;

    public SubtractExpression(IExpression leftExpression, IExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}
