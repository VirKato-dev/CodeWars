package p3110_ScoreOfAString;

/**
 * You are given a string `s`.
 * The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.<br><br>
 * Return the score of s.<br>
 * <br><br>
 * <b>Example 1:</b><br>
 * Input: s = "hello"<br>
 * Output: 13<br>
 * <b>Explanation:</b><br>
 * The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111.<br>
 * So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
 * <br><br>
 * <b>Example 2:</b><br>
 * Input: s = "zaz"<br>
 * Output: 50<br>
 * <b>Explanation:</b><br>
 * The ASCII values of the characters in s are: 'z' = 122, 'a' = 97.<br>
 * So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.
 * <br><br>
 * <b>Constraints:</b><br>
 * 2 <= s.length <= 100<br>
 * s consists only of lowercase English letters.
 */
public class Solution3110 {
    public int scoreOfString(String s) {
        int score = 0;
        char[] chars = s.toCharArray();
        for (int j = 0; j < s.length() - 1; j++) {
            score += Math.abs(chars[j] - chars[j + 1]);
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3110().scoreOfString("hello"));
    }
}
