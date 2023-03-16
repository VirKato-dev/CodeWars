package codewars.count.the.smiley.faces.v3;

import java.util.List;
import java.util.regex.Pattern;

public class SmileFaces {
    public static int countSmileys(List<String> arr) {
        return arr.stream().mapToInt( w -> w.matches("[:;][-~]?[)D]") ? 1 : 0 ).sum();
    }
}