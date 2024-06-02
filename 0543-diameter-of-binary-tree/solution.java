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
   
   private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
    
        //Edge case
        if(root == null) {
            return 0;
        }
        dfs(root);
        return diameter;
        
    }

    private int dfs(
        TreeNode node) {

            //Base case 
            // if the node is the leaf
            if(node.left == null && node.right == null) {
                return 0;
            }

            //Recursive case 
            
            int height = 0;
            int longestPath = 0;

            if(node.left != null) {
                int leftHeight = 1 + dfs(node.left);
                height = Math.max(height,leftHeight);
                longestPath = leftHeight;
            }

            if(node.right != null) {
              int rightHeight = 1 + dfs(node.right);
              height = Math.max(height,rightHeight);
              longestPath += rightHeight;
            }

            if(longestPath > diameter) {
                diameter = longestPath;
            }

            return height;

        }
}
