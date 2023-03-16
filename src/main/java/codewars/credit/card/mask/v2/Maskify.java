package codewars.credit.card.mask.v2;

public class Maskify {
    public static String maskify(String str) {
        if (str.length() < 4) return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 4; i++) sb.append("#");
        return sb.append(str.substring(str.length() - 4)).toString();
    }
}