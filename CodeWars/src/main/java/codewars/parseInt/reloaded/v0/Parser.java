package codewars.parseInt.reloaded.v0;

import java.util.Scanner;

public class Parser {

    public static void main(String[] args) {
        System.out.println(parseInt("one"));
        System.out.println(parseInt("twenty"));
        System.out.println(parseInt("two hundred forty-six"));
        System.out.println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
    }

    enum Word {
        zero(0), one(1), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9),
        ten(10), eleven(11), twelve(12), thirteen(13), fourteen(14), fifteen(15), sixteen(16),
        seventeen(17), eighteen(18), nineteen(19), twenty(20), thirty(30), forty(40), fifty(50),
        sixty(60), seventy(70), eighty(80), ninety(90), hundred(100), thousand(1000), million(1000000);

        final int val;

        Word(int v) {
            val = v;
        }
    }

    static String five = "-|( and )";

    public static int parseInt(String numStr) {
        int m = 0;
        int t = 0;
        int res = 0;
        numStr = numStr.replaceAll(five, " ");
        Scanner in = new Scanner(numStr);
        while (in.hasNext()) {
            String w = in.next().toLowerCase();
            int v = Word.valueOf(w).val;
            switch (v) {
                case 100 -> res *= v;
                case 1000 -> {
                    t = res;
                    res = 0;
                }
                case 1000000 -> {
                    m = res;
                    res = 0;
                }
                default -> res += v;
            }
        }
        return m * 1000000 + t * 1000 + res;
    }
}