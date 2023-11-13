package tasks;

import java.util.*;

public class RemoveAnagramsFromList {
    public static void main(String[] args) {
        List<String> anagrams = List.of("Race", "NIghT", "Angle", "CaRe", "angel", "ThiNG");
        System.out.println(removeAnagrams(anagrams));  // [Race, NIghT, Angle]
        System.out.println(removeAnagrams2(anagrams)); // [CaRe, angel, ThiNG]
    }

    public static List<String> removeAnagrams(List<String> anagrams) {
        Set<String> set = new LinkedHashSet<>();
        List<String> result = new LinkedList<>();
        for (String s : anagrams) {
            if (set.add(Arrays.toString(s.toLowerCase().chars().sorted().toArray()))) {
                result.add(s);
            }
        }
        return result;
    }

    public static List<String> removeAnagrams2(List<String> anagrams) {
        Map<String, String> anagramMap = new HashMap<>();
        for (String word : anagrams) {
            char[] chars = word.toLowerCase().toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            anagramMap.put(sortedWord, word);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
