package a.patterns.interpretor;

public interface Expression<T> {
    /**
     *
     * @param context интерпретируемое
     * @return результат интерпретации
     */
    boolean interpret(T context);
}
