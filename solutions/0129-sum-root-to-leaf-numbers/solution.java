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
    
    public int sumNumbers(TreeNode root) {
        int[] totalSum = {0};
        StringBuilder sb = new StringBuilder();
         dfs(root,sb, totalSum);
         return totalSum[0];
                  
    }

    private void dfs(
        TreeNode node, 
        StringBuilder currentPath, 
        int[] totalSum) {
       
         if(node == null) {
            return;
         }
          
          currentPath.append(node.val);

            //Base case - if leaf node

            if(node.left == null && node.right == null) {
                totalSum[0] += Integer.parseInt(currentPath.toString());
                currentPath.deleteCharAt(currentPath.length()-1);
                return;
            }

            dfs(node.left, currentPath, totalSum);
            dfs(node.right,currentPath,totalSum);

           //backtracking 
           currentPath.deleteCharAt(currentPath.length()-1);

        }
}
