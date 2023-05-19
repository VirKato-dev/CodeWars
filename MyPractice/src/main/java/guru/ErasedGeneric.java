package guru;

import java.util.ArrayList;
import java.util.List;


public class ErasedGeneric {
    public static void main(String[] args) {
        List a = new ArrayList<Integer>(); // пустой
        List b = new ArrayList<String>(); // пустой
        Class c1 = a.getClass(); // для отвода глаз
        Class c2 = b.getClass(); // для отвода глаз
        System.out.println(a.equals(b)); // оба пустые == одинаковые
    }

    // true
}
