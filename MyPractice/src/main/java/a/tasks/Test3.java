package a.tasks;

public class Test3 {
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
        new Test3().new B();
    }
}
