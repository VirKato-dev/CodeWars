package a.interf;

/**
 * Ромбовидное наследование интерфейсов
 */
public class DiamondInheritance implements A, B {

    public static void main(String[] args) {
        new DiamondInheritance().act();
    }

    @Override
    public void act() {
        B.super.act();
    }
}


interface A {
    default void act() {
        System.out.println("AAA");
    }
}


interface B {
    default void act() {
        System.out.println("BBB");
    }
}
