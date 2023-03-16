/**
 * Zigzag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class Problem6 {
    public static void main(String[] args) {
        String res;
        assert (res = convert("PAYPALISHIRING", 3)).equals("PAHNAPLSIIGYIR") : "PAYPALISHIRING = " + res;
        assert (res = convert("PAYPALISHIRING", 4)).equals("PINALSIGYAHRPI") : "PAYPALISHIRING = " + res;
        assert (res = convert("A", 1)).equals("A") : "A = " + res;
        assert (res = convert("A", 2)).equals("A") : "A = " + res;
        assert (res = convert("AB", 1)).equals("AB") : "AB = " + res;
    }


    public static String convert(String s, int numRows) {
        int d = numRows < 2 ? 0 : -1;
        int l = 0;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (char c : s.toCharArray()) {
            if (sb[l] == null) sb[l] = new StringBuilder();
            sb[l].append(c);
            if (l == numRows - 1 || l == 0) d *= -1;
            l += d;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) res.append(sb[i] == null ? "" : sb[i]);
        return res.toString();
    }


    public static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int k = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < n) {
                str.append(s.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    int k1 = k - (2 * i);
                    int k2 = index + k1;
                    if (k2 < n) {
                        str.append(s.charAt(k2));
                    }
                }
                index = index + k;
            }
        }
        return str.toString();
    }


    public static String convert3(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder answer = new StringBuilder();
        int n = s.length();
        int charsInSection = 2 * (numRows - 1);

        for (int currRow = 0; currRow < numRows; ++currRow) {
            int index = currRow;

            while (index < n) {
                answer.append(s.charAt(index));

                // If currRow is not the first or last row
                // then we have to add one more character of current section.
                if (currRow != 0 && currRow != numRows - 1) {
                    int charsInBetween = charsInSection - 2 * currRow;
                    int secondIndex = index + charsInBetween;

                    if (secondIndex < n) {
                        answer.append(s.charAt(secondIndex));
                    }
                }
                // Jump to same row's first character of next section.
                index += charsInSection;
            }
        }

        return answer.toString();
    }
}
