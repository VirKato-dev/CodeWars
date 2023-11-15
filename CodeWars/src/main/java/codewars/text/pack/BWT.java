package codewars.text.pack;

import java.util.*;

/**
 * Burrows Wheeler Transformation
 */
public class BWT {

    public static void main(String[] args) {
        BWT bwt = new BWT("", -1);
        bwt.encode("bananabar");
        System.out.println(bwt.s + ", " + bwt.n);
        System.out.println(bwt.decode());
        bwt.encode("friend");
        System.out.println(bwt.s + ", " + bwt.n);
    }

    public String s;
    public int n;

    public BWT(String s, int n) {
        this.s = s;
        this.n = n;
    }


    public void encode(String input) {
        StringBuilder result = new StringBuilder();
        if (input != null && !input.isEmpty()) {
            List<String> options = new ArrayList<>();
            for (int j = 0; j < input.length(); j++) {
                options.add(input);
                input = input.charAt(input.length() - 1) + input.substring(0, input.length() - 1);
            }
            input = options.get(0);
            Collections.sort(options);
            for (String s : options) {
                result.append(s.charAt(s.length() - 1));
            }
            n = options.indexOf(input);
            s = result.toString();
        }
    }


    public String decode() {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        System.out.println(s);
        System.out.println(sorted);

        List<String> pairs = new ArrayList<>();
        String result = "";
        for (int j = 0; j < s.length(); j++) {
            if (j == n) {
                result = String.valueOf(s.charAt(j));
            } else {
                pairs.add(String.valueOf(s.charAt(j)) + String.valueOf(sorted.charAt(j)));
            }
        }
        return process(pairs, result);
    }

    private String process(List<String> pairs, String result) {
        System.out.println(pairs + " -- " + result);
        if (pairs == null || pairs.isEmpty()) return result;
        for (int j = pairs.size() - 1; j >= 0; j--) {
            int len = result.length();
            String pair = pairs.get(j);
            if (pair.endsWith(String.valueOf(result.charAt(0)))) {
                System.out.println(pairs.remove(j));
                result = process(pairs, pair.charAt(0) + result);
                if (len == result.length()) {
                    pairs.add(j, pair);
                }
            }
        }
        return result;
    }


    @Override
    public String toString() {
        return "BWT{" +
                "s='" + s + '\'' +
                ", n=" + n +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BWT bwt = (BWT) o;
        return n == bwt.n && Objects.equals(s, bwt.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, n);
    }
}

// "nnbbraaaa", 4
// "aaaabbnnr"
// 0   3   7   5   1   6   4   468 2
// 4rb 5ab 6an 7an 8ar 0na 1na 2ba 3ba
//           <--
// ba an na an na ab ba ar rb
// b  a  n  a  n  a  b  a  r

// ----

// shift right 6 times
// friend
// dfrien
// ndfrie
// endfri
// iendfr
// riendf

// sort & get last column
//      v
// dfrien
// endfri
// friend - 2 right sequence
// iendfr
// ndfrie
// riendf
//      ^

// "nidref", 2
// "definr" - sorted input

//  0   4   2   5   1   3
// 2df 3ri 4en 5fr 0nd 1ie
//       <--
// fr ri ie en nd df
// f  r  i  e  n  d
