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
    int res;
    public int maxPathSum(TreeNode root) {
        res=root.val;
        solve(root);
        return res;
    }
    private int solve(TreeNode root){
       if(root==null) return 0;
        int left=Math.max(0,solve(root.left));
    int right=Math.max(0,solve(root.right));

    int curr=root.val+left+right;
    res=Math.max(res,curr);
        return root.val+Math.max(left,right);
    }
}