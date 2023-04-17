package a.tasks;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentlyChar {
    public static void main(String[] args) {
        String text = "Самый частый символ в тексте."
                .replaceAll(" ", "")
                .toLowerCase();
        System.out.println(find(text));
    }

    private static Character find(String text) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        Character res = null;
        for (Character c : text.toCharArray()) {
            map.merge(c, 1, Integer::sum);
            if (map.get(c) > max) {
                max = map.get(c);
                res = c;
            }
        }
//        System.out.println(res + " - " + max);
        return res;
    }
}
