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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> t1=new ArrayList<>();
        ArrayList<TreeNode> t2=new ArrayList<>();
        getPath(root,p.val,t1);
        getPath(root,q.val,t2);
        TreeNode lca =null;
        int i=0;
      while(i<t1.size() && i< t2.size() && t1.get(i)==t2.get(i)){
        lca=t1.get(i);
        i++;
      }
      return lca;
    }
    private boolean getPath(TreeNode root,int x,ArrayList<TreeNode> arr){
        if(root==null) return false;
        arr.add(root);
        if(root.val==x) return true;
        if(getPath(root.left,x,arr) || getPath(root.right,x,arr)){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;


    }
}