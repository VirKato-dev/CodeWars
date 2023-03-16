package a.patterns.strategy.action.fly;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can’t fly");
    }
}