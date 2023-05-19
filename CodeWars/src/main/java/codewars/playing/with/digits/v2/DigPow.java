package codewars.playing.with.digits.v2;

public class DigPow {
    public static long digPow(int n, int p) {
        int sum = 0, digit[] = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
        for (int a : digit) sum += Math.pow(a, p++);
        return sum % n == 0 ? sum / n : -1;
    }
}