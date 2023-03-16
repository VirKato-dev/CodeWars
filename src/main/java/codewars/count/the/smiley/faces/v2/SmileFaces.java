package codewars.count.the.smiley.faces.v2;

import java.util.List;
import java.util.regex.Pattern;

public class SmileFaces {
    public static int countSmileys(List<String> arr) {
        Pattern smilieyPattern = Pattern.compile("[:;][-~]?[)D]");
        return (int) arr.stream().filter(smilieyPattern.asPredicate()).count();
    }
}