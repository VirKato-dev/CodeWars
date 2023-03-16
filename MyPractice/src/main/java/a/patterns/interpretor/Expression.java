package a.patterns.interpretor;

public interface Expression<T> {
    T interpret(Expression<T> expression);
}
