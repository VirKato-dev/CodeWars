package a.kata;

public class GmailOutlook {

    public static void main(String[] args) {
        System.out.println(isGmailOrOutlook("a1.bc@gmail.com")); // t
        System.out.println(isGmailOrOutlook("ab1@outlook.com")); // t
        System.out.println(isGmailOrOutlook("1a@outlook.com")); // f
        System.out.println(isGmailOrOutlook("a..b1@outlook.com")); // f
        System.out.println(isGmailOrOutlook("a.@outlook.com")); // f
        System.out.println(isGmailOrOutlook("a.b.@gmail.com")); // f
        System.out.println(isGmailOrOutlook(".a.b@gmail.com")); // f
    }

    private static boolean isGmailOrOutlook(String email) {
        return email.matches("([a-zA-Z]\\w*)(\\.?[a-zA-Z]+\\w*)*@((gmail)|(outlook))\\.com");
    }
}
