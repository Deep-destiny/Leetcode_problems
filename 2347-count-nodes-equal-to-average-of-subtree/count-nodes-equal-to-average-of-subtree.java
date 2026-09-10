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
    int ans=0;
    public void calculate(TreeNode root) {

        if (root == null) return;

        // 1. Store every node using BFS
        Queue<TreeNode> q = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {

            TreeNode curr = q.poll();
            nodes.add(curr);

            if (curr.left != null)
                q.add(curr.left);

            if (curr.right != null)
                q.add(curr.right);
        }
 Map<TreeNode, Integer> count = new HashMap<>();
        Map<TreeNode, Integer> sum = new HashMap<>();

        // Process children before parents
        int i = nodes.size() - 1;

        while (i >= 0) {

            TreeNode curr = nodes.get(i);

            // Include the current node
            int cnt = 1;
            int s = curr.val;

            // Add left subtree
            if (curr.left != null) {
                cnt += count.get(curr.left);
                s += sum.get(curr.left);
            }

            // Add right subtree
            if (curr.right != null) {
                cnt += count.get(curr.right);
                s += sum.get(curr.right);
            }

            // Store result for current node
            count.put(curr, cnt);
            sum.put(curr, s);

            i--;
        }
       for(TreeNode node:nodes){
        int a=count.get(node);
        int b=sum.get(node);
            if(node.val == b/a){
                ans++;
            }
       }
    }

    public int averageOfSubtree(TreeNode root) {
        calculate(root);
        return ans;
    }
}