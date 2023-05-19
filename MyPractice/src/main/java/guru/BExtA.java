package guru;

abstract class A {
    int a = 8; // инициализируется перед конструктором

    public A() { // вызывается при создании потомка
        show(); // вызовется у потомка
    }

    abstract void show();
}


public class BExtA extends A {
    int a = 90; // инициализируется перед вызовом конструктора

    void show() { // вызовется из предка в данном случае
        System.out.println("" + a);
    }

    public static void main(String[] args) {
        new BExtA();
        // 1 инициализация полей предка
        // 2 конструктор предка
        // 3 вызов метода потомка
        // 4 инициализация полей потомка
        // 5 вызов конструктора потомка
    }
}
