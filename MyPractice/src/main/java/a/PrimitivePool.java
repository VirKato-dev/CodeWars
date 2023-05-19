package a;

import java.util.concurrent.atomic.AtomicInteger;

public class PrimitivePool {
    public static void main(String[] args) {
        String str = "Ja" + "va"; // str == "Java" = true
        System.out.println(str == "Java");
        str = str + "!"; // str == "Java!" = false
        System.out.println(str == "Java!");
    }
}
