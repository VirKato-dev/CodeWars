import java.util.Arrays;

public class Problem66PlusOne {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.plusOne(new int[]{1, 9, 9})));
    }


    static class Solution {
        public int[] plusOne(int[] digits) {
            int j = digits.length - 1;
            int carry = 1;
            while (carry > 0) {
                if (j < 0) {
                    j++;
                    int[] d = new int[digits.length + 1];
                    System.arraycopy(digits, 0, d, 1, digits.length);
                    digits = d;
                }
                int tmp = digits[j] + carry;
                digits[j--] = tmp % 10;
                carry = tmp / 10;
            }
            return digits;
        }
    }


    static class SolutionLowMemory {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i]++;
                    break;
                } else {
                    digits[i] = 0;
                }
            }
            if (digits[0] == 0) {
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                return res;
            }
            return digits;
        }
    }
}
