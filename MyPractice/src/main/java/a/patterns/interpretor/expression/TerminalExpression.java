package a.patterns.interpretor.expression;

/**
 * Конечное выражение возвращающее результат проверки
 */
public class TerminalExpression implements Expression<String> {

    private final String data;

    /**
     * Настройка конечного выражения
     * @param data искомая строка в интерпретируемой строке
     */
    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
