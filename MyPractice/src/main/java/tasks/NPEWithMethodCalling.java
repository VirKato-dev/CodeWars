package tasks;

public class NPEWithMethodCalling {
    class A {
        String str = "ab";

        A() {
            printLength();
        }

        void printLength() {
            System.out.println(str.length());
        }
    }


    class B extends A {
        String str = "abc";

        B() {
            super.str = this.str;
            printLength();
        }

//        void printLength() {
//            System.out.println(str.length());
//        }
    }


    public static void main(String[] args) {
        new NPEWithMethodCalling().new B();
    }
}
