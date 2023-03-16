package codewars.playing.with.digits.v0;

public class DigPow {
    public static long digPow(int n, int p) {
        char[] dig = String.valueOf(n).toCharArray();
        long res = 0;
        for (char c : dig) res += Math.pow(Integer.parseInt(String.valueOf(c)), p++);
        return res % n == 0 ? res / n : -1;
    }
}