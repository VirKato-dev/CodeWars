package a.interf;

public class FromInterfaceField {
    public static void main(String[] args) {
        System.out.println(Inter1.field);
        System.out.println(new Class1().field);
    }
}

interface Inter1 {
    String field = "КОНСТАНТА";
}

class Class1 implements Inter1 {

}
