package java00494;

/**
 * @Author: alton
 * @Date: Created in 6/7/21 10:40 AM
 * @Description:
 *
 * 494. Target Sum #83
 *
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 *
 * Time Complexity: O(n * (sum - target))
 * Space Complexity: O(n * negative);
 *
 * Runtime: 4 ms, faster than 91.01% of Java online submissions for Target Sum.
 * Memory Usage: 38.4 MB, less than 54.57% of Java online submissions for Target Sum.
 *
 * backtracking
 *
 */
class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int len = nums.length;
        int negative = diff / 2;
        int[] help = new int[negative + 1];
        help[0] = 1;

        for (int num: nums) {
            for (int j = negative; j >= num; j--) {
                help[j] += help[j - num];
            }
        }

        return help[negative];
    }
}
