/**
 * String to Integer (atoi)
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
 * (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'.
 * Read this character in if it is either. This determines if the final result is negative or positive respectively.
 * Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached.
 * The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
 * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 * then clamp the integer so that it remains in the range. Specifically, integers less than -231
 * should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class Problem8 {
    public static void main(String[] args) {
        int res;
        assert (res = myAtoi("42")) == 42 : "'42' = " + res;
        assert (res = myAtoi("  -42")) == -42 : "'  -42' = " + res;
        assert (res = myAtoi("4193 with words")) == 4193 : "'4193 with words' = " + res;
        assert (res = myAtoi("+1")) == 1 : "'+1' = " + res;
        assert (res = myAtoi("+-12")) == 0 : "'+-12' = " + res;
        assert (res = myAtoi("9223372036854775808")) == 2147483647 : "'9223372036854775808' = " + res;
        assert (res = myAtoi("-91283472332")) == -2147483648 : "'-91283472332' = " + res;
    }


    public static int myAtoi(String s) {
        long res = 0;
        StringBuilder sb = new StringBuilder(s);
        String DIGITS = "0123456789";
        String ACTIONS = "+-";
        String IGNORE = " ";

        int sign = 1;
        int num;
        boolean isNumber = false;

        while (sb.length() > 0) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);

            if ((num = DIGITS.indexOf(c)) >= 0) {
                res *= 10;
                res += num;
                isNumber = true;
            } else if (ACTIONS.indexOf(c) >= 0 && !isNumber) {
                isNumber = true;
                if (c == '-') sign = -1;
            } else if (num < 0 && isNumber) {
                break;
            } else if (IGNORE.indexOf(c) >= 0 && !isNumber) {
                // norm
            } else {
                res = 0;
                break;
            }
            if (sign < 0) {
                if (sign * res < Integer.MIN_VALUE) {
                    res = Integer.MIN_VALUE;
                    sign = 1;
                    break;
                }
            } else if (res > Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
                break;
            }
        }
        res *= sign;

        return (int) res;
    }


    public int myAtoi2(String str) {
        int index = 0, sign = 1, total = 0;
        str = str.trim();
        //1. Empty string
        if (str.length() == 0) return 0;

        //2. Remove Spaces
        while (str.charAt(index) == ' ' && index < str.length())
            index++;

        //3. Handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4. Convert number and avoid overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }
}
