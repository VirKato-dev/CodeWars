public class Problem1271HexSpeak {
    public static void main(String[] args) {
        check(257);
        check(3);
        check("257"); // IOI
        check("99");
        check("10539198"); // ADOBE
        check("327982"); // SOIZE
    }

    private static void check(long num) {
        String str = Long.toHexString(num);
        str = str.replaceAll("1", "I");
        str = str.replaceAll("0", "O");
        if (str.replaceAll("[A-FIO]", "").length() > 0) {
            System.out.println("ERROR");
        } else {
            System.out.println(str);
        }
    }

    private static void check(String num) {
        long input = Long.parseLong(num);
        StringBuilder sb = new StringBuilder();
//        String hex = "OI23456789ABCDEF";
        String hex = "OIZ**S****ABCDEF";
        while (input > 0) {
            int a = (int) (input & 0xf);
            char c = hex.charAt(a);
            if (c == '*') {
                sb = new StringBuilder("ERROR");
                break;
            }
            input >>= 4;
            sb.insert(0, c);
        }
        System.out.println(sb);
    }
}
