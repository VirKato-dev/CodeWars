package codewars.credit.card.mask.v1;

public class Maskify {
    public static String maskify(String str) {
        return str.replaceAll(".(?=.{4})", "#");
    }
}