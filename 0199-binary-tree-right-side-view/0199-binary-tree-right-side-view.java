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
    int level;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        rightview(root,ll,0);
        return ll;
    }
    public void rightview(TreeNode root,List<Integer> ll,int level){
        if(root==null) return;
        if(level>=ll.size()){
            ll.add(root.val);
        }
        rightview(root.right,ll,level+1);
        rightview(root.left,ll,level+1);
    }
}