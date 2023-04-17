public class Problem2235AddTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sum(12,5));
        System.out.println(solution.sum(-10,4));
    }

    static class Solution {
        public int sum(int num1, int num2) {
            return num1 + num2;
        }
    }
}
