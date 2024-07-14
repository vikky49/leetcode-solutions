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
    public boolean isValidBST(TreeNode root) {

        return validateBST(root,null,null);
        
    }

    private boolean validateBST(
        TreeNode node,
        Integer low,
        Integer high
    ) {

        //Edge case 

        if(node == null) {
            return true;
        }

        //Base case 
        //if the root node is smaller than the left node 
        // and if the root node is greater than the right node
        // its a false case 

        if( (low != null && node.val <= low) || 
            (high != null && node.val >= high)) {
                 return false;
            }

        //RecursiveCase 
        return (validateBST(node.left,low,node.val) 
        && validateBST(node.right,node.val,high));


    }
}
