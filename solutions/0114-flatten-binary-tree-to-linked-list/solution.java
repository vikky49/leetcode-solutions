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
     
    private TreeNode flattenTree(TreeNode node) {

        //Handle the base case 
        if(node == null) {
            return null;
        }

        //Base case 
        //If its the leaf node 

        if(node.left == null && node.right == null) {
            //return this node as its the last tail node 
            return node;
        }

        //Recursive condition 

        //Recursively flatten the left tree
        TreeNode leftTail = flattenTree(node.left);

        //Recursively flatten the right tree
        TreeNode rightTail = flattenTree(node.right);

        //if there is the left subtree , we can shuffle the connections
        // in a way that the 
        // leftNode right is the node.right
        // and node right is the current leftTail 
        // and then make the lefttail null

        if(leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail == null ? leftTail : rightTail;

    } 

    public void flatten(TreeNode root) {
         this.flattenTree(root);

    }
}
