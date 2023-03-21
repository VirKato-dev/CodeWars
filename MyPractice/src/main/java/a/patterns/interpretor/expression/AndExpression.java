package a.patterns.interpretor.expression;

/**
 * Оба выражения должны вернуть true
 */
public class AndExpression implements Expression<String> {
    private final Expression<String> exp1;
    private final Expression<String> exp2;

    public AndExpression(Expression<String> exp1, Expression<String> exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean interpret(String context) {
        return exp1.interpret(context) && exp2.interpret(context);
    }
}
