package a.patterns.absfactory;

import a.patterns.absfactory.factory.BakeryFactory;
import a.patterns.absfactory.factory.DodoFactory;
import a.patterns.absfactory.factory.DokaFactory;

public class TestFactory {
    public static void main(String[] args) {
        BakeryFactory factoryDoka = new DokaFactory();
        BakeryFactory factoryDodo = new DodoFactory();
        System.out.println(factoryDoka.createBread().getName());
        System.out.println(factoryDodo.createCookie().getName());
    }
}
