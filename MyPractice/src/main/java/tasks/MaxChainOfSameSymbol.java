package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxChainOfSameSymbol {
    public static void main(String[] args) {
        String text = "aabbbcccc";
        System.out.println(maxChain(text)); // {c=4}


        // то что нужно было
        String str = "aaabbaabbbcc";
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        Character curr = '\0';

        for(Character c : str.toCharArray()) {
            if (!c.equals(curr)) {
                curr = c;
                count = 0;
            }
            count++;
            if (count > map.getOrDefault(c, 0)) {
                map.put(curr, count);
            }
        }
        System.out.println(map);
    }


    private static Map<String, Integer> maxChain(String text) {
        int max = 0;
        String letter = "";
        int count = 0;
        String last = String.valueOf(text.charAt(0));

        for (String s : text.split("")) {
            if (!s.equals(last)) {
                count = 1;
                last = s;
            } else {
                count++;
                if (max < count) {
                    max = count;
                    letter = last;
                }
            }
        }

        return Map.of(letter, max);
    }


    private static Map<String,Long> maxChain2(String text) {
        return Arrays.stream(text.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<Character, Integer> getMaxCharLengths(String str) {
        Map<Character, Integer> charLengths = new HashMap<>();
        int maxLen = 0;
        char lastChar = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == lastChar) {
                maxLen++;
            } else {
                charLengths.put(lastChar, Math.max(charLengths.getOrDefault(lastChar, 0), maxLen));
                maxLen = 1;
                lastChar = str.charAt(i);
            }
        }
        charLengths.put(lastChar, Math.max(charLengths.getOrDefault(lastChar, 0), maxLen));

        return charLengths;
    }
}
