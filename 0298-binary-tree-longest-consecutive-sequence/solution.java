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
        
        //Edge case 
        
        int[] result = new int[1];
        if(root == null) {
            return 0;
        }
        
        dfs(root,-1,0,result);
        return  result[0];
        
    }
    
    
    private void dfs(
        TreeNode node, 
        int parentValue, 
        int lengthSoFar,
        int[] result) {
        
        // similar to tracking longest consecutive sequence in the array
        //Each worker should know the previous value (parents value)
        
        if(node.val == parentValue + 1) {
            
            lengthSoFar += 1;
            
        } else {
            
            lengthSoFar = 1;
        }
        
        if(lengthSoFar > result[0]) {
            result[0] = lengthSoFar;
        }
        
        //BaseCase
        
        if(node.left == null && node.right == null) {
               ; 
        }
        
        //Recursive case 
        
        if(node.left != null) {
            dfs(node.left,node.val,lengthSoFar,result);
        }
        
        if(node.right != null) {
            dfs(node.right,node.val,lengthSoFar, result);
        }
                
    }
}
