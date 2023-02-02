package com.codewars.catching.car.mileage.numbers.v0;

public class CarMileage {

    public static void main(String[] args) {
        // "boring" numbers
        CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
        CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

        // progress as we near an "interesting" number
        CarMileage.isInteresting(11207, new int[]{}); // 0
        CarMileage.isInteresting(11208, new int[]{}); // 0
        CarMileage.isInteresting(11209, new int[]{}); // 1
        CarMileage.isInteresting(11210, new int[]{}); // 1
        CarMileage.isInteresting(11211, new int[]{}); // 2

        // sequential (decrementing,incrementing,same)
        CarMileage.isInteresting(12343, new int[]{}); // 1
        CarMileage.isInteresting(12344, new int[]{}); // 1
        CarMileage.isInteresting(12345, new int[]{}); // 2
        CarMileage.isInteresting(11111, new int[]{}); // 2
        CarMileage.isInteresting(54321, new int[]{}); // 2

        // followed by all zeros
        CarMileage.isInteresting(100, new int[]{}); // 2
        CarMileage.isInteresting(1998, new int[]{}); // 1
        CarMileage.isInteresting(5000, new int[]{}); // 2

        // nearing a provided "awesome phrase"
        CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
        CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
        CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2
    }


    private static int answer = 0;

    private static void setAnswer(int a) {
        if (answer < a) answer = a;
    }

    private static boolean isPalindrome(int num) {
        String s = Integer.toString(num);
        for (int i = 0; i < s.length() / 2; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }

    private static int isSequential(int num) {
        String s = Integer.toString(num);
        String seq = "1234567890";
        int dir = 0;
        int last = seq.indexOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = seq.indexOf(s.charAt(i));
            if (i < 2) {
                dir = cur - last;
                if (dir < 0) {

                }
            } else if (dir != cur - last) return Integer.MIN_VALUE;
            last = cur;
        }
        return dir;
    }

    private static boolean isZeros(int num) {
        while (num > 9) {
            if (num % 10 > 0) return false;
            num /= 10;
        }
        return true;
    }

    public static int isInteresting(int number, int[] awesomePhrases) {
        answer = 0;
        if (number < 100) return 0;
        // in awesome phrases
        for (int n : awesomePhrases) {
            int res = Math.abs(n - number);
            if (res <= 2) setAnswer(1);
            if (res == 0) setAnswer(2);
        }
        // is interesting
        for (int i = 0; i < 3; i++) {
            int a = isSequential(number + i);
            if (Math.abs(a) < 2) setAnswer(2 - (i > 0 ? 1 : 0));
            if (isPalindrome(number + i)) setAnswer(2 - (i > 0 ? 1 : 0));
            if (isZeros(number + i)) setAnswer(2 - (i > 0 ? 1 : 0));
        }
        return answer;
    }
}