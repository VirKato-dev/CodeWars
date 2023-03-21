package a.patterns.state.model;

import a.patterns.state.strategy.fly.FlyNoWay;
import a.patterns.state.strategy.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("I’m a model duck");
    }
}
