package guru.print;

class A {
    public static void print() {
        System.out.println("A.print() is called");
    }
}

class B extends A {
    public static void print() {
        System.out.println("B.print() is called");
    }
}

public class PrintCalledFrom {

    public static void main(String[] args) {
        A var = new B();
        var.print();
    }
}
