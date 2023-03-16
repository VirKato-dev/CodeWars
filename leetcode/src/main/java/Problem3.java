/**
 * Longest Substring Without Repeating Characters
 */
public class Problem3 {
    public static void main(String[] args) {
        int res;
        assert (res = new Solution().lengthOfLongestSubstring("abcabcbb")) == 3 : "abcabcbb = " + res;
        assert (res = new Solution().lengthOfLongestSubstring("bbbbb")) == 1 : "bbbbb = " + res;
        assert (res = new Solution().lengthOfLongestSubstring("pwwkew")) == 3 : "pwwkew = " + res;
        assert (res = new Solution().lengthOfLongestSubstring("aab")) == 2 : "aab = " + res;
        assert (res = new Solution().lengthOfLongestSubstring("dvdf")) == 3 : "dvdf = " + res;
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            StringBuilder sb = new StringBuilder();
            int max = 0;
            int pos = 0;
            while (pos < s.length()) {
                char c = s.charAt(pos++);
                while (sb.indexOf("" + c) > -1) {
                    sb.deleteCharAt(0);
                }
                sb.append(c);
                max = Math.max(max, sb.length());
            }
            return max;
        }
    }
}
