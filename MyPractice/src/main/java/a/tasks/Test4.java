package a.tasks;

import java.util.Arrays;
import java.util.StringJoiner;

public class Test4 {
    public static void main(String[] args) {

    }

    private static String join(String[] args) {
        String result = "";
        for (String arg : args) {
            result += arg;
            result += ", ";
        }
        return result;
    }


    private static String joinCorrect(String... args) {
        StringJoiner sj = new StringJoiner(",");
        Arrays.stream(args).forEach(sj::add);
        return sj.toString();
    }
}
