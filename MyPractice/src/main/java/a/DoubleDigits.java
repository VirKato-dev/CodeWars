package a;

public class DoubleDigits {
    public static void main(String[] args) {
        int input = 765;
        System.out.println(process(input));
    }

    private static String process(int input) {
        long result = 0;
        long offset = 1;

        while (input > 0) {
            int a = input % 10;

            a *= a;

            result += a * offset;

            if (a > 9) {
                offset *= 100;
            } else {
                offset *= 10;
            }

            input /= 10;
        }
        return Long.toString(result);
    }
}