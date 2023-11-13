package codewars.roman.numerals.helper;

public class RomanNumerals {
    private final static int[] ARABIC = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] ROMAN = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String toRoman(int n) {
        String result = "";
        for (int j = 0; j < ARABIC.length; j++) {
            while (n >= ARABIC[j]) {
                n -= ARABIC[j];
                result += ROMAN[j];
            }
        }
        return result;
    }

    public static int fromRoman(String romanNumeral) {
        int result = 0;
        for (int j = 0; j < ROMAN.length; j++) {
            while (!romanNumeral.isEmpty() && romanNumeral.startsWith(ROMAN[j])) {
                result += ARABIC[j];
                romanNumeral = romanNumeral.substring(ROMAN[j].length());
            }
        }
        return result;
    }
}