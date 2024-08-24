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

    private int totalTilt = 0;

    public int findTilt(TreeNode root) {

        if(root == null) {
            return 0;
        }

        this.totalTilt = 0;
        this.dfs(root);
        return this.totalTilt;
        
    }

    private int dfs(TreeNode node) {

        //Base case 
         //Leaf node
         if(node.left == null && node.right == null) {
              return node.val;            
         }

         //Recursive case 
         int leftSum = 0;
         int rightSum = 0;

         //left case 

         if(node.left != null) {
            leftSum = dfs(node.left);
         }

         if(node.right != null) {
            rightSum = dfs(node.right);
         }

         int localsum = node.val + leftSum + rightSum;
         int localTilt =  Math.abs(leftSum - rightSum);

         this.totalTilt += localTilt;

         return localsum;


    }
}
