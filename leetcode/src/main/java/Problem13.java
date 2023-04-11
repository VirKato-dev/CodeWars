/**
 * Roman to Integer
 */
public class Problem13 {
    public static void main(String[] args) {
        System.out.println(SolutionBest.romanToInt("CL"));
    }

    static class Solution {
        public static int romanToInt(String s) {
            String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

            int result = 0;
            while (s.length() > 0) {
                for (int j = 0; j < roman.length; j++) {
                    while (s.startsWith(roman[j])) {
                        s = s.substring(roman[j].length());
                        result += arab[j];
                    }
                }
            }

            return result;
        }
    }


    static class SolutionBest {
        public static int romanToInt(String s) {
            int sum= 0, value = 0, prev = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                switch (s.charAt(i)) {
                    case 'I': value = 1; break;
                    case 'V': value = 5; break;
                    case 'X': value = 10; break;
                    case 'L': value = 50; break;
                    case 'C': value = 100; break;
                    case 'D': value = 500; break;
                    case 'M': value = 1000; break;
                }
                if (value < prev) sum -= value;
                else sum += value;
                prev = value;
            }
            return sum;
        }
    }
}
