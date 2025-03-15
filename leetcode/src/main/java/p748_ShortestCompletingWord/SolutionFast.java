package p748_ShortestCompletingWord;

public class SolutionFast {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        int letters = 0;
        int lp = licensePlate.length();
        for (int i = 0; i < lp; i++) {
            char c = Character.toLowerCase(licensePlate.charAt(i));

            if (c >= 'a' && c <= 'z') {
                letters++;
                count[c - 'a']++;
            }
        }
        int min = 20;
        String ans = "";

        for (String word : words) {
            int size = word.length();
            if (size < min && size >= letters && isComplete(word, count)) {
                min = size;
                ans = word;
            }
            if (min == letters)
                break;
        }

        return ans;
    }


    public boolean isComplete(String word, int[] count) {
        int[] wordCount = new int[26];
        int lp = word.length();
        for (int i = 0; i < lp; i++) {
            wordCount[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] < count[i])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new SolutionFast().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(new SolutionFast().shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
