package a.patterns.refactor.state;

public class RefactorTest {
    public static void main(String[] args) {
        ChildActionStrategy printOperative = new PrintOperative();
        ChildActionStrategy printHistorical = new PrintHistorical();
        RefactorState refactorState = new RefactorState();

        refactorState.setAction(printOperative);
        refactorState.someMethod();

        refactorState.setAction(printHistorical);
        refactorState.someMethod();
    }
}


class RefactorState {
    private ChildActionStrategy action;

    public void setAction(ChildActionStrategy action) {
        this.action = action;
    }

    public void someMethod() {
        System.out.println("do Some usual");
        System.out.println("do Some usual1");
        if (action != null) action.run();
        System.out.println("do Some usual2");
        System.out.println("do Some usual3");
    }
}


interface ChildActionStrategy extends Runnable {
}


class PrintOperative implements ChildActionStrategy {
    @Override
    public void run() {
        System.out.println("operative ref");
    }
}


class PrintHistorical implements ChildActionStrategy {
    @Override
    public void run() {
        System.out.println("historical ref");
    }
}