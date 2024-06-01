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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> paths = new ArrayList<>();

       // Edge case 
       if(root == null) {
         return result;
       }  

       dfs(root,targetSum,paths,result);

       return result;
        
    }

    private void dfs(
        TreeNode node,
        int targetSum,
        List<Integer> paths,
        List<List<Integer>> result
    ) {

        //add the current node val to the paths
        paths.add(node.val);
        targetSum = targetSum - node.val;

        // Base case (if the current node is the leaf)

         if(node.left == null && node.right == null) {
             if(targetSum == 0) {
                result.add(new ArrayList(paths));
             }
         }

        //Recursive case 

         if(node.left != null) {
            dfs(node.left,targetSum,paths,result);
         }

         if(node.right != null) {
            dfs(node.right,targetSum,paths,result);
         }

        paths.remove(paths.size()-1); 

    }
}
