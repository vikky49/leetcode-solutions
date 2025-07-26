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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
        
    }

    private int dfs(
        TreeNode node
    ) {
       
        //we need to traverse postOrder traversal 
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(0,dfs(node.left));

        int rightMax = Math.max(0, dfs(node.right));

        // Current node as root of a path: node + left path + right path
        int currentMax = leftMax + rightMax + node.val;

        maxSum = Math.max(currentMax, maxSum);

          // Return maximum path sum that can be extended upward
        // (can only choose one direction: left OR right, not both)
        return node.val + Math.max(leftMax, rightMax);

    }
}
