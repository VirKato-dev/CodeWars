package a.patterns.strategy.model;

import a.patterns.strategy.action.fly.FlyNoWay;
import a.patterns.strategy.action.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("I’m a model duck");
    }
}
