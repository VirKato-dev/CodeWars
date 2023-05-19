package codewars.credit.card.mask.v3;

public class Maskify {
    public static String maskify(final String sensetiveData) {
        String regex = "(.*?)(.{1,4})$";
        String secret = sensetiveData.replaceAll(regex, "$1");
        String allowed = sensetiveData.replaceAll(regex, "$2");
        return secret.replaceAll(".", "#") + allowed;
    }
}