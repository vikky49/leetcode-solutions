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
        int[] diameter = new int[] {0} ;
        height(root, diameter);
        return diameter[0];
        
    }

    int height(TreeNode node, int[] diameter) {

        //Base case 
        if(node == null) {
            return 0;
        }

        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);

        int localDia = leftHeight + rightHeight;

        if(localDia > diameter[0] ) {
            diameter[0] = localDia;
        }

        return 1 + Math.max(leftHeight, rightHeight);

    }
}
