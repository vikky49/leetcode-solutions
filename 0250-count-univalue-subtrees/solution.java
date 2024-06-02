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

     private int uniValueCount = 0;

    public int countUnivalSubtrees(TreeNode root) {
     
        //Edge case 
        if (root == null) {
            return 0;
        }

        dfs(root);
        return uniValueCount;

    }

    private boolean dfs(TreeNode node) {

        //Base case - if the node is leaf
        // if the node is leaf its Univalued
        if(node.left == null && node.right == null) {
            uniValueCount ++;
            return true; 
        }

        //Recursive case 
         
        boolean isUniValue = true;

        if(node.left != null) {
            boolean leftUnivalue = dfs(node.left);
            if(!leftUnivalue || node.val != node.left.val) {
                isUniValue = false;
            }
        }

        if(node.right != null) {
            boolean rightUnivalue = dfs(node.right);
                if(!rightUnivalue || node.val != node.right.val) {
                    isUniValue = false;
                }
            }
        
        if(isUniValue) {
          uniValueCount ++;
        }

        return isUniValue;
    }
}
