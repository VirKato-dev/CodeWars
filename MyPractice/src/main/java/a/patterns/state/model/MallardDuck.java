package a.patterns.state.model;

import a.patterns.state.strategy.fly.FlyWithWings;
import a.patterns.state.strategy.quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I’m a real Mallard duck");
    }
}
