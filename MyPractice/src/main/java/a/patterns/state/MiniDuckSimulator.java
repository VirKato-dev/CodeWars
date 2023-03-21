package a.patterns.state;

import a.patterns.state.strategy.fly.FlyRocketPowered;
import a.patterns.state.model.Duck;
import a.patterns.state.model.MallardDuck;
import a.patterns.state.model.ModelDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}