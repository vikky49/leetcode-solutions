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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int[] diameter = new int[1];
        dfs(root,diameter);
        return diameter[0];
    
    }
    
    private int dfs(TreeNode node, int[] result) {
        
        //Bottom up recursion
        //Base case 
        if(node.left == null && node.right == null) {
            return 0;
        }
        
        //Recursive case
        
        int height = 0;
        int diameter = 0;
        
        if (node.left != null) {
            int leftHeight = dfs(node.left,result);
            diameter += 1 + leftHeight;
            height = Math.max(height, 1+leftHeight);
        }
        
        if (node.right != null) {
            int rightHeight = dfs(node.right, result);
            diameter += 1 + rightHeight;
            height = Math.max(height, 1+rightHeight);
        }
        
        result[0] = Math.max(result[0],diameter);
        
        return height;
                
    }
}
