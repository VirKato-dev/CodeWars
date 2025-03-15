package p748_ShortestCompletingWord;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        String res = licensePlate.replaceAll("[^a-zA-Z]+", "").toLowerCase();
        String finalRes = "";
        for (String s : words) {
            Map<Character, Integer> dup = new HashMap<>();
            for (int i = 0; i < res.length(); i++) {
                if (s.indexOf(res.charAt(i), dup.getOrDefault(res.charAt(i), 0)) != -1) {
                    if (dup.containsKey(res.charAt(i))) {
                        dup.put(res.charAt(i), s.indexOf(res.charAt(i), dup.get(res.charAt(i))) + 1);
                    } else {
                        dup.put(res.charAt(i), s.indexOf(res.charAt(i)) + 1);
                    }
                } else {
                    break;
                }
                if (i == res.length() - 1 && (finalRes.isEmpty() || finalRes.length() > s.length())) {
                    finalRes = s;
                }
            }
        }
        return finalRes;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(new Solution2().shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
