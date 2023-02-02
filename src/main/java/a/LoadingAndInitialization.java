package a;

public class LoadingAndInitialization {

    static class One {
        private final Two two = new Two();

        static {
            System.out.println("Init One");
        }

        {
            System.out.println("Object One");
            System.out.println(two.get());
        }

        public String get() {
            return "Hello";
        }
    }


    static class Two {
        static {
            System.out.println("Init Two");
        }

        public Two() {
            System.out.println("from Two constructor");
        }

        {
            System.out.println("Object Two");
        }

        {
            System.out.println("Second text from Two");
        }

        public String get() {
            return "text from Two";
        }
    }


    public static void main(String[] args) {
        One one = new One();
        System.out.println(one.get());
    }
}
