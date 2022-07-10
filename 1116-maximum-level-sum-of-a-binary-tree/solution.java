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
    public int maxLevelSum(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        int maxSum = Integer.MIN_VALUE;
        int minLevel = 0;
        int level = 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            level += 1;
            int total = 0;
            
            for( int i = 0; i < size ; i++) {
                
                TreeNode current = queue.remove();
                
                if(current.left != null) {
                    queue.add(current.left);
                }
                
                if(current.right != null) {
                    queue.add(current.right);
                }
                
                total += current.val;
            }
            
            if(total > maxSum) {
                maxSum = total;
                minLevel = level;
            }
            
        }
        
        return minLevel;
        
    }
}
