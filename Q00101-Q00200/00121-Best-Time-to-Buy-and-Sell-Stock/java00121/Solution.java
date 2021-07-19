package java00121;

/**
 * @Author: alton
 * @Date: Created in 7/16/21 2:28 PM
 * @Description:
 * 121. Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 *
 *Runtime: 2 ms, faster than 66.52% of Java online submissions for Best Time to Buy and Sell Stock.
 * Memory Usage: 52.2 MB, less than 51.97% of Java online submissions for Best Time to Buy and Sell Stock.
 */
class Solution {
    public int maxProfit(int[] prices) {

        int res = 0;
        int low = prices[0], high = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
                high = prices[i];
            }

            if (prices[i] > high) {
                high = prices[i];
            }

            res = Math.max(res, high - low);
        }

        return res;
    }
}