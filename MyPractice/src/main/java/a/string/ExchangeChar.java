package a.string;

public class ExchangeChar {
    public static void main(String[] args) {
        String text = "ACGT";
        System.out.println(text);
        System.out.println(exchange(text));
    }

    private static String exchange(String text) {
        StringBuilder sb = new StringBuilder();
        text.chars().forEach(c -> sb.append(
                c == 'A' ? 'C'
                        : c == 'C' ? 'A'
                        : c == 'G' ? 'T'
                        : c == 'T' ? 'G'
                        : ""));
        return sb.toString();
    }
}
