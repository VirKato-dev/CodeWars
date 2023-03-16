package a.patterns.strategy.action.fly;

public class FlyRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("I’m flying with a rocket!");
    }
}
