package codewars.roman.numerals.encoder.v3;

public class Conversion {

    public String solution(int n) {
        String rg = "";

        System.out.println(n);

        // Tausender
        for (int i = 0; i < n / 1000; i++) rg += "M";

        // restliche Stellen
        String[][] t = {{"C", "D", "M"}, {"X", "L", "C"}, {"I", "V", "X"}};
        for (int i = 0; i < 3; i++) {
            String s = "";
            int c = String.valueOf(n % 1000 + 1000).substring(1).charAt(i) - '0';
            if (c > 4) s = t[i][1];
            if (c % 5 < 4) for (int z = 0; z < c % 5; z++) s += t[i][0];
            if (c == 4) s = t[i][0] + t[i][1];
            if (c == 9) s = t[i][0] + t[i][2];
            rg += s;
        }

        return rg;
    }
}