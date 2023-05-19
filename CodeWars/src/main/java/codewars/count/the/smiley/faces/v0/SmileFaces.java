package codewars.count.the.smiley.faces.v0;

import java.util.List;

public class SmileFaces {

    public static void main(String[] args) {
        System.out.println(countSmileys(List.of(":)", ";(", ";}", ":-D")));
        System.out.println(countSmileys(List.of(";D", ":-(", ":-)", ";~)")));
    }

    public static int countSmileys(List<String> arr) {
        int count = 0;
        for (String s : arr) if (s.replaceAll("[:;][-~]?[)D]", "").equals("")) count++;
        return count;
    }
}