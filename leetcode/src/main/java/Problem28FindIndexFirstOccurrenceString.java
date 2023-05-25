public class Problem28FindIndexFirstOccurrenceString {

    public static void main(String[] args) {
        System.out.println(new SolutionMy()
                .strStr("sadbutsad", "sad")); // 0
        System.out.println(new SolutionMy()
                .strStr("leetcode", "leeto")); // -1
        System.out.println(new SolutionMy()
                .strStr("hello", "ll")); // 2
        System.out.println(new SolutionMy()
                .strStr("abc", "c")); // 2
    }


    static class SolutionMy {
        public int strStr(String haystack, String needle) {
            int pos = 0;
            int h = haystack.length();
            int n = needle.length();
            if (haystack.length() >= n) {
                StringBuilder sb = new StringBuilder(haystack.substring(0, n));
                while (pos + n <= h) {
                    if (sb.toString().equals(needle)) return pos;
                    if (pos + n >= h) return -1;
                    sb.deleteCharAt(0);
                    sb.append(haystack.charAt(pos + n));
                    pos++;
                }
            }
            return -1;
        }
    }


    static class SolutionFast {
        public int strStr(String haystack, String needle) {
            int m = haystack.length();
            int n = needle.length();
            for (int i = 0; i < m - n + 1; ++i)
                if (haystack.substring(i, i + n).equals(needle)) return i;
            return -1;
        }
    }


    static class SolutionLowMemory {
        public int strStr(String haystack, String needle) {
            if (needle.length() > haystack.length()) return -1;
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                int j = 0;
                while (j < needle.length() && needle.charAt(j) == haystack.charAt(i + j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
            return -1;
        }
    }
}
