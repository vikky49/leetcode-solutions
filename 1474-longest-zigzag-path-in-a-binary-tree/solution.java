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
    private int maxLength = 0;

    public int longestZigZag(TreeNode root) {

        if(root == null) {
            return 0;
        }

        dfs(root, 'L', 0); // Start with left direction, length 0
        dfs(root, 'R' ,0); // Start with right direction, length 0

        return maxLength;

    }

    private void dfs(
        TreeNode node,
        char direction,
        int length
    ) {

        if(node == null) {
            return;
        }

        maxLength = Math.max(maxLength, length);

         // Continue zigzag pattern
        if (direction == 'L') {
            // Last move was left, next should be right
            dfs(node.right, 'R', length + 1);
            dfs(node.left, 'L', 1); // Reset zigzag
        } else {
            // Last move was right, next should be left
            dfs(node.left, 'L', length + 1);
            dfs(node.right, 'R', 1); // Reset zigzag
        }


    }
}
