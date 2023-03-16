package codewars.camelcase.method;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CamelCaseMethod {
    public static void main(String[] args) {
        System.out.println(Solution.camelCase("hello   case"));
        System.out.println(Solution.camelCase("camel case word"));
    }
}

class Solution {

    public static String camelCase(String str) {
        return Arrays.stream(str.split(" "))
                .filter(s->!s.isEmpty())
                .map(s->Character.toString(s.charAt(0)).toUpperCase().concat(s.substring(1)))
                .collect(Collectors.joining());
    }

}
