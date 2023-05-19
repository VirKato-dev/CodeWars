package codewars.create.phone.number.v4;

import java.util.Arrays;

public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        String phone = Arrays.toString(numbers).replaceAll("[\\[\\]\\s,]", "");
        return "(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6, 10);
    }
}