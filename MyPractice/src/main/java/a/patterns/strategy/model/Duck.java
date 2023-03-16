package a.patterns.strategy.model;

import a.patterns.strategy.action.fly.FlyBehavior;
import a.patterns.strategy.action.quack.QuackBehavior;

public abstract class Duck {
    /**
     * Изменяемое поведение <b>Полёт</b>
     */
    FlyBehavior flyBehavior;
    /**
     * Изменяемое поведение <b>Кряканье</b>
     */
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    /**
     * Изменить реализацию полёта
     * @param fb реализация
     */
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    /**
     * Изменить реализацию кряканья
     * @param qb реализация
     */
    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}