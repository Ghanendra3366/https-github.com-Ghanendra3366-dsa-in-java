/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int minDifference = Integer.MAX_VALUE;
    private Integer prevValue = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDifference;
    }
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (prevValue != null) {
            minDifference = Math.min(minDifference, node.val - prevValue);
        }
        prevValue = node.val;
        inOrder(node.right);
    }
}
