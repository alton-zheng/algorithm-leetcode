package java00863.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/28 8:37 上午
 * @Description: 863. All Nodes Distance K in Binary Tree #247
 * <p>
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * Example 2:
 * <p>
 * Input: root = [1], target = 1, k = 3
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 * <p>
 * Time Complexity: O()
 * Space Complexity: O()
 */

import apple.laf.JRSUIUtils;
import java00000.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    String[] help = new String[501];
    String compare = "";
    int tValue;
    int k;

    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {

        List<Integer> res = new ArrayList<>();
        tValue = t.val;
        this.k = k;

        // k 等于 0， 只有本身符合条件
        if (k == 0)  {
            res.add(t.val);
            return res;
        }

        // 树节点范围 [0,500] 不在此范围的 k 没有任何意义。直接返回 res
        if (k > 500) {
            // 空  list
            return res;
        }

        dfs(root, "1");

        for (int i = 0; i < 501; i++) {
            if (help[i] != null && getDistance(compare, help[i]) == k) {
                res.add(i);
            }
        }

        return res;
    }

    private int getDistance(String compare, String flag) {
        int equalValue = 0;
        int compareLen = compare.length(), flagLen = flag.length();
        char[] compareChar = compare.toCharArray(), flagChar = flag.toCharArray();
        if (Math.abs(compareLen - flagLen) > k) {
            return -1;
        }
        for (int i = 0; i < Math.min(compareLen, flagLen); i++) {
            if (compareChar[i] == flagChar[i]) {
                equalValue++;
            } else {
                break;
            }
        }

        return compareLen + flagLen - 2 * equalValue;

    }

    private void dfs(TreeNode node, String par) {

        if (node == null) {
            return;
        }

        help[node.val] = par;
        if (node.val == tValue) {
            compare = par;
        }

        dfs(node.left, par + "0");
        dfs(node.right, par + "1");
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().distanceK(new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(2, new TreeNode(7), new TreeNode(4)))
                        , new TreeNode(1, new TreeNode(0), new TreeNode(8))),
                        new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2, new TreeNode(7), new TreeNode(4))), 2));
    }
}
