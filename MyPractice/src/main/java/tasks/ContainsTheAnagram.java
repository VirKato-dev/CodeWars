package tasks;

import java.util.HashMap;
import java.util.Map;

public class ContainsTheAnagram {
    public static void main(String[] args) {
        System.out.println(check("asdfghjkl", "hgfdj")); // true
        System.out.println(check("asdfghjkl", "plm"));   // false
        System.out.println(check("asdfghjkl", ""));      // true
        System.out.println(check("", "acb"));            // false
    }

    /**
     * Можно ли в первой строке найти подстроку
     * для которой будет верна анаграмма во второй строке
     *
     * @param text    исходная строка
     * @param request анаграмма для поиска в первой строке
     * @return true найдена
     */
    private static boolean check(String text, String request) {
        if (request == null || request.isEmpty()) return true;
        if (text == null || text.isEmpty()) return false;
        Map<Character, Integer> frame = new HashMap<>();
        int position = 0;
        int size = 0;
        while (position + size < text.length()) {
            if (size < request.length()) {
                frame.merge(text.charAt(position + size), 1, Integer::sum);
                size++;
            } else {
                for (String c : request.split("")) {
                    if (frame.containsKey(c.charAt(0))) {
                        frame.merge(c.charAt(0), -1, Integer::sum);
                    }
                }
                if (frame.values().stream().reduce(Integer::sum).orElse(0) == 0) {
                    return true;
                } else {
                    size = 0;
                    frame.clear();
                    position++;
                }
            }
        }
        return false;
    }
}
