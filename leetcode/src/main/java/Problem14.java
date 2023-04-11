import java.util.Arrays;

/**
 * Longest Common Prefix
 */
public class Problem14 {
    public static void main(String[] args) {
        SolutionGood solution = new SolutionGood();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"wild", "willow", "will"}));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        while (!strs[0].isEmpty() && strs[0].length() > result.length()) {
            String next = String.valueOf(strs[0].charAt(result.length()));
            boolean isCommon = true;
            for (String s : strs) {
                if (!s.startsWith(result + next)) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) {
                result += next;
            } else {
                break;
            }
        }
        return result;
    }
}


class SolutionBest {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}


class SolutionGood {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        boolean isPrefix = true;
        while (isPrefix && sb.length() < strs[0].length()) {
            sb.append(strs[0].charAt(sb.length()));
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(sb.toString())) {
                    isPrefix = false;
                    sb.deleteCharAt(sb.length()-1);
                    break;
                }
            }
        }
        return sb.toString();
    }
}