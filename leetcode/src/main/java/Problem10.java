/**
 * Regular Expression Matching<br>
 * Given an input string s and a pattern p,<br>
 * implement regular expression matching with support for '.' and '*' where:<br>
 * '.' Matches any single character.<br>
 * '*' Matches zero or more of the preceding element.<br>
 * The matching should cover the <b>entire</b> input string (not partial).
 */
public class Problem10 {
    public static void main(String[] args) {
        boolean res;
        assert (res = !isMatch("aa", "a")) : "'aa', 'a' = " + res;
        assert (res = isMatch("aa", "a*")) : "'aa', 'a*' = " + res;
        assert (res = isMatch("ab", ".*")) : "'ab', '.*' = " + res;
        assert (res = isMatch("aab", "c*a*b")) : "'aab', 'c*a*b' = " + res;
        assert (res = !isMatch("mississippi", "mis*is*p*.")) : "'mississippi', 'is*is*p*.' = " + res;
    }

    // ------- Recursion

    public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();

        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    // ------- Dynamic Programming

    /**
     * Bottom-up variant
     */
    public static boolean isMatch2(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    // -------

    enum Result {
        TRUE, FALSE
    }

    static Result[][] memo;

    /**
     * Top-down variant
     */
    public static boolean isMatch3(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public static boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (dp(i, j + 2, text, pattern) ||
                        first_match && dp(i + 1, j, text, pattern));
            } else {
                ans = first_match && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
