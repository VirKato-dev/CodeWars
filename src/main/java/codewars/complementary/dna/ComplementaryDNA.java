package codewars.complementary.dna;

import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ComplementaryDNA {
    public static void main(String[] args) {
        System.out.println(DnaStrand.makeComplement("AAAA"));
    }

    public static class DnaStrand {
        public static String makeComplement(String dna) {
            StringBuilder sb = new StringBuilder();
            return dna.chars()
                    .mapToObj(c -> switch (c) {
                        case 'A' -> "T";
                        case 'T' -> "A";
                        case 'C' -> "G";
                        case 'G' -> "C";
                        default -> "";
                    })
                    .collect(Collectors.joining());
        }
    }
}
