package tasks;

public class StringCompressor {

    public static void main(String[] args) {
            System.out.println(compressString("aaabbcaa") + " == a3b2ca2");
        }


    private static String compressString(String text) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        String last = String.valueOf(text.charAt(0));

        for (String s : text.split("")) {
            if (!s.equals(last)) {
                add(result, last, count);
                count = 1;
                last = s;
            } else {
                count++;
            }
        }
        add(result, last, count);

        return result.toString();
    }

    private static void add(StringBuilder sb, String s, int c) {
        sb.append(s);
        if (c > 1) {
            sb.append(c);
        }
    }
}
