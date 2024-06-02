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
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) {
            return null;
        }

        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {

        TreeNode oldLeft = node.left;
        TreeNode oldRight = node.right;

        node.left = oldRight;
        node.right = oldLeft;

        //BaseCase 
        if(node.left == null && node.right == null) {
            
        }

        //Recursive Case
        
        if (node.left != null) {
             dfs(node.left);
        }

        if(node.right != null) {
            dfs(node.right);
        }

    }
}
