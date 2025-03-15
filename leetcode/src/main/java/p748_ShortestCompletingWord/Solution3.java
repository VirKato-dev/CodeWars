package p748_ShortestCompletingWord;

import java.util.ArrayList;

public class Solution3 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        ArrayList<Character> al = new ArrayList<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            if (Character.isLetter(licensePlate.charAt(i))) {
                al.add(Character.toLowerCase(licensePlate.charAt(i)));
            }
        }

        int c = Integer.MAX_VALUE;
        String result = "";

        for (String word : words) {
            ArrayList<Character> a = new ArrayList<>(al);
            for (int j = 0; j < word.length(); j++) {
                if (a.contains(word.charAt(j))) {
                    a.remove(Character.valueOf(word.charAt(j)));
                }
            }
            if (a.isEmpty() && c > word.length()) {
                c = word.length();
                result = word;

            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(new Solution3().shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
