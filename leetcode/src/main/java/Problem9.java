/**
 * Palindrome Number
 * Given an integer x, return true if x is a <b>palindrome</b>, and false otherwise.<br>
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class Problem9 {
    public static void main(String[] args) {
        boolean res;
        assert res = isPalindrome(121) : "121 = " + res;
        assert res = !isPalindrome(-121) : "-121 = " + res;
        assert res = !isPalindrome(10) : "10 = " + res;
        assert res = isPalindrome(313) : "313 = " + res;
        assert res = !isPalindrome(1000021) : "1000021 = " + res;
    }


    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int size = (int) Math.log10(x) + 1;
        int step = 0;

        while (step < size / 2) {
            int right = (x % ((int) Math.pow(10, step + 1))) / (int) Math.pow(10, step);
            int left = x  / (int) Math.pow(10, size - step - 1) % 10;

            if (left != right) return false;
            step++;
        }
        return true;
    }


    public boolean isPalindrome2(int x) {
        if (x < 0) return false;

        int y = x;
        int z = 0;
        while (y > 0) { // reverse into z
            z *= 10;
            z += y % 10;
            y /= 10;
        }

        return x == z;
    }
}

