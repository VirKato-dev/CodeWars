package text;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAndReplace {
    public static void main(String[] args) {
        String text = "G1 X75.670 Y75.670 E1.6184 F2400 \n" +
                "G1 X124.330 Y75.670 E3.2369 \n" +
                "G1 X124.330 Y124.330 E4.8553 \n" +
                "G1 X75.670 Y124.330 E6.4738\n" +
                "G28 X0 Y0";
        incValueBy(text, 0);
    }

    private static void incValueBy(String input, double inc) {
        Pattern ptrn = Pattern.compile("\\w\\d+\\.*\\d*\\s*");
        Matcher matcher = ptrn.matcher(input);
        matcher.results().forEach(m-> System.out.println(m.group()));
    }
}
