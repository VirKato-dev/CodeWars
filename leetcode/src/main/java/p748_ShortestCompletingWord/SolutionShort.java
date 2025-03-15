package p748_ShortestCompletingWord;

public class SolutionShort {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.replaceAll("[0-9 ]", "").toLowerCase();

        String shortest = null;

        for (String word : words) {
            String plateCopy = licensePlate;

            if (shortest != null && word.length() >= shortest.length()) continue;

            for (int i = 0; i < word.length(); i++) {
                plateCopy = plateCopy.replaceFirst(String.valueOf(word.charAt(i)), "");
            }

            if (plateCopy.isEmpty()) shortest = word;
        }

        return shortest;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionShort().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(new SolutionShort().shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
