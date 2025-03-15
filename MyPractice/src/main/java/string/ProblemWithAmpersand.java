package string;

import java.nio.charset.StandardCharsets;

public class ProblemWithAmpersand {
    public static void main(String[] args) {
        byte[] text = "lk.justlan.ru/sbpPay?acc=297808%26sum=700".getBytes();
        String newText = new String(text, StandardCharsets.UTF_8);
        System.out.println(newText);
    }
}
