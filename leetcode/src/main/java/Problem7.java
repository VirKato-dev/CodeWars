/**
 * Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class Problem7 {
    public static void main(String[] args) {
        int res;
        assert (res = reverse(123)) == 321 : "123 = " + res;
        assert (res = reverse(-123)) == -321 : "-123 = " + res;
        assert (res = reverse(120)) == 21 : "120 = " + res;
        assert (res = reverse(1534236469)) == 0 : "1534236469 = " + res;
    }


    public static int reverse(int x) {
//        int sign = x < 0 ? -1 : 1;
//        x *= sign; // now positive

        long res = 0;
        while (x != 0) { // variable 'sign' required when uses 'x > 0'
            res *= 10; // exclude tail zero
            res += x % 10;
            x /= 10;
        }
//        res *= sign;

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) res = 0;

        return (int)res;
    }
}
