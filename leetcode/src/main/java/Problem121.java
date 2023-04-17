/**
 * Best Time to Buy and Sell Stock
 */
public class Problem121 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }


    static class Solution {
        public int maxProfit(int[] prices) {
            return -1;
        }
    }


    static class Solution2 {
        public int maxProfit(int[] prices) {

            //In constraints it is given that
            //0 <= prices[i] <= 104
            int min = 10000;

            //Profit will be 0, if no transaction are done.
            int maxDiff = 0;

            int size = prices.length;

            for (int i = 0; i < size; i++){
                //We need to find Min value
                min = Math.min(prices[i], min);
                //We need to find maxProfit which is Difference between
                //currentPrice - min, then compare with maxDiff
                maxDiff = Math.max(prices[i] - min, maxDiff);
            }
            return maxDiff;
        }
    }


    static class Solution3 {
        public int maxProfit(int[] prices) {
            int lsf = Integer.MAX_VALUE;
            int op = 0;
            int pist = 0;

            for(int i = 0; i < prices.length; i++){
                if(prices[i] < lsf){
                    lsf = prices[i];
                }
                pist = prices[i] - lsf;
                if(op < pist){
                    op = pist;
                }
            }
            return op;
        }
    }

    static class Solution4 {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int minPrice = Integer.MAX_VALUE;

            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;
                } else if (price - minPrice > profit) {
                    profit = price - minPrice;
                }
            }
            return profit;
        }
    }
}

