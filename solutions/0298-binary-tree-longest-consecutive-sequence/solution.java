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
    public int longestConsecutive(TreeNode root) {
        int[] result = new int[1];

        //Edge case 
        if(root == null) {
            return 0;
        }

        dfs(root,root.val,-1,result);

        return result[0];
        
    }

    private void dfs(
        TreeNode node,
        int parentValue,
        int lengthSoFar,
        int[] result
    ) {

        // we need to know the parent value to check to make sure we have the longest path

        if(node.val == parentValue + 1) {
            lengthSoFar = lengthSoFar + 1;
        }else {
            lengthSoFar = 1;
        }

        //update the global max 
        if(lengthSoFar > result[0]) {
            result[0] = lengthSoFar;
        }

        //Base case 

        if(node.left == null && node.right == null) {
            //Do nothing
            ;
        }

        //Recursive case 
        if(node.left != null) {
            dfs(node.left,node.val,lengthSoFar,result);
        }

        if(node.right != null) {
            dfs(node.right,node.val,lengthSoFar,result);
        }
    }
}
