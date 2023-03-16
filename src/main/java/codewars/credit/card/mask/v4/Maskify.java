package codewars.credit.card.mask.v4;

public class Maskify {
    public static String maskify(String str) {
        int len = str.length();
        if (len <= 4) return str;
        return "#".repeat(len - 4) + str.substring(len - 4, len);
    }
}