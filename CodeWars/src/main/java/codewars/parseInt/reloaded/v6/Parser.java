package codewars.parseInt.reloaded.v6;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static int parseInt(String numStr) {
        int hundreds = 0, thousands = 0;
        String[] words = numStr.split("[\\s-]");
        String[] numWords = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        int[] numInts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90};

        Map<String, Integer> map = new HashMap<>(27);
        for (int i = 0; i < numInts.length; i++) {
            map.put(numWords[i], numInts[i]);
        }

        for (String word : words) {
            if (word.equals("zero")) {
                return 0;
            } else if (word.equals("million")) {
                return 1000000;
            } else if (word.equals("hundred")) {
                hundreds *= 100;
            } else if (word.equals("thousand")) {
                thousands = hundreds * 1000;    //move to thousands place and reset the hundreds place
                hundreds = 0;
            } else {
                hundreds += map.getOrDefault(word, 0);
            }
        }
        return hundreds + thousands;
    }
}