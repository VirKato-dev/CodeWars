package p748_ShortestCompletingWord;

import java.util.Arrays;

/**
 * Given a string licensePlate and an array of strings words, find the shortest completing word in words.<br>
 * A completing word is a word that contains all the letters in licensePlate.
 * Ignore numbers and spaces in licensePlate, and treat letters as case insensitive.
 * If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.<br>
 * For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice.
 * Possible completing words are "abccdef", "caaacab", and "cbca".<br>
 * Return the shortest completing word in words.
 * It is guaranteed an answer exists.
 * If there are multiple shortest completing words, return the first one that occurs in words.<br><br>
 * <b>Example 1:</b><br>
 * Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]<br>
 * Output: "steps"<br>
 * <b>Explanation:</b> licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.<br>
 * "step" contains 't' and 'p', but only contains 1 's'.<br>
 * "steps" contains 't', 'p', and both 's' characters.<br>
 * "stripe" is missing an 's'.<br>
 * "stepple" is missing an 's'.<br>
 * Since "steps" is the only word containing all the letters, that is the answer.<br>
 * <br>
 * <b>Example 2:</b><br>
 * Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]<br>
 * Output: "pest"<br>
 * <b>Explanation:</b> licensePlate only contains the letter 's'.
 * All the words contain 's', but among these "pest", "stew", and "show" are shortest.
 * The answer is "pest" because it is the word that appears earliest of the 3.<br>
 * <br>
 * <b>Constraints:</b>
 * 1 <= licensePlate.length <= 7<br>
 * licensePlate contains digits, letters (uppercase or lowercase), or space ' '.<br>
 * 1 <= words.length <= 1000<br>
 * 1 <= words[i].length <= 15<br>
 * words[i] consists of lower case English letters.
 */
public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] chars = licensePlate.chars()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .toArray();

        Arrays.stream(chars).forEach(i -> System.out.print(Character.valueOf((char) i)));
        System.out.println();

        int resultWord = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            int charPos = 0;
            String word = words[i];
            while (charPos < chars.length) {
                word = word.replaceFirst(Character.toString(chars[charPos++]), "");
            }

            int matches = words[i].length() - word.replaceAll(" ", "").length();
            System.out.println(String.format("%2d - %s", matches, words[i]));

            if (matches == chars.length && words[i].length() < minLength) {
                minLength = Math.min(minLength, words[i].length());
                resultWord = i;
            }
        }

        return words[resultWord];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(new Solution().shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}