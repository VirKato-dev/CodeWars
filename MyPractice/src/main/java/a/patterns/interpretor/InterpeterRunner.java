package a.patterns.interpretor;

import a.patterns.interpretor.expression.AndExpression;
import a.patterns.interpretor.expression.Expression;
import a.patterns.interpretor.expression.OrExpression;
import a.patterns.interpretor.expression.TerminalExpression;

public class InterpeterRunner {
    public static void main(String[] args) {
        Expression<String> isJava = getJavaExpression();
        Expression<String> isJavaEE = getJavaEEExpression();

        // передаём проверяемых текст
        System.out.println("Разработчик знает Java Core: " + isJava.interpret("Java Core Spring"));
        System.out.println("Разработчик знает Java EE: " + isJavaEE.interpret("Java Swing Spring"));
    }

    /**
     * Содержит в тексте "Java" или "Java Core"
     * @return true
     */
    public static Expression<String> getJavaExpression() {
        Expression<String> java = new TerminalExpression("Java");
        Expression<String> javaCore = new TerminalExpression("Java Core");

        return new OrExpression(java, javaCore);
    }

    /**
     * Содержит в тексте "Java" и "Spring"
     * @return true
     */
    public static Expression<String> getJavaEEExpression() {
        Expression<String> java = new TerminalExpression("Java");
        Expression<String> javaSpring = new TerminalExpression("Spring");

        return new AndExpression(java, javaSpring);
    }
}
