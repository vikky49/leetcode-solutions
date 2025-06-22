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
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
         result = 0;
         dfs(root);
         return result;
        
    }

    private Pair<Integer,Integer> dfs(TreeNode node) {

        //Base case
        if(node == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer,Integer> leftSum = dfs(node.left);

        Pair<Integer,Integer> righSum = dfs(node.right);


        int totalSum = leftSum.getKey() + righSum.getKey() + node.val;
        int totalCount = leftSum.getValue() + righSum.getValue() + 1;

        if(node.val == totalSum / totalCount) {
            result ++;
        }

        return new Pair<>(totalSum, totalCount);




    }
}
