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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }

        if(root == null) {
            return false;
        }

      return dfs(root, subRoot);
        
    }

    private boolean dfs(TreeNode root, TreeNode subNode) {
        if(root == null) {
            return false;
        }
 
        
        //if the entire sub
        if((root.val == subNode.val) 
          && (isSameTree(root, subNode))) {
            return true;
          }

          return dfs(root.left, subNode) ||
                dfs(root.right,subNode);

    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        // if both are null - its true
        if (a == null && b == null) {
            return true;
        }

        if(a == null || b == null) {
            return false;
        }

        if(a.val != b.val) {
            return false;
        }

        return isSameTree(a.left, b.left) &&
               isSameTree(a.right, b.right);
     }
}
