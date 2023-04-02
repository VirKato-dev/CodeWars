package a.patterns.refactor.template;

public class RefactorTest {
    public static void main(String[] args) {
        RefactorTemplateMethod refactorOperative = new RefactorOperative();
        RefactorTemplateMethod refactorHistorical = new RefactorHistorical();
        refactorOperative.doAction();
        refactorHistorical.doAction();
    }
}


abstract class RefactorTemplateMethod {
    /**
     * Набор действий
     */
    public void doAction() {
        System.out.println("do Some usual");
        System.out.println("do Some usual1");
        childAction();
        System.out.println("do Some usual2");
        System.out.println("do Some usual3");
    }

    /**
     * Действие наследника
     */
    protected abstract void childAction();
}


class RefactorOperative extends RefactorTemplateMethod {
    @Override
    protected void childAction() {
        System.out.println("operative ref");
    }
}


class RefactorHistorical extends RefactorTemplateMethod {
    @Override
    protected void childAction() {
        System.out.println("historical ref");
    }
}