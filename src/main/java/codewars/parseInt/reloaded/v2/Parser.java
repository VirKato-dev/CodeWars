package codewars.parseInt.reloaded.v2;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Parser {

    public static void main(String[] args) {
        System.out.println(parseInt("one"));
        System.out.println(parseInt("twenty"));
        System.out.println(parseInt("two hundred forty-six"));
        System.out.println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
    }

    final static private String[] SPLITTER = Stream.of("million", "thousand", "hundred", "ty\\b")
            .map(r -> String.format("\\s*%s\\s*", r))
            .toArray(String[]::new);

    final static private int[] COEFS = {1000000, 1000, 100, 10};
    final static private String[] vals = "zero one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen".split(" ");
    final static private Map<String, Integer> VALUES = defineStaticValues();


    private static Map<String, Integer> defineStaticValues() {
        Map<String, Integer> map = IntStream.range(0, vals.length)
                .boxed()
                .collect(Collectors.toMap(i -> vals[i], i -> i));
        map.put("twen", 2);
        map.put("thir", 3);
        map.put("for", 4);
        map.put("fif", 5);
        map.put("eigh", 8);
        return map;
    }


    public static int parseInt(String s) {
        return parse(0, s.replaceAll("(\\s|-|\\band)+", " "));
    }


    private static int parse(int i, String s) {
        if (i == SPLITTER.length) return VALUES.getOrDefault(s, 0);
        String[] arr = s.split(SPLITTER[i], -1);
        return arr.length == 1
                ? parse(i + 1, arr[0])
                : COEFS[i] * parse(i + 1, arr[0]) + parse(i + 1, arr[1]);
    }

}