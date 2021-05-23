package java00373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: alton
 * @Date: Created in 5/23/21 10:28 AM
 * @Description:
 * 373. Find K Pairs with Smallest Sums #34
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [[1,3],[2,3]]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 104
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 and nums2 both are sorted in ascending order.
 * 1 <= k <= 1000h
 *
 * Time Complexity: O(n*m*logm*n)
 * Space Complexity: O(logm*n)
 * 优先队列, 性能堪忧， 时间和空间复杂度更低
 */
class Solution4 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2) ->
                o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1));

        int n = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> help = new ArrayList<>();
                help.add(nums1[i]);
                help.add(nums2[j]);
                queue.add(help);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        res.addAll(queue);

        return res;

    }

}