package java01743.m01;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 2021/7/25 上午8:43
 * @Description:
 * 1743. Restore the Array From Adjacent Pairs
 *
 * 1743. Restore the Array From Adjacent Pairs #238
 *
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 *
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 *
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 * Return the original array nums. If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 *
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 *
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 *
 *
 * Constraints:
 *
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 10^5
 * -10^5 <= nums[i], ui, vi <= 10^5
 * There exists some nums that has adjacentPairs as its pairs.
 *
 * Time Complexity: O()
 * Space Complexity: O()
 *
 */
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {

        Map<Integer, List<Integer>> help = new HashMap<>();

        for (int[] adjacentPair  : adjacentPairs) {
            List<Integer> list1 = help.getOrDefault(adjacentPair[0], new ArrayList<>());
            list1.add(adjacentPair[1]);
            help.put(adjacentPair[0], list1);

            List<Integer> list2 = help.getOrDefault(adjacentPair[1], new ArrayList<>());
            list2.add(adjacentPair[0]);
            help.put(adjacentPair[1], list2);
        }

        int len = adjacentPairs.length + 1;
        int[] res = new int[len];
        for (Map.Entry<Integer, List<Integer>> item : help.entrySet()) {
            if (item.getValue().size() == 1) {
                res[0] = item.getKey();
                res[1] = item.getValue().get(0);
            }
        }

        for (int i = 2; i < len; i++) {
            List<Integer> cur = help.get(res[i - 1]);
            res[i] = res[i - 2] == cur.get(0) ? cur.get(1) : cur.get(0);
        }

        return res;
    }
}
