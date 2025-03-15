package a.string.decode;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ToUtf8 {

    private static final String text = "Ð³. Ð Ð¾Ñ ÐºÐ²Ð°";

    public static void main(String[] args) {
        System.out.println("Original: '" + text + "'");
        System.out.println(new String(text.getBytes(Charset.forName("windows-1252")), StandardCharsets.UTF_8));
        System.out.println(new String("г. Москва".getBytes(StandardCharsets.UTF_8), Charset.forName("windows-1252")));
        System.out.println(new String("г. Москва".getBytes(), Charset.forName("windows-1252")));
    }
}