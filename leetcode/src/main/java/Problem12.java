/**
 * Integer to Roman
 */
public class Problem12 {
    public static void main(String[] args) {
        String res;
        assert (res = intToRoman(3)).equals("III") : "3 = " + res;
        assert (res = intToRoman(58)).equals("LVIII") : "58 = " + res;
        assert (res = intToRoman(1994)).equals("MCMXCIV") : "1994 = " + res;
    }

    public static String intToRoman(int num) {
        String[] r = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] a = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (num > 0) {
            if (num >= a[i]) {
                sb.append(r[i]);
                num -= a[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    // ------- Fast

    public static String intToRoman2(int num) {
        StringBuilder s = new StringBuilder();
        while(num>=1000) { s.append('M'); num -= 1000; }
        if(num>=900) { s.append("CM"); num -= 900; }
        if(num>=500) { s.append('D'); num -= 500; }
        if(num>=400) { s.append("CD"); num -= 400; }
        while(num>=100) { s.append('C'); num -= 100; }
        if(num>=90) { s.append("XC"); num -= 90; }
        if(num>=50) { s.append('L'); num -= 50; }
        if(num>=40) { s.append("XL"); num -= 40; }
        while(num>=10) { s.append('X'); num -= 10; }
        if(num==9) { s.append("IX"); num -= 9; return s.toString(); }
        if(num>=5) { s.append('V'); num -= 5; }
        if(num==4) { s.append("IV"); num -= 4; return s.toString(); }
        while(num>=1) { s.append('I'); num -= 1; }
        return s.toString();
    }


}
