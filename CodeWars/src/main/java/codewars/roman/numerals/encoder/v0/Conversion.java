package codewars.roman.numerals.encoder.v0;

public class Conversion {
    public static String solution(int n) {
        String[] r = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] a = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String res = "";
        for (int i = 0; i < a.length; i++) {
            while (n >= a[i]) {
                res += r[i];
                n -= a[i];
            }
        }
        return res;
    }
}