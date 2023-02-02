package a.interf;

public class DefaultExample {
    static class Twice implements One, Two, Three { // ромбовидное наследование
        @Override
        public String say() { // обязательно писать свою реализацию
            return Two.super.say(); // при этом указать связь с реализуемым интерфейсом
        }
    }

    public static void main(String[] args) {
        System.out.println(new Twice().say());
        System.out.println(((Three) () -> "null").say()); // say() обязателен
    }
}

interface One {
    default String say() {
        return "One";
    }
}

interface Two {
    default String say() {
        return "Two";
    }
}

interface Three {
    String say();
}
