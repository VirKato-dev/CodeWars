package codewars.catching.car.mileage.numbers.v0;

public class CarMileage {

    public static void main(String[] args) {

        int a1 = CarMileage.isInteresting(98, new int[]{});  // 1
        // "boring" numbers
        int a = CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
        int b = CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

        // progress as we near an "interesting" number
        int c = CarMileage.isInteresting(11207, new int[]{}); // 0
        int d = CarMileage.isInteresting(11208, new int[]{}); // 0
        int e = CarMileage.isInteresting(11209, new int[]{}); // 1
        int f = CarMileage.isInteresting(11210, new int[]{}); // 1
        int g = CarMileage.isInteresting(11211, new int[]{}); // 2

        // sequential (decrementing,incrementing,same)
        int h = CarMileage.isInteresting(12343, new int[]{}); // 1
        int i = CarMileage.isInteresting(12344, new int[]{}); // 1
        int j = CarMileage.isInteresting(12345, new int[]{}); // 2
        int k = CarMileage.isInteresting(11111, new int[]{}); // 2
        int l = CarMileage.isInteresting(54321, new int[]{}); // 2

        // followed by all zeros
        int m = CarMileage.isInteresting(100, new int[]{}); // 2
        int n = CarMileage.isInteresting(1998, new int[]{}); // 1
        int o = CarMileage.isInteresting(5000, new int[]{}); // 2

        // nearing a provided "awesome phrase"
        int p = CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
        int q = CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
        int r = CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2
    }


    private static int answer = 0;

    private static void setAnswer(int a) {
        if (answer < a) answer = a;
    }

    private static boolean isPalindrome(int num) {
        String s = Long.toString(num);
        for (int i = 0; i < s.length() / 2; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }

    private static boolean isSequential(int num) {
        return isSeq(num, "1234567890") || isSeq(num, "0123456789");
    }

    private static boolean isSeq(int num, String seq) {
        String s = Long.toString(num);
        int dir = 0;
        int last = seq.indexOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = seq.indexOf(s.charAt(i));
            if (i < 2) {
                dir = cur - last;
            } else if (dir != cur - last) return false;
            last = cur;
        }
        return Math.abs(dir) < 2;
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
        // in awesome phrases
        for (int n : awesomePhrases) {
            int res = Math.abs(n - number);
            if (res <= 2) setAnswer(1);
            if (res == 0) setAnswer(2);
        }
        // is interesting
        for (int i = 0; i < 3; i++) {
            if (number + i > 99 &&
                    (isSequential(number + i) || isPalindrome(number + i) || isZeros(number + i)))
                setAnswer(2 - (i > 0 ? 1 : 0));
        }
        return answer;
    }
}