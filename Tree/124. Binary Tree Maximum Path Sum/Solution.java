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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSumUtil(root);
        return max;
    }
    
    public int pathSumUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, pathSumUtil(root.left));
        int right = Math.max(0, pathSumUtil(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}