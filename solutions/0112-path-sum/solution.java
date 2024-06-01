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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        boolean[] result = {false};

        dfs(root,targetSum,result);

        return result[0];

    }

    private void dfs(
        TreeNode node,
        int targetSum,
        boolean[] result
    ) {
        //subtract the value 
        targetSum = targetSum - node.val;

        //Base case - If its a leaf node
         
        if(node.left == null && node.right == null) {
            if(targetSum == 0){
                result[0] = true;
            }
        }

        //Recursive case 
        
        if(node.left != null ) {
            dfs(node.left,targetSum,result);
        }

        if(node.right != null) {
            dfs(node.right,targetSum,result);
        }

    }
}
