package a.patterns.refactor;

public class RefactorTest {
    public void someMethod() {
        new PrintOperative().run();
    }

    public void someElseMethod() {
        new PrintHistorical().run();
    }

    public static void main(String[] args) {
        RefactorTest refactorTest = new RefactorTest();
        refactorTest.someMethod();
        refactorTest.someElseMethod();
    }
}


abstract class TemplateMethod {
    /**
     * Полный набор действий
     */
    public final void run() {
        System.out.println("do Some usual");
        System.out.println("do Some usual1");
        method();
        System.out.println("do Some usual2");
        System.out.println("do Some usual3");
    }

    /**
     * Одно действие наследника
     */
    protected abstract void method();
}


class PrintOperative extends TemplateMethod {
    @Override
    protected void method() {
        System.out.println("operative ref");
    }
}


class PrintHistorical extends TemplateMethod {
    @Override
    protected void method() {
        System.out.println("historical ref");
    }
}