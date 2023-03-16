package a.patterns.interpretor;

public class ToLowerExpression implements Expression<String> {
    private String s;

    public ToLowerExpression(String text) {
        s = text;
    }

    @Override
    public String interpret(Expression<String> exp) {
        return null;
    }
}
