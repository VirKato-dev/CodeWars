package guru;

import java.util.Arrays;

/**
 * Каким будет результат компиляции и выполнения?
 * Ответ зависит от входной точки.
 * HelloWorldOneTwo.main - переполнение
 * HelloWorldOneTwo.Hard.main - вывод Hello World!
 * Default.main - переполнение
 */
public class HelloWorldOneTwo {
    public static void main(String[] args) {
        Default.main(new String[]{"One", "Two"});
    }

    static class Hard {
        public static void main(String[] args) {
            System.out.println("Hello World!");
        }
    }
}

class Default extends HelloWorldOneTwo {
    public static void main(String[] args) {
        System.out.println("What? " + Arrays.toString(args));
        main(new String[]{});
    }
}
