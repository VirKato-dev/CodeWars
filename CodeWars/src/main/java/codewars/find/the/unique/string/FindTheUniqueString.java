package codewars.find.the.unique.string;

import java.util.HashMap;
import java.util.Map;

public class FindTheUniqueString {
    public static void main(String[] args) {
//        System.out.println(findUniq(new String[]{"Aa", "aaa", "aaaaa", "BbBb", "Aaaa", "AaAaAa", "a"}));
        System.out.println(findUniq(new String[]{"abc", "acb", "bac", "foo", "bca", "cab", "cba"}));
    }


    public static String findUniq(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        String s = "";
        for (int j = 0; j < arr.length; j++) {
            s = arr[j];
            String e = s.chars().mapToObj(Character::toLowerCase).distinct().sorted()
                    .reduce("", (a, c) -> a + Character.toString(c), String::concat);
            System.out.println(e);
            map.merge(e, 1, Integer::sum);
            if (map.size() > 1 && map.values().stream().reduce(Integer::sum).get() > 2) {
                String[] keys = (String[]) map.keySet().toArray();
                return map.get(keys[0]) < map.get(keys[1]) ? keys[0] : keys[1];
            }
        }
        StringBuilder sb = new StringBuilder();
        return s;
    }
}
