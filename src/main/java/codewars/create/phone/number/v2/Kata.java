package codewars.create.phone.number.v2;

public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        String mask = "(xxx) xxx-xxxx";
        for (int i : numbers) mask = mask.replaceFirst("x", "" + i);
        return mask;
    }
}