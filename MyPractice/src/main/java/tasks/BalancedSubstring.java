package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Вернуть длину максимальной сбалансированной подстроки.
 * Сбалансированная подстрока состоит из одинакового количества 0 и 1.
 * При этом 0 всегда перед 1.
 */
public class BalancedSubstring {

    public static void main(String[] args) {
        System.out.println("4 = " + balancedSubstring4("00100110"));
    }

    public static int balancedSubstring(String s) {
        int max = 0;
        for (int j = 0; j < s.length() / 2; j++) {
            String ss = "0".repeat(j);
            int pos = s.indexOf(ss);
            if (pos >= 0) {

            }
        }
        return max;
    }

    public static int balancedSubstring4(String s) {
        List<Integer> lengths = new ArrayList<>();
        int count = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
                length++;
            } else {
                count--;
                length++;
            }

            if (count == 0) {
                lengths.add(length);
                length = 0;
            }
        }
        int max = 0;
        for (int len : lengths) {
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    public static int balancedSubstring3(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int zeros = 0, ones = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    maxLen = Math.max(maxLen, zeros + ones);
                }
            }
        }
        return maxLen;
    }

    public static int balancedSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int length = 0;
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
            if (zeroCount == oneCount) {
                length = Math.max(length, 2 * oneCount);
            } else if (oneCount > zeroCount) {
                zeroCount = 0;
                oneCount = 0;
            }
        }
        return length;
    }


}
