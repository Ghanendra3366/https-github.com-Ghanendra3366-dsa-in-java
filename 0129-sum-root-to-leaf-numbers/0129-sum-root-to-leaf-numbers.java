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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        makeNumber(root,0);
        return sum;
    }

    public void makeNumber(TreeNode root,int num){
        if(root == null)return ;

        num = num * 10 + root.val;
        if(root.left == null && root.right == null){
            sum += num;
        }
        makeNumber(root.left,num);
        makeNumber(root.right,num);
    }
}