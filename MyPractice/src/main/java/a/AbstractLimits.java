package a;

public class AbstractLimits {

    private static abstract class Animal {
        static int state = 5;

        public final int what() {
            return state;
        }
    }


    private static class Cat extends Animal {
    }


    public static void main(String[] args) {
        System.out.println(new Cat().what());
    }
}
